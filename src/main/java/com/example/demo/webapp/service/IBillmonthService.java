package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Billmonth;

import java.util.List;
import java.util.Map;

public interface IBillmonthService {
    public List<Billmonth> findByWhere(Billmonth t);

    public int updateSuccessList(List<Billmonth> list);

    public int updateFailList(List<Map> list);
}
