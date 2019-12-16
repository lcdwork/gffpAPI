package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.AddrDao;
import com.example.demo.webapp.domain.Addr;
import com.example.demo.webapp.service.IAddrService;
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
}
