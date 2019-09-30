package com.j4h.mall.controller.systemManage;

import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author sld
 * @version 1.0
 * @date 2019/9/30 22:23
 */

@RestController
@RequestMapping("/admin/storage")
public class AdminStorageController {

    @Value("${web.upload-path}")
    private String path;

    @PostMapping("/create")
    public BaseRespVo uploadPicture(HttpServletRequest req, MultipartFile file) {
        // 重新写
        return new BaseRespVo();
    }
}
