package com.jlsd.gffp.webapp.service;

import com.jlsd.gffp.webapp.domain.Electricityday;

import java.util.List;

public interface IElectricitydayService {
    public List<Electricityday> findByWhere(Electricityday t);

    public int updateSuccessList(List<Electricityday> list);

    public int updateFailList(List<Electricityday> list);
}
