package pers.caijx.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OneSubject
 * @Description: 一级分类
 * @Author JunXiangCai
 * @Date 2020/7/11
 * @Version V1.0
 **/
@Data
public class OneSubject {

    private String id;

    private String title;

    private List<TwoSubject> children = new ArrayList<>();
}
