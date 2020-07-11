package pers.caijx.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import pers.caijx.eduservice.entity.EduSubject;
import pers.caijx.eduservice.entity.excel.SubjectData;
import pers.caijx.eduservice.entity.subject.OneSubject;
import pers.caijx.eduservice.entity.subject.TwoSubject;
import pers.caijx.eduservice.listener.SubjectExcelListener;
import pers.caijx.eduservice.mapper.EduSubjectMapper;
import pers.caijx.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.caijx.servicebase.exceptionhandler.BusinessException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-08
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<OneSubject> getOneTwoSubject() {
        // 查询所有一级分类
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper();
        wrapperOne.eq("parent_id", "0");
        List<EduSubject> oneSubjectlist = baseMapper.selectList(wrapperOne);

        // 查询所有二级分类
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0" );
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);
        
        //创建list集合，用于存储最终封装数据
        List<OneSubject> finalSubjectList = new ArrayList<>();

        // 3 封装一级分类
        // 查询出来所有的一级分类list集合遍历，得到每个一级分类对象，获取每一个一级分类对象值
        // 封装到要求的list集合里面 List<OneSubject> finalSubjectList
        for (int i = 0; i < oneSubjectlist.size(); i++) {
            // 得到oneSubjectList中每个Edusubject对象
            EduSubject eduSubject = oneSubjectlist.get(i);
            // 把eduSubject里面的值获取出来，放到OneSubject里面
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(eduSubject, oneSubject);
            // 把多个OneSubject对象放到finalSubject里面
            finalSubjectList.add(oneSubject);

            // 在一级分类底下循环遍历查询所有的二级分类
            // 创建list集合封装每个一级分类的二级分类
            List<TwoSubject> twoFinalSubject = new ArrayList<>();
            // 遍历二级list集合
            for (int m = 0; m < twoSubjectList.size(); m++) {
                // 获取每个二级分类
                EduSubject tSubject = twoSubjectList.get(m);
                // 判断二级分类parentId是否和一级分类id一样
                if (tSubject.getParentId().equals(eduSubject.getId())) {
                    // 把tSubject值复制到twoSubject里面，放到twoFinalSubject里面
                     TwoSubject twoSubject = new TwoSubject();
                     BeanUtils.copyProperties(tSubject, twoSubject);
                    twoFinalSubject.add(twoSubject);
                }
            }
            // 把一级分类下面所有的二级分类放到一级分类底下
            oneSubject.setChildren(twoFinalSubject);
        }
        return finalSubjectList;
    }
}
