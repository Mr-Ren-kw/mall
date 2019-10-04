package com.j4h.mall.controller.system;

import com.j4h.mall.model.system.LogListVo;
import com.j4h.mall.model.system.StorageQuery;
import com.j4h.mall.service.system.LogService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 23:08
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/log")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("/list")
    public BaseRespVo showStorageList(StorageQuery storageQuery){
        LogListVo logListVo = logService.queryLog(storageQuery);
        return BaseRespVo.ok(logListVo);
    }
}
