package pers.caijx.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.val;
import org.springframework.web.multipart.MultipartFile;
import pers.caijx.eduservice.entity.EduSubject;
import pers.caijx.eduservice.entity.excel.SubjectData;
import pers.caijx.eduservice.entity.subject.OneSubject;
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
        List<EduSubject> list = baseMapper.selectList(wrapperOne);

        // 查询所有二级分类
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0" );

        //创建list集合，用于存储最终封装数据
        List<OneSubject> finalSubjectList = new ArrayList<>();

        // 3 封装一级分类
        // 查询出来所有的一级分类list集合遍历，得到每个一级分类对象，获取每一个一级分类对象值
        // 封装到要求的list集合里面 List<OneSubject> finalSubjectList

        // 4 封装二级分类
        return null;
    }
}
