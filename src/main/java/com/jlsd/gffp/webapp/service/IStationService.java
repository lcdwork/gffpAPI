package com.jlsd.gffp.webapp.service;

import com.jlsd.gffp.webapp.domain.Station;

import java.util.List;

public interface IStationService {
    public List<Station> findByWhere(Station t);

    public int updateSuccessList(List<Station> list);

    public int updateFailList(List<Station> list);
}
