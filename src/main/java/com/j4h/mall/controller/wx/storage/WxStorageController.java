package com.j4h.mall.controller.wx.storage;

import com.j4h.mall.model.system.Storage;
import com.j4h.mall.service.wx.storage.WxStorageService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/wx/storage")
public class WxStorageController {

    @Autowired
    WxStorageService storageService;

    @RequestMapping("/upload")
    public BaseRespVo uploadImg(MultipartFile file) {
        Storage storage = null;
        try {
            storage = storageService.ImgUpload(file);
        } catch (IOException e) {
            return BaseRespVo.fail(499, "图片上传失败");
        }
        return BaseRespVo.ok(storage);
    }
}
