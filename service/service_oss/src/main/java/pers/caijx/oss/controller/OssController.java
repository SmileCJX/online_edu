package pers.caijx.oss.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.caijx.commonutils.R;
import pers.caijx.oss.service.OssService;

/**
 * @ClassName OssController
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/6/27
 * @Version V1.0
 **/
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping
    @ApiOperation("上传头像的方法")
    public R uploadOssFile(MultipartFile file) {
        // 获取上传文件 MultipartFile
        // 返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
