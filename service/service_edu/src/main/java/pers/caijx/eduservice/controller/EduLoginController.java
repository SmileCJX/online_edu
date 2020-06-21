package pers.caijx.eduservice.controller;

import org.springframework.web.bind.annotation.*;
import pers.caijx.commonutils.R;

/**
 * @ClassName EduLoginController
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/6/21
 * @Version V1.0
 **/
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin // 解决跨域问题
public class EduLoginController {

    /**
     * login
     * @return
     */
    @PostMapping("/login")
    public R login() {
        return R.ok().data("token","admin");
    }

    /**
     * info
     * @return
     */
    @GetMapping("/info")
    public R getInfo() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
