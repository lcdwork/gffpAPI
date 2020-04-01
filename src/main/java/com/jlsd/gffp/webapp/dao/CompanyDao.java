package com.jlsd.gffp.webapp.dao;

import com.jlsd.gffp.webapp.domain.Company;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class CompanyDao extends AbstractTransactionDAOSupport {

    public List<Company> findByWhere(Company t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }

    public int updateSuccessList(List<Company> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateSuccessList", list);
    }

    public int updateFailList(List<Company> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateFailList", list);
    }
}
