package pers.caijx.eduservice.service;

import pers.caijx.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.caijx.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-12
 */
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 课程大纲列表，根据课程ID进行查询
     * @param courseId
     * @return
     */
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    /**
     * 删除章节的方法
     * @param chapterId
     */
    Boolean deleteChapter(String chapterId);
}
