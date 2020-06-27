package pers.caijx.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName pers.caijx.oss.OssApplication
 * @Description: TODO
 * @Author Think
 * @Date 2020/6/27
 * @Version V1.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 在启动类添加属性，默认不去加载数据库配置
@ComponentScan(basePackages = {"pers.caijx"})
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    " + OssApplication.class.getSimpleName() + "启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
}
