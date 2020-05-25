package pers.caijx.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BusinessException
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/5/26
 * @Version V1.0
 **/
@Data
@AllArgsConstructor // 生成有参数的构造方法
@NoArgsConstructor // 生成无参数的构造方法
public class BusinessException extends RuntimeException {

    private Integer code; // 状态码

    private String msg; // 异常信息
}
