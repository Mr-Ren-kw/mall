package com.j4h.mall.service.configs;

import com.j4h.mall.model.configs.MallSystemMsg;

public interface ConfigService {

    MallSystemMsg getMallSystemMsg();

    boolean updateMallSystemMsg(MallSystemMsg mallSystemMsg);

    MallSystemMsg getMallSystemExpressMsg();

    boolean updateMallSystemExpressMsg(MallSystemMsg mallSystemMsg);

    MallSystemMsg getMallSystemOrderMsg();

    boolean updateMallSystemOrderMsg(MallSystemMsg mallSystemMsg);

    MallSystemMsg getMallSystemWxMsg();

    boolean updateMallSystemWxMsg(MallSystemMsg mallSystemMsg);
}
