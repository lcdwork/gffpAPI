package com.example.demo.webapp.dao;

import com.example.demo.webapp.domain.Electricityday;
import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class ElectricitydayDao extends AbstractTransactionDAOSupport {

    @PaginationSupport
    public List<Electricityday> findByWhere(Electricityday t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }
}
