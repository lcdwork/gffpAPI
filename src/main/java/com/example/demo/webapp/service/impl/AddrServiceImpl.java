package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.AddrDao;
import com.example.demo.webapp.domain.Addr;
import com.example.demo.webapp.service.IAddrService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;
import java.util.Map;

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
    public int updateFailList(List<Map> list) {
        return addrDao.updateFailList(list);
    }
}
