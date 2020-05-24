package pers.caijx.eduservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.caijx.commonutils.R;
import pers.caijx.eduservice.entity.EduTeacher;
import pers.caijx.eduservice.service.EduTeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public R findAllTeacher() {
        // 调用service的方式完成查询所有的操作
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items",list);
    }

    /**
     * 逻辑删除讲师的方法
     * @return
     */
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping({"{id}"})
    public R removeTeacher(@ApiParam(name = "id",value = "讲师ID",required = true)  @PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 分页查询讲师的方法
     * current 当前页
     * limit 每页记录数
     * @return
     */
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit) {
        // 创建page分页对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        // 调用方法实现分页
        // 调用方法时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        eduTeacherService.page(pageTeacher, null);

        long total = pageTeacher.getSize();
        List<EduTeacher> records = pageTeacher.getRecords();

//        Map map = new HashMap();
//        map.put("total",total);
//        map.put("rows",records);
//        return R.ok().data(map);

        return R.ok().data("total",total).data("rows",records);
    }

}

