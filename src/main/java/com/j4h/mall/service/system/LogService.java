package com.j4h.mall.service.system;

import com.j4h.mall.model.system.LogListVo;
import com.j4h.mall.model.system.StorageQuery;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 23:20
 */
public interface LogService {
    LogListVo queryLog(StorageQuery storageQuery);
}
