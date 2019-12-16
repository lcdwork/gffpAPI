package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.StationDao;
import com.example.demo.webapp.domain.Station;
import com.example.demo.webapp.service.IStationService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;

@TransactionService
public class StationServiceImpl implements IStationService {

    @TransactionDAO("gffpOracle")
    private StationDao stationDao;

    @Override
    public List<Station> findByWhere(Station t) {
        return stationDao.findByWhere(t);
    }
}
