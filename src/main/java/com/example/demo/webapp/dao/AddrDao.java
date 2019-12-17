package com.example.demo.webapp.dao;

import com.example.demo.webapp.domain.Addr;
import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class AddrDao extends AbstractTransactionDAOSupport {

    public List<Addr> findByWhere(Addr t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }
    public int updateByList(List<Addr> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateByList", list);
    }
}
