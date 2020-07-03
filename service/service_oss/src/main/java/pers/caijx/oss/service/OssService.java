package pers.caijx.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OssService
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/6/27
 * @Version V1.0
 **/
public interface OssService {

    /**
     * 上传头像到Oss
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
