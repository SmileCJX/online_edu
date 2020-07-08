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
    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;
}
