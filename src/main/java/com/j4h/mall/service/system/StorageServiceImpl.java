package com.j4h.mall.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.system.StorageMapper;
import com.j4h.mall.model.system.Storage;
import com.j4h.mall.model.system.StorageList;
import com.j4h.mall.model.system.StorageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public StorageList queryStorage(StorageQuery storageQuery) {
        int start = storageQuery.getPage();
        int limit = storageQuery.getLimit();
        String sort = storageQuery.getSort();
        String order = storageQuery.getOrder();
        PageHelper.startPage(start,limit,sort + " " + order);
        String key = storageQuery.getKey();
        if (key == null){
            key = "";
        }
        key = "%" + key + "%";
        String name = storageQuery.getName();
        if(name == null){
            name = "";
        }
        name = "%" + name + "%";
        List<Storage> storages = storageMapper.queryStorages(key,name);
        PageInfo<Storage> storagePageInfo = new PageInfo<>(storages);
        long total = storagePageInfo.getTotal();
        StorageList storageList = new StorageList();
        storageList.setItems(storages);
        storageList.setTotal(total);
        return storageList;
    }

    @Override
    public Storage updateStorage(Storage storage) {
        storage.setUpdateTime(new Date());
        storageMapper.updateStorage(storage);
        // 这边只进行修改数据库中的值，不再查询数据库返回
        return storage;
    }
}
