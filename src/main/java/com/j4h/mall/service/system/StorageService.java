package com.j4h.mall.service.system;

import com.j4h.mall.model.system.Storage;
import com.j4h.mall.model.system.StorageList;
import com.j4h.mall.model.system.StorageQuery;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 15:19
 */
public interface StorageService {
    int addPicture(Storage storage);
    StorageList queryStorage(StorageQuery storageQuery);
    Storage updateStorage(Storage storage);
}
