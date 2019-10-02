package com.j4h.mall.controller.systemManage;

import com.j4h.mall.model.systemBean.StorageAdd;
import com.j4h.mall.service.systemService.AdminService;
import com.j4h.mall.service.systemService.StorageService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * @author sld
 * @version 1.0
 * @date 2019/9/30 22:23
 */

@RestController
@CrossOrigin
@RequestMapping("/admin/storage")
public class AdminStorageController {

    @Autowired
    StorageService storageService;

    @Value("${web.upload-path}")
    private String path;

    @PostMapping("/create")
    public BaseRespVo uploadPicture(HttpServletRequest request, @RequestParam("picture") MultipartFile picture) throws IOException {
        if (picture.isEmpty()){
            return BaseRespVo.error(null);
        }
        // name
        String name = picture.getOriginalFilename();
        // key
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String[] split = name.split("\\.");
        System.out.println(Arrays.toString(split));
        String key = name.replace(split[0],uuid);
        // size
        int size = (int) picture.getSize();
        // type
        String type = picture.getContentType();
        // url
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String packagePath = "wx/storage/fetch/";
        String url = basePath + packagePath + key;
        // storage对象
        StorageAdd storageAdd = new StorageAdd();
        storageAdd.setKey(key);
        storageAdd.setName(name);
        storageAdd.setSize(size);
        storageAdd.setUrl(url);
        storageAdd.setType(type);
        storageAdd.setAddTime(new Date().toString()); // storageAdd.setAddTime(new Date());
        storageAdd.setUpdateTime(storageAdd.getAddTime());
        // 存入本地
        URL resource = AdminStorageController.class.getClassLoader().getResource("");
        File localFile = new File(resource.getPath() + "static/" + packagePath + key);
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }
        picture.transferTo(localFile);
        // 存入数据库
        int insert = storageService.addPicture(storageAdd);
        if (insert == 1) {
            return BaseRespVo.ok(storageAdd);
        }
        return BaseRespVo.error(null);
    }
}
