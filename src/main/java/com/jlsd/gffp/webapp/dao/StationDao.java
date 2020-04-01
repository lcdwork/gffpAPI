package com.jlsd.gffp.webapp.dao;

import com.jlsd.gffp.webapp.domain.Station;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class StationDao extends AbstractTransactionDAOSupport {

public List<Station> findByWhere(Station t) {
    // TODO Auto-generated method stub
    return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }

    public int updateSuccessList(List<Station> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateSuccessList", list);
    }

    public int updateFailList(List<Station> list) {
        // TODO Auto-generated method stub
        return getPersistanceManager().update(getNamespace() + ".updateFailList", list);
    }
}
