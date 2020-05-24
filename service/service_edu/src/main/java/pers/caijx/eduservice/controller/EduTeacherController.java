package pers.caijx.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description = "讲师管理")
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
    @ApiOperation(value = "所有讲师列表")
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
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping({"{id}"})
    public boolean removeTeacher(@ApiParam(name = "id",value = "讲师ID",required = true)  @PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        return flag;
    }

}

