package com.jlsd.gffp.webapp.dao;

import com.jlsd.gffp.webapp.domain.Electricityday;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class ElectricitydayDao extends AbstractTransactionDAOSupport {

    public List<Electricityday> findByWhere(Electricityday t) {
        // TODO Auto-generated method stub
        return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }

    public int updateSuccessList(List<Electricityday> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateSuccessList", list);
    }

    public int updateFailList(List<Electricityday> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateFailList", list);
    }
}
