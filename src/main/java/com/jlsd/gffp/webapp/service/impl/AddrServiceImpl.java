package com.jlsd.gffp.webapp.service.impl;

import com.jlsd.gffp.webapp.dao.AddrDao;
import com.jlsd.gffp.webapp.domain.Addr;
import com.jlsd.gffp.webapp.service.IAddrService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;

@TransactionService
public class AddrServiceImpl implements IAddrService {

    @TransactionDAO("gffpOracle")
    private AddrDao addrDao;

    @Override
    public List<Addr> findByWhere(Addr t) {
        return addrDao.findByWhere(t);
    }

    @Override
    public int updateSuccessList(List<Addr> list) {
        return addrDao.updateSuccessList(list);
    }

    @Override
    public int updateFailList(List<Addr> list) {
        return addrDao.updateFailList(list);
    }
}
