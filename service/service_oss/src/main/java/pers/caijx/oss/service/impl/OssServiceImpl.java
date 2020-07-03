package pers.caijx.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pers.caijx.oss.service.OssService;
import pers.caijx.oss.utils.ConstantPropertiesUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName OssServiceImpl
 * @Description: TODO
 * @Author JunXiangCai
 * @Date 2020/6/27
 * @Version V1.0
 **/
@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {

        // 工具类获取值
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 获取上传文件的输入流。
            InputStream inputStream = inputStream = file.getInputStream();

            // 获取文件名称
            String fileName = file.getOriginalFilename();

            // 调用OSS方式实现上传
            // 第一个参数，bucket名称
            // 第二个参数，上传到OSS文件路径和文件名称 aa/bb/1.jpg
            // 第三个参数，上传文件输入流
            ossClient.putObject(bucketName, "<yourObjectName>", inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();

            // 把上传之后文件路径返回
            // 需要把上传到阿里云oss路径手动拼接出来
            String url = "";
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
