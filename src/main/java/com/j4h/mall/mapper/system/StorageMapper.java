package com.j4h.mall.mapper.system;

import com.j4h.mall.model.system.Storage;
import com.j4h.mall.model.system.StorageQuery;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 15:23
 */
public interface StorageMapper {
    int addPicture(Storage storage);
    List<Storage> queryStorages(String key, String name);
    // 只修改updateTime和name
    int updateStorage(Storage storage);
}
