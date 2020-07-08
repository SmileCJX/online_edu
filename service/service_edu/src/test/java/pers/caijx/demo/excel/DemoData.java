package pers.caijx.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName DemoData
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/7/8
 * @Version V1.0
 **/
@Data
public class DemoData {

    // 设置Excel表头名称
    @ExcelProperty("学生编号")
    private Integer sno;

    @ExcelProperty("学生姓名")
    private String sname;
}
