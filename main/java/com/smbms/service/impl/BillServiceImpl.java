package com.smbms.service.impl;

import com.smbms.entity.Bill;
import com.smbms.mapper.BillMapper;
import com.smbms.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    @Override
    public List<Bill> getLike(String name, int id, int isPayment) {
        return billMapper.getLike(name,id,isPayment);
    }

    @Override
    public List<Bill> getLike1(String name, int id, int isPayment) {
        return null;
    }

    @Override
    public List<Bill> getLimit(Integer fromIndex, Integer pageSize) {
        return null;
    }
}
