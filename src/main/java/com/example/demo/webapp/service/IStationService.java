package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Station;

import java.util.List;

public interface IStationService {
    public List<Station> findByWhere(Station t);

    public int updateSuccessList(List<Station> list);

    public int updateFailList(List<Station> list);
}
