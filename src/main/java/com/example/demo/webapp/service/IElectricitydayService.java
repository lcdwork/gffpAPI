package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Electricityday;

import java.util.List;
import java.util.Map;

public interface IElectricitydayService {
    public List<Electricityday> findByWhere(Electricityday t);

    public int updateSuccessList(List<Electricityday> list);

    public int updateFailList(List<Electricityday> list);
}
