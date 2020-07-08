package pers.caijx.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.multipart.MultipartFile;
import pers.caijx.eduservice.entity.EduSubject;
import pers.caijx.eduservice.entity.excel.SubjectData;
import pers.caijx.eduservice.listener.SubjectExcelListener;
import pers.caijx.eduservice.mapper.EduSubjectMapper;
import pers.caijx.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.caijx.servicebase.exceptionhandler.BusinessException;

import java.io.IOException;
import java.io.InputStream;

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
}
