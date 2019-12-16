package com.example.demo.webapp.dao;

import com.example.demo.webapp.domain.Billmonth;
import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class BillmonthDao extends AbstractTransactionDAOSupport {

    @PaginationSupport
    public List<Billmonth> findByWhere(Billmonth t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }
}
