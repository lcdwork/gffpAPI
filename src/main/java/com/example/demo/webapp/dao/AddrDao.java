package com.example.demo.webapp.dao;

import com.example.demo.webapp.domain.Addr;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class AddrDao extends AbstractTransactionDAOSupport {

    public List<Addr> findByWhere(Addr t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }
    public int updateSuccessList(List<Addr> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateSuccessList", list);
    }

    public int updateFailList(List<Addr> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateFailList", list);
    }
}
