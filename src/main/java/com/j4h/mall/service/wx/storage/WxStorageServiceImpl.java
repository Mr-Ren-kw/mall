package com.j4h.mall.service.wx.storage;

import com.aliyun.oss.OSSClient;
import com.j4h.mall.config.aliyun.AliyunConfig;
import com.j4h.mall.mapper.system.StorageMapper;
import com.j4h.mall.model.system.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class WxStorageServiceImpl implements WxStorageService{

    @Autowired
    AliyunConfig aliyunConfig;
    @Autowired
    StorageMapper storageMapper;

    @Override
    public Storage ImgUpload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        int index = filename.lastIndexOf('.');
        filename = filename.substring(index);
        String key = UUID.randomUUID().toString().replace("-", "") + filename;
        String bucket = aliyunConfig.getOssConfig().getBucket();
        String endPoint = aliyunConfig.getOssConfig().getEndPoint();
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessSecret = aliyunConfig.getAccessSecret();
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessSecret);
        ossClient.putObject(bucket, key, inputStream);
        Storage storage = new Storage();
        storage.setKey(key);
        storage.setName(file.getOriginalFilename());
        storage.setType(file.getContentType());
        storage.setSize((int) file.getSize());
        storage.setUrl("https://" + bucket + "." + endPoint + "/" + key);
        storageMapper.addImg(storage);
        return storageMapper.queryStorageById(storage.getId());
    }
}
