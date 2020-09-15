package pers.caijx.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.caijx.eduservice.entity.EduChapter;
import pers.caijx.eduservice.entity.EduVideo;
import pers.caijx.eduservice.entity.chapter.ChapterVo;
import pers.caijx.eduservice.entity.chapter.VideoVo;
import pers.caijx.eduservice.mapper.EduChapterMapper;
import pers.caijx.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.caijx.eduservice.service.EduVideoService;
import pers.caijx.servicebase.exceptionhandler.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author JunXiangCai
 * @since 2020-07-12
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {

        // 1. 根据课程id查询课程里面所有的章节
        QueryWrapper<EduChapter> wrapperChapter = new QueryWrapper();
        wrapperChapter.eq("course_id", courseId);
        List<EduChapter> eduChaptersList = baseMapper.selectList(wrapperChapter);

        // 2. 根据课程id查询课程里面所有的小结
        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("course_id", courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(wrapperVideo);

        // 创建list集合，用于最后的封装
        List<ChapterVo> finalList = new ArrayList<>();

        // 3. 遍历查询list集合进行封装
        for (int i = 0; i < eduChaptersList.size(); i++) {
            // 每个章节
            EduChapter eduChapter = eduChaptersList.get(i);
            // eduChapter对象复制到ChapterVo对象里面去
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter, chapterVo);
            // 把chapter放到最终的集合里面去
            finalList.add(chapterVo);

            // 创建集合，用于封装章节的小节
            List<VideoVo> videoList = new ArrayList<>();

            // 4. 遍历查询小结list集合进行封装
            for (int m = 0; m < eduVideoList.size(); m++) {
                // 得到每个小节
                EduVideo eduVideo = eduVideoList.get(m);
                // 判断：小节里面chapterId和章节里面id是否一样
                if (eduChapter.getId().equals(eduVideo.getChapterId())) {
                    // eduVideo对象复制到VideoVo对象里面去
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo, videoVo);
                    // 把VideoVo放到小节封装集合
                    videoList.add(videoVo);
                }
            }
            // 把封装之后的小节，放到chapterVo里面去
            chapterVo.setChildren(videoList);
        }

        return finalList;
    }

    @Override
    public Boolean deleteChapter(String chapterId) {
        // 根据chapterid章节id查询小节表，如果查询到数据，不进行删除
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id", chapterId);
        int count = eduVideoService.count(queryWrapper);
        // 判断
        if (count > 0) { // 查询出小节，不进行删除
            throw new BusinessException(20001,"不能删除");
        } else { // 不能查询数据，进行删除
            // 删除章节
            int result = baseMapper.deleteById(chapterId);
            // 成功 1 > 0 0 > 0
            return result > 0;
        }
    }
}
