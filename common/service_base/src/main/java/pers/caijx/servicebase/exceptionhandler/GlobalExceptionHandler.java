package pers.caijx.servicebase.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.caijx.commonutils.R;

/**
 * @ClassName GlobalExceptionHandler
 * @Description: TODO
 * @Author Think
 * @Date 2020/5/25
 * @Version V1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    // 指定出现了什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理....");
    }

    // 特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 为了返回数据
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理....");
    }
}
