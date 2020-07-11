package pers.caijx.eduservice.service;

import org.springframework.web.multipart.MultipartFile;
import pers.caijx.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.caijx.eduservice.entity.subject.OneSubject;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-08
 */
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 添加课程分类
     * @param file
     */
    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getOneTwoSubject();
}
