package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Electricityday;

import java.util.List;

public interface IElectricitydayService {
    public List<Electricityday> findByWhere(Electricityday t);
}
