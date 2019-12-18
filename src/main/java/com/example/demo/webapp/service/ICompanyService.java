package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Company;

import java.util.List;
import java.util.Map;

public interface ICompanyService {
    public List<Company> findByWhere(Company t);

    public int updateSuccessList(List<Company> list);

    public int updateFailList(List<Map> list);
}
