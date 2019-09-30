package com.j4h.mall.service.extension.ad;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.AdMapper;
import com.j4h.mall.vo.extension.BeanForData.AdPageData;
import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.vo.extension.BeanForRequest.AdPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService{

    @Autowired
    AdMapper admapper;

    @Override
    public AdPageData queryAdByPage(AdPageRequest adPageRequest) {
        String name = adPageRequest.getName();
        String content = adPageRequest.getContent();
        if(name != null) {
            name = "%" + name + "%";
        }
        if(content != null) {
            content = "%" + content + "%";
        }
        AdPageData adPageData = new AdPageData();
        String orderBy = adPageRequest.getSort() + " " + adPageRequest.getOrder();
        PageHelper.startPage(adPageRequest.getPage(), adPageRequest.getLimit(), orderBy);
        List<Advertise> adList = admapper.queryAdsByCondition(name, content);
        PageInfo<Advertise> adPageInfo = new PageInfo<>(adList);
        long total = adPageInfo.getTotal();
        adPageData.setItems(adList);
        adPageData.setTotal((int)total);
        return adPageData;
    }

    @Override
    public Advertise updateAd(Advertise advertise) {
        admapper.updateAd(advertise);
        return admapper.queryAdById(advertise.getId());
    }

    @Override
    public void deleteAdById(int adId) {
        admapper.deleteAdById(adId);
    }

    @Override
    public Advertise addAd(Advertise advertise) {
        admapper.insertAd(advertise);
        return admapper.queryAdById(advertise.getId());
    }

}
