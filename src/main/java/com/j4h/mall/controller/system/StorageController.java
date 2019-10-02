package com.j4h.mall.controller.system;

import com.j4h.mall.model.system.Storage;
import com.j4h.mall.model.system.StorageList;
import com.j4h.mall.model.system.StorageQuery;
import com.j4h.mall.service.system.StorageService;
import com.j4h.mall.util.FileUtil;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 15:17
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    @PostMapping("/create")
    public BaseRespVo addPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Storage storage = FileUtil.saveImg(file,request);
        // 存入数据库
        int insert = storageService.addPicture(storage);
        if (insert >= 0) {
            return BaseRespVo.ok(storage);
        }
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setData(null);
        baseRespVo.setErrno(499);
        baseRespVo.setErrmsg("上传失败");
        return baseRespVo;
    }

    @GetMapping("/list")
    public BaseRespVo showStorageList(StorageQuery storageQuery){
        StorageList storageList = storageService.queryStorage(storageQuery);
        return BaseRespVo.ok(storageList);
    }
}
