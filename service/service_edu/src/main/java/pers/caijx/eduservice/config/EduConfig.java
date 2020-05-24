package pers.caijx.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName EduConfig
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/5/24
 * @Version V1.0
 **/
@Configuration
@MapperScan("pers.caijx.eduservice.mapper")
public class EduConfig {
}
