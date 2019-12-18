package com.example.demo.webapp.service.impl;

import com.example.demo.webapp.dao.CompanyDao;
import com.example.demo.webapp.domain.Company;
import com.example.demo.webapp.service.ICompanyService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;
import java.util.Map;

@TransactionService
public class CompanyServiceImpl implements ICompanyService {

    @TransactionDAO("gffpOracle")
    private CompanyDao companyDao;

    @Override
    public List<Company> findByWhere(Company t) {
        return companyDao.findByWhere(t);
    }

    @Override
    public int updateSuccessList(List<Company> list) {
        return companyDao.updateSuccessList(list);
    }

    @Override
    public int updateFailList(List<Map> list) {
        return companyDao.updateFailList(list);
    }
}
