package com.j4h.mall.service.systemService;

import com.j4h.mall.mapper.systemManageMapper.StorageMapper;
import com.j4h.mall.model.systemBean.StorageAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 13:04
 */
@Service
public class StorageServiceImpl implements StorageService{

    @Autowired
    StorageMapper storageMapper;

    /**
     * 添加图片传递给所需要用到的bean
     * @param storageAdd
     * @return
     */
    @Override
    public int addPicture(StorageAdd storageAdd) {
        return storageMapper.addPicture(storageAdd);
    }
}
