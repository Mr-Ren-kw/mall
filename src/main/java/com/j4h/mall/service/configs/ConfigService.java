package com.j4h.mall.service.configs;

import com.j4h.mall.model.configs.MallSystemExpressMsg;
import com.j4h.mall.model.configs.MallSystemMsg;
import com.j4h.mall.model.configs.MallSystemOrderMsg;
import com.j4h.mall.model.configs.MallSystemWxMsg;

public interface ConfigService {

    MallSystemMsg getMallSystemMsg();

    boolean updateMallSystemMsg(MallSystemMsg mallSystemMsg);

    MallSystemExpressMsg getMallSystemExpressMsg();

    boolean updateMallSystemExpressMsg(MallSystemExpressMsg mallSystemExpressMsg);

    MallSystemOrderMsg getMallSystemOrderMsg();

    boolean updateMallSystemOrderMsg(MallSystemOrderMsg mallSystemOrderMsg);

    MallSystemWxMsg getMallSystemWxMsg();

    boolean updateMallSystemWxMsg(MallSystemWxMsg mallSystemWxMsg);
}
