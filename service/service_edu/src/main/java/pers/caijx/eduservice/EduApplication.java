package pers.caijx.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName EduApplication
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/5/24
 * @Version V1.0
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"pers.caijx"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    " + EduApplication.class.getSimpleName() + "启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
}
