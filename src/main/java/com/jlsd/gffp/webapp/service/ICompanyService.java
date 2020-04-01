package com.jlsd.gffp.webapp.service;

import com.jlsd.gffp.webapp.domain.Company;

import java.util.List;

public interface ICompanyService {
    public List<Company> findByWhere(Company t);

    public int updateSuccessList(List<Company> list);

    public int updateFailList(List<Company> list);
}
