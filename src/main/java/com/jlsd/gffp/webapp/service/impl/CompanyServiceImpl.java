package com.jlsd.gffp.webapp.service.impl;

import com.jlsd.gffp.webapp.dao.CompanyDao;
import com.jlsd.gffp.webapp.domain.Company;
import com.jlsd.gffp.webapp.service.ICompanyService;
import com.riozenc.titanTool.annotation.TransactionDAO;
import com.riozenc.titanTool.annotation.TransactionService;

import java.util.List;

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
    public int updateFailList(List<Company> list) {
        return companyDao.updateFailList(list);
    }
}
