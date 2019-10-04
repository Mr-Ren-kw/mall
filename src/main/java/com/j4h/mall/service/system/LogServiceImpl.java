package com.j4h.mall.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.system.LogMapper;
import com.j4h.mall.model.system.LogListVo;
import com.j4h.mall.model.system.LogVo;
import com.j4h.mall.model.system.StorageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 23:20
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogMapper logMapper;

    @Override
    public LogListVo queryLog(StorageQuery storageQuery) {
        int start = storageQuery.getPage();
        int limit = storageQuery.getLimit();
        String sort = storageQuery.getSort();
        String order = storageQuery.getOrder();
        PageHelper.startPage(start,limit,sort + " " + order);
        String name = storageQuery.getName();
        if(name == null){
            name = "";
        }
        name = "%" + name + "%";
        List<LogVo> logVos = logMapper.queryLogByName(name);
        PageInfo<LogVo> logVoPageInfo = new PageInfo<>(logVos);
        long total = logVoPageInfo.getTotal();
        LogListVo logListVo = new LogListVo();
        logListVo.setTotal(total);
        logListVo.setItems(logVos);
        return logListVo;
    }
}
