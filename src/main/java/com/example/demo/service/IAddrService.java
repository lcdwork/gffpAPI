package com.example.demo.service;

import com.example.demo.domain.Addr;

import java.util.List;

public interface IAddrService {
    public List<Addr> findByWhere(Addr t);
}
