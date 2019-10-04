package com.j4h.mall.service.reports;

import com.j4h.mall.model.reports.Stat;

public interface StatService {
    Stat statUser();

    Stat statOrder();

    Stat statGoodes();

}
