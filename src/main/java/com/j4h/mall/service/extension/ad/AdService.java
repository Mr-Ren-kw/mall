package com.j4h.mall.service.extension.ad;

import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.vo.extension.BeanForData.AdPageData;
import com.j4h.mall.vo.extension.BeanForRequest.AdPageRequest;

public interface AdService {
    AdPageData queryAdByPage(AdPageRequest adPageRequest);

    Advertise updateAd(Advertise advertise);

    void deleteAdById(int adId);

    Advertise addAd(Advertise advertise);
}
