package com.j4h.mall.service.configs;

import com.j4h.mall.mapper.configs.ConfigMapper;
import com.j4h.mall.model.configs.MallSystemExpressMsg;
import com.j4h.mall.model.configs.MallSystemMsg;
import com.j4h.mall.model.configs.MallSystemOrderMsg;
import com.j4h.mall.model.configs.MallSystemWxMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigMapper configMapper;

    @Override
    public MallSystemMsg getMallSystemMsg() {

        String name = configMapper.getMallSystemName();
        String address = configMapper.getMallSystemAddress();
        String phone = configMapper.getMallSystemPhone();
        String qq = configMapper.getMallSystemQQ();

        MallSystemMsg mallSystemMsg = new MallSystemMsg(name,address,phone,qq);
        return mallSystemMsg;
    }

    @Override
    public boolean updateMallSystemMsg(MallSystemMsg mallSystemMsg) {
        int update = configMapper.updateMallSystemName(mallSystemMsg);
        int update2 = configMapper.updateMallSystemAddress(mallSystemMsg);
        int update3 = configMapper.updateMallSystemPhone(mallSystemMsg);
        int update4 = configMapper.updateMallSystemQQ(mallSystemMsg);
        return update == update2 && update2==update3 && update3 == update4;
    }

    @Override
    public MallSystemExpressMsg getMallSystemExpressMsg() {
        String min = configMapper.getMallSystemExpressFreightMin();
        String value = configMapper.getMallSystemExpressFreightValue();
        MallSystemExpressMsg mallSystemExpressMsg = new MallSystemExpressMsg();
        mallSystemExpressMsg.setCskaoyan_mall_express_freight_min(min);
        mallSystemExpressMsg.setCskaoyan_mall_express_freight_value(value);
        return mallSystemExpressMsg;
    }

    @Override
    public boolean updateMallSystemExpressMsg(MallSystemExpressMsg mallSystemExpressMsg) {
        int update = configMapper.updateMallSystemExpressFreightMin(mallSystemExpressMsg);
        int update2 = configMapper.updateMallSystemExpressFreightValue(mallSystemExpressMsg);
        return update==update2;
    }

    @Override
    public MallSystemOrderMsg getMallSystemOrderMsg() {
        String comment = configMapper.getMallSystemOrderComment();
        String unconfirm = configMapper.getMallSystemOrderUnconfirm();
        String unpaid = configMapper.getMallSystemOrderUnpaid();
        MallSystemOrderMsg mallSystemOrderMsg = new MallSystemOrderMsg();
        mallSystemOrderMsg.setCskaoyan_mall_order_comment(comment);
        mallSystemOrderMsg.setCskaoyan_mall_order_unconfirm(unconfirm);
        mallSystemOrderMsg.setCskaoyan_mall_order_unpaid(unpaid);

        return mallSystemOrderMsg;
    }

    @Override
    public boolean updateMallSystemOrderMsg(MallSystemOrderMsg mallSystemOrderMsg) {
        int update = configMapper.updateMallSystemOrderComment(mallSystemOrderMsg);
        int update2 = configMapper.updateMallSystemOrderUnconfirm(mallSystemOrderMsg);
        int update3 = configMapper.updateMallSystemOrderUnpaid(mallSystemOrderMsg);
        return update==update2 && update == update3;
    }

    @Override
    public MallSystemWxMsg getMallSystemWxMsg() {
        String goods = configMapper.getMallSystemWxCatlogGoods();
        String list  = configMapper.getMallSystemWxCatlogList();
        String brand = configMapper.getMallSystemWxIndexBrand();
        String hot   = configMapper.getMallSystemWxIndexHot();
        String indexNew = configMapper.getMallSystemWxIndexNew();
        String topic = configMapper.getMallSystemWxIndexTopic();
        String share = configMapper.getMallSystemWxShare();
        MallSystemWxMsg mallSystemWxMsg = new MallSystemWxMsg();
        mallSystemWxMsg.setCskaoyan_mall_wx_catlog_goods(goods);
        mallSystemWxMsg.setCskaoyan_mall_wx_catlog_list(list);
        mallSystemWxMsg.setCskaoyan_mall_wx_index_brand(brand);
        mallSystemWxMsg.setCskaoyan_mall_wx_index_hot(hot);
        mallSystemWxMsg.setCskaoyan_mall_wx_index_new(indexNew);
        mallSystemWxMsg.setCskaoyan_mall_wx_index_topic(topic);
        mallSystemWxMsg.setCskaoyan_mall_wx_share(share);

        return mallSystemWxMsg;
    }

    @Override
    public boolean updateMallSystemWxMsg(MallSystemWxMsg mallSystemWxMsg) {
        int update  = configMapper.updateMallSystemWxCatlogGoods(mallSystemWxMsg);
        int update2 = configMapper.updateMallSystemWxCatlogList(mallSystemWxMsg);
        int update3 = configMapper.updateMallSystemWxIndexBrand(mallSystemWxMsg);
        int update4 = configMapper.updateMallSystemWxIndexHot(mallSystemWxMsg);
        int update5 = configMapper.updateMallSystemWxIndexNew(mallSystemWxMsg);
        int update6 = configMapper.updateMallSystemWxIndexTopic(mallSystemWxMsg);
        int update7 = configMapper.updateMallSystemWxShare(mallSystemWxMsg);

        return true;
    }
}
