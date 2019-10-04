package com.j4h.mall.service.extension.ad;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.AdMapper;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.vo.extension.BeanForRequest.AdPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService{

    @Autowired
    AdMapper adMapper;

    @Override
    public PageData queryAdByPage(AdPageRequest adPageRequest) {
        String name = adPageRequest.getName();
        String content = adPageRequest.getContent();
        if(name != null) {
            name = "%" + name + "%";
        }
        if(content != null) {
            content = "%" + content + "%";
        }
        PageData adPageData = new PageData<Advertise>();
        String orderBy = adPageRequest.getSort() + " " + adPageRequest.getOrder();
        PageHelper.startPage(adPageRequest.getPage(), adPageRequest.getLimit(), orderBy);
        List<Advertise> adList = adMapper.queryAdsByCondition(name, content);
        PageInfo<Advertise> adPageInfo = new PageInfo<>(adList);
        long total = adPageInfo.getTotal();
        adPageData.setItems(adList);
        adPageData.setTotal((int)total);
        return adPageData;
    }

    @Override
    public Advertise updateAd(Advertise advertise) {
        adMapper.updateAd(advertise);
        return adMapper.queryAdById(advertise.getId());
    }

    @Override
    public void deleteAdById(int adId) {
        adMapper.deleteAdById(adId);
    }

    @Override
    public Advertise addAd(Advertise advertise) {
        adMapper.insertAd(advertise);
        return adMapper.queryAdById(advertise.getId());
    }

}
