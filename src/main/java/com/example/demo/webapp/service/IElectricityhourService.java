package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Electricityhour;

import java.util.List;

public interface IElectricityhourService {
    public List<Electricityhour> findByWhere(Electricityhour t);
}
