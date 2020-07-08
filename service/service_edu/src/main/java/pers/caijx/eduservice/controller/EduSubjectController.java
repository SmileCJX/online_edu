package pers.caijx.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.caijx.commonutils.R;
import pers.caijx.eduservice.service.EduSubjectService;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-08
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    /**
     * 添加课程分类
     * 获取上传过来文件，把文件内容读取出来
     * @param file
     * @return
     */
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        // 上传过来Excel文件
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }
}

