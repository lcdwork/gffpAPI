package com.jlsd.gffp.webapp.service.impl;

import com.jlsd.gffp.webapp.dao.StationDao;
import com.jlsd.gffp.webapp.domain.Station;
import com.jlsd.gffp.webapp.service.IStationService;
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

    @Override
    public int updateSuccessList(List<Station> list) {
        return stationDao.updateSuccessList(list);
    }

    @Override
    public int updateFailList(List<Station> list) {
        return stationDao.updateFailList(list);
    }
}
