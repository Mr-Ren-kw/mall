package com.j4h.mall.service.reports;

import com.j4h.mall.mapper.reports.StatMapper;
import com.j4h.mall.model.reports.Rows;
import com.j4h.mall.model.reports.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatServiceImp implements StatService {
    @Autowired
    StatMapper statMapper;
    @Override
    public Stat statUser() {
        Stat statUser = new Stat();
        String[] columns={"day","users"};
        statUser.setColumns(columns);
        List<Rows> rowsList = statMapper.queryStatUser();
        statUser.setRows(rowsList);
        return statUser;
    }

    @Override
    public Stat statOrder() {
        Stat statOrder= new Stat();
        String[] columns={"day","orders","customers","amount","pcr"};
        statOrder.setColumns(columns);
        List<Rows> rowsList = statMapper.queryStatOrder();
        statOrder.setRows(rowsList);
        return statOrder;

    }

    @Override
    public Stat statGoodes() {
        Stat statGoodes= new Stat();
        String[] columns={"day","orders","products","amount"};
        statGoodes.setColumns(columns);
        List<Rows> rowsList = statMapper.queryStatGoods();
        statGoodes.setRows(rowsList);
        return statGoodes;
    }
}
