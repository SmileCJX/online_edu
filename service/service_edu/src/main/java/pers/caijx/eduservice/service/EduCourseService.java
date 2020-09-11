package pers.caijx.eduservice.service;

import pers.caijx.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.caijx.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-12
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程基本信息的方法
     * @param courseInfoVo
     */
    String addCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);
}
