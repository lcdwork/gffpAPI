package com.example.demo.webapp.service;

import com.example.demo.webapp.domain.Addr;

import java.util.List;

public interface IAddrService {
    public List<Addr> findByWhere(Addr t);
}
