package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Electricityhour;

import java.util.List;
import java.util.Map;

public interface IElectricityhourService {
    public List<Electricityhour> findByWhere(Electricityhour t);

    public int updateSuccessList(List<Electricityhour> list);

    public int updateFailList(List<Electricityhour> list);
}
