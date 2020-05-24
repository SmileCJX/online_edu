package pers.caijx.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.caijx.eduservice.entity.EduTeacher;
import pers.caijx.eduservice.service.EduTeacherService;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    /**
     * 把service注入
     */
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询讲师列表所有数据
     * 访问地址为http://localhost:8001/eduservice/teacher/findAll
     * @return
     */
    @GetMapping("/findAll")
    public List<EduTeacher> findAllTeacher() {
        // 调用service的方式完成查询所有的操作
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    /**
     * 逻辑删除讲师的方法
     * @return
     */
    @DeleteMapping({"id"})
    public boolean removeTeacher(@PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        return flag;
    }

}

