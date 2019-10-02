package com.j4h.mall.service.systemService;

import com.j4h.mall.mapper.systemManageMapper.StorageMapper;
import com.j4h.mall.model.systemBean.StorageAdd;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 13:04
 */
public interface StorageService {
    int addPicture(StorageAdd storageAdd);
}
