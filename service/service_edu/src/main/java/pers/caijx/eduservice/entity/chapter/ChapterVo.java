package pers.caijx.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChapterVo
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/8/3
 * @Version V1.0
 **/
@Data
public class ChapterVo {

    private String id;

    private String title;

    private List<VideoVo> children = new ArrayList<>();
}
