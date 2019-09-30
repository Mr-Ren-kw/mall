package com.j4h.mall.service.configs;

import com.j4h.mall.mapper.configs.ConfigMapper;
import com.j4h.mall.model.configs.MallSystemMsg;
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
    public MallSystemMsg getMallSystemExpressMsg() {
        String min = configMapper.getMallSystemExpressFreightMin();
        String value = configMapper.getMallSystemExpressFreightValue();
        MallSystemMsg mallSystemMsg = new MallSystemMsg();
        mallSystemMsg.setCskaoyan_mall_express_freight_min(min);
        mallSystemMsg.setCskaoyan_mall_express_freight_value(value);
        return mallSystemMsg;
    }

    @Override
    public boolean updateMallSystemExpressMsg(MallSystemMsg mallSystemMsg) {
        int update = configMapper.updateMallSystemExpressFreightMin(mallSystemMsg);
        int update2 = configMapper.updateMallSystemExpressFreightValue(mallSystemMsg);
        return update==update2;
    }

    @Override
    public MallSystemMsg getMallSystemOrderMsg() {
        String comment = configMapper.getMallSystemOrderComment();
        String unconfirm = configMapper.getMallSystemOrderUnconfirm();
        String unpaid = configMapper.getMallSystemOrderUnpaid();
        MallSystemMsg mallSystemMsg = new MallSystemMsg();
        mallSystemMsg.setCskaoyan_mall_order_comment(comment);
        mallSystemMsg.setCskaoyan_mall_order_unconfirm(unconfirm);
        mallSystemMsg.setCskaoyan_mall_order_unpaid(unpaid);

        return mallSystemMsg;
    }

    @Override
    public boolean updateMallSystemOrderMsg(MallSystemMsg mallSystemMsg) {
        int update = configMapper.updateMallSystemOrderComment(mallSystemMsg);
        int update2 = configMapper.updateMallSystemOrderUnconfirm(mallSystemMsg);
        int update3 = configMapper.updateMallSystemOrderUnpaid(mallSystemMsg);
        return update==update2 && update == update3;
    }

    @Override
    public MallSystemMsg getMallSystemWxMsg() {
        String goods = configMapper.getMallSystemWxCatlogGoods();
        String list  = configMapper.getMallSystemWxCatlogList();
        String brand = configMapper.getMallSystemWxIndexBrand();
        String hot   = configMapper.getMallSystemWxIndexHot();
        String indexNew = configMapper.getMallSystemWxIndexNew();
        String topic = configMapper.getMallSystemWxIndexTopic();
        String share = configMapper.getMallSystemWxShare();
        MallSystemMsg mallSystemMsg = new MallSystemMsg();
        mallSystemMsg.setCskaoyan_mall_wx_catlog_goods(goods);
        mallSystemMsg.setCskaoyan_mall_wx_catlog_list(list);
        mallSystemMsg.setCskaoyan_mall_wx_index_brand(brand);
        mallSystemMsg.setCskaoyan_mall_wx_index_hot(hot);
        mallSystemMsg.setCskaoyan_mall_wx_index_new(indexNew);
        mallSystemMsg.setCskaoyan_mall_wx_index_topic(topic);
        mallSystemMsg.setCskaoyan_mall_wx_share(share);

        return mallSystemMsg;
    }

    @Override
    public boolean updateMallSystemWxMsg(MallSystemMsg mallSystemMsg) {
        int update  = configMapper.updateMallSystemWxCatlogGoods(mallSystemMsg);
        int update2 = configMapper.updateMallSystemWxCatlogList(mallSystemMsg);
        int update3 = configMapper.updateMallSystemWxIndexBrand(mallSystemMsg);
        int update4 = configMapper.updateMallSystemWxIndexHot(mallSystemMsg);
        int update5 = configMapper.updateMallSystemWxIndexNew(mallSystemMsg);
        int update6 = configMapper.updateMallSystemWxIndexTopic(mallSystemMsg);
        int update7 = configMapper.updateMallSystemWxShare(mallSystemMsg);

        return true;
    }
}
