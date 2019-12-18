package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Station;

import java.util.List;
import java.util.Map;

public interface IStationService {
    public List<Station> findByWhere(Station t);

    public int updateSuccessList(List<Station> list);

    public int updateFailList(List<Map> list);
}
