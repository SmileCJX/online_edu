package pers.caijx.eduservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.caijx.eduservice.entity.EduCourse;
import pers.caijx.eduservice.entity.EduCourseDescription;
import pers.caijx.eduservice.entity.vo.CourseInfoVo;
import pers.caijx.eduservice.mapper.EduCourseMapper;
import pers.caijx.eduservice.service.EduCourseDescriptionService;
import pers.caijx.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.caijx.servicebase.exceptionhandler.BusinessException;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-12
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Override
    public void addCourseInfo(CourseInfoVo courseInfoVo) {
        // 1 向课程表中添加课程基本信息
        // CourseInfoVo对象转换为EduCourse对象
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);

        if (insert <= 0) {
            throw new BusinessException(20001,"添加课程信息失败");
        }

        // 2 向课程简介表中添加课程简介
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.save(eduCourseDescription);
    }
}
