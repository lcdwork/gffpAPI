package com.jlsd.gffp.webapp.service.impl;

import com.jlsd.gffp.webapp.dao.BillmonthDao;
import com.jlsd.gffp.webapp.domain.Billmonth;
import com.jlsd.gffp.webapp.service.IBillmonthService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;

@TransactionService
public class BillmonthServiceImpl implements IBillmonthService {

    @TransactionDAO("gffpOracle")
    private BillmonthDao billmonthDao;

    @Override
    public List<Billmonth> findByWhere(Billmonth t) {
        return billmonthDao.findByWhere(t);
    }

    @Override
    public int updateSuccessList(List<Billmonth> list) {
        return billmonthDao.updateSuccessList(list);
    }

    @Override
    public int updateFailList(List<Billmonth> list) {
        return billmonthDao.updateFailList(list);
    }
}
