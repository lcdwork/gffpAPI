package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.ElectricityhourDao;
import com.example.demo.webapp.domain.Electricityhour;
import com.example.demo.webapp.service.IElectricityhourService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;

@TransactionService
public class ElectricityhourServiceImpl implements IElectricityhourService {

    @TransactionDAO("gffpOracle")
    private ElectricityhourDao electricityhourDao;

    @Override
    public List<Electricityhour> findByWhere(Electricityhour t) {
        return electricityhourDao.findByWhere(t);
    }
}
