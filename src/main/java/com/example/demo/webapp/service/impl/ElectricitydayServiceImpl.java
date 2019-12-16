package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.ElectricitydayDao;
import com.example.demo.webapp.domain.Electricityday;
import com.example.demo.webapp.service.IElectricitydayService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;

@TransactionService
public class ElectricitydayServiceImpl implements IElectricitydayService {

    @TransactionDAO("gffpOracle")
    private ElectricitydayDao electricitydayDao;

    @Override
    public List<Electricityday> findByWhere(Electricityday t) {
        return electricitydayDao.findByWhere(t);
    }
}
