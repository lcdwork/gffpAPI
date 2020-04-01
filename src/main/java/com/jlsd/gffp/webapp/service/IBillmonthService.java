package com.jlsd.gffp.webapp.service;

import com.jlsd.gffp.webapp.domain.Billmonth;

import java.util.List;

public interface IBillmonthService {
    public List<Billmonth> findByWhere(Billmonth t);

    public int updateSuccessList(List<Billmonth> list);

    public int updateFailList(List<Billmonth> list);
}
