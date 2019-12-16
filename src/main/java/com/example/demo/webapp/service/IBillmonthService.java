package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Billmonth;

import java.util.List;

public interface IBillmonthService {
    public List<Billmonth> findByWhere(Billmonth t);
}
