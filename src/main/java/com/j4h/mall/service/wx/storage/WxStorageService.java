package com.j4h.mall.service.wx.storage;

import com.j4h.mall.model.system.Storage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface WxStorageService {
    Storage ImgUpload(MultipartFile file) throws IOException;
}
