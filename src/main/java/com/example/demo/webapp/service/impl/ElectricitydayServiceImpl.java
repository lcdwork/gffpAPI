package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.ElectricitydayDao;
import com.example.demo.webapp.domain.Electricityday;
import com.example.demo.webapp.service.IElectricitydayService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;
import java.util.Map;

@TransactionService
public class ElectricitydayServiceImpl implements IElectricitydayService {

    @TransactionDAO("gffpOracle")
    private ElectricitydayDao electricitydayDao;

    @Override
    public List<Electricityday> findByWhere(Electricityday t) {
        return electricitydayDao.findByWhere(t);
    }

    @Override
    public int updateSuccessList(List<Electricityday> list) {
        return electricitydayDao.updateSuccessList(list);
    }

    @Override
    public int updateFailList(List<Electricityday> list) {
        return electricitydayDao.updateFailList(list);
    }
}
