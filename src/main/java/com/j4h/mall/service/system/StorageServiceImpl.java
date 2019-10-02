package com.j4h.mall.service.system;

import com.j4h.mall.mapper.system.StorageMapper;
import com.j4h.mall.model.system.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 15:19
 */
@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
    StorageMapper storageMapper;


    @Override
    public int addPicture(Storage storage) {
        return storageMapper.addPicture(storage);
    }
}
