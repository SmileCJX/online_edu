package pers.caijx.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestEasyExcel
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/7/8
 * @Version V1.0
 **/
public class TestEasyExcel {

    public static void main(String[] args) {
//        // 1.设置写入的文件夹地址和excel文件名称
//        String fileName = "F:\\write.xlsx";
//
//        // 2.调用easyexcel里面的方式实现写操作
//        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
//        EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());

        // 实现Excel读操作
        String fileName = "F:\\write.xlsx";
        EasyExcel.read(fileName, DemoData.class, new ExcelListener()).sheet().doRead();
    }

    /**
     * 创建方法返回list集合
     * @return
     */
    private static List getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setSno(i);
            demoData.setSname("lucy" + i);
            list.add(demoData);
        }
        return list;
    }
}
