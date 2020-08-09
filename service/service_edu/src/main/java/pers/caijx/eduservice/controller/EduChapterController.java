package pers.caijx.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.caijx.commonutils.R;
import pers.caijx.eduservice.entity.chapter.ChapterVo;
import pers.caijx.eduservice.service.EduChapterService;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/eduservice/educhapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;


    /**
     * 课程大纲列表，根据课程ID进行查询
     * @return
     */
    @GetMapping("/getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("allChapterVideo",list);
    }
}

