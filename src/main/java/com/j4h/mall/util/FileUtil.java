package com.j4h.mall.util;

import com.alibaba.druid.util.StringUtils;
import com.j4h.mall.config.Constant;
import com.j4h.mall.model.system.Storage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 15:57
 */
public class FileUtil {
    public static Storage saveImg(MultipartFile file, HttpServletRequest request) {
        //获取文件上传的根目录 C:\Users\wanghao/upload/img
        String path = Constant.UPLOAD_PATH + Constant.IMG_FILE_NAME;

        //拿到文件的后缀名和UUID进行拼接形成新的文件名
        //4ca64e85b1544c96b4a6154bb521476f.jpg
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String key = uuid + "." + getFileSuffix(file.getOriginalFilename());
        // name
        String name = file.getOriginalFilename();
        // size
        int size = (int)file.getSize();
        // type
        String type = file.getContentType();
        // url
        String contextPath = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
        String url = basePath + Constant.VIRTUAL_IMG_PATH + key;
        // storage对象
        Storage storage = new Storage();
        storage.setKey(key);
        storage.setName(name);
        storage.setSize(size);
        storage.setUrl(url);
        storage.setType(type);
        storage.setAddTime(new Date());
        storage.setUpdateTime(storage.getAddTime());
        // 保存
        try {
            // 保存文件图片
            File targetFile = new File(path);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(new File(path + "/" + key));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return storage;
    }

    private static String getFileSuffix(String path) {
        return getFileSuffix(path, "2");
    }

    private static String getFileSuffix(String path, String type) {
        if ((!StringUtils.isEmpty(path)) && path.indexOf(".") > 0) {
            // 名称
            String name = path.substring(0, path.lastIndexOf("."));
            // 后缀
            String suffix = path.substring(path.lastIndexOf(".") + 1);
            return StringUtils.equals("1", type) ? name : suffix;
        } else {
            return null;
        }
    }
}
