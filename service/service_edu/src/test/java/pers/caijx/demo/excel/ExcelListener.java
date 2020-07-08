package pers.caijx.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @ClassName ExcelListener
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/7/8
 * @Version V1.0
 **/
public class ExcelListener extends AnalysisEventListener<DemoData> {


    /**
     * 一行行读取excel内容
     * @param demoData
     * @param analysisContext
     */
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("****" + demoData);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("****" + headMap);
    }

    /**
     * 读取完成之后
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
