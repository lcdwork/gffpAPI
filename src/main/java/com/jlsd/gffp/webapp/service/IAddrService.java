package com.jlsd.gffp.webapp.service;

import com.jlsd.gffp.webapp.domain.Addr;

import java.util.List;

public interface IAddrService {
    public List<Addr> findByWhere(Addr t);

    public int updateSuccessList(List<Addr> list);

    public int updateFailList(List<Addr> list);
}
