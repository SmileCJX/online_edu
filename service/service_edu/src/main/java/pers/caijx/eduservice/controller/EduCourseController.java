package pers.caijx.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.caijx.commonutils.R;
import pers.caijx.eduservice.entity.vo.CourseInfoVo;
import pers.caijx.eduservice.service.EduCourseService;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        // 返回添加之后的课程id，为了后面添加大纲使用
        String courseId = eduCourseService.addCourseInfo(courseInfoVo);
        return R.ok().data("courseId",courseId);
    }

    // 根据课程ID查看课程基本信息
    @GetMapping("/getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfo(courseId);
        return R.ok().data("courseInfo", courseInfoVo);
    }

    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

}

