package com.jlsd.gffp.webapp.service;

import com.jlsd.gffp.webapp.domain.Electricityhour;

import java.util.List;

public interface IElectricityhourService {
    public List<Electricityhour> findByWhere(Electricityhour t);

    public int updateSuccessList(List<Electricityhour> list);

    public int updateFailList(List<Electricityhour> list);
}
