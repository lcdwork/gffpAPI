package com.example.demo.webapp.dao;

import com.example.demo.webapp.domain.Electricityhour;
import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;
import java.util.Map;

@TransactionDAO
public class ElectricityhourDao extends AbstractTransactionDAOSupport {

    public List<Electricityhour> findByWhere(Electricityhour t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }

    public int updateSuccessList(List<Electricityhour> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateSuccessList", list);
    }

    public int updateFailList(List<Electricityhour> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateFailList", list);
    }
}
