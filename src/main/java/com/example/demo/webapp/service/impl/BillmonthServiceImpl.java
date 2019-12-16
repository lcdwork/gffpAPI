package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.BillmonthDao;
import com.example.demo.webapp.domain.Billmonth;
import com.example.demo.webapp.service.IBillmonthService;
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
}
