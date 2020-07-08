package pers.caijx.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pers.caijx.eduservice.entity.EduSubject;
import pers.caijx.eduservice.entity.excel.SubjectData;
import pers.caijx.eduservice.service.EduSubjectService;
import pers.caijx.servicebase.exceptionhandler.BusinessException;

/**
 * @ClassName SubjectExcelListener
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/7/8
 * @Version V1.0
 **/
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    // 因为SubjectExcelListener不能交给Spring管理，需要自己new,不能注入其他对象
    // 不能实现数据库操作

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {

    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    /**
     * 读取Excel内容，一行一行进行读取
     * @param subjectData
     * @param analysisContext
     */
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (null == subjectData) {
            throw new BusinessException(20001,"文件数据为空");
        }
        // 一行一行读取，每次读取有两个值，第一个值是一级分类，第二个值是二级分类
        // 判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if (null == existOneSubject) { // 没有相同一级分类，进行添加
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName()); // 一级分类名称
            eduSubjectService.save(existOneSubject);
        }

        // 获取一级分类的id值
        String pid = existOneSubject.getId();
        // 添加二级分类
        // 判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(), pid);
        if (null == existTwoSubject) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName()); // 二级分类名称
            eduSubjectService.save(existTwoSubject);
        }
    }

    /**
     * 判断一级分类不能重复添加
     * @param name
     * @return
     */
    private EduSubject existOneSubject(EduSubjectService eduSubjectService,String name) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", name);
        queryWrapper.eq("parent_id", "0");
        EduSubject oneSubject = eduSubjectService.getOne(queryWrapper);
        return oneSubject;
    }

    /**
     * 判断二级分类不能重复添加
     * @param eduSubjectService
     * @param name
     * @return
     */
    private EduSubject existTwoSubject(EduSubjectService eduSubjectService,String name,String pid) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", name);
        queryWrapper.eq("parent_id", pid);
        EduSubject twoSubject = eduSubjectService.getOne(queryWrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
