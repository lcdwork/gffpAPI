package com.example.demo.webapp.dao;

import com.example.demo.webapp.domain.Station;
import com.riozenc.titanTool.annotation.PaginationSupport;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.spring.webapp.dao.AbstractTransactionDAOSupport;

import java.util.List;

@TransactionDAO
public class StationDao extends AbstractTransactionDAOSupport {

@PaginationSupport
public List<Station> findByWhere(Station t) {
    // TODO Auto-generated method stub
    return getPersistanceManager().find(getNamespace() + ".findByWhere", t);
    }
}
