package com.smbms.service;

import com.smbms.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getLike(String name, int id, int isPayment);
    List<Bill> getLike1(String name, int id, int isPayment);
    List<Bill> getLimit(Integer fromIndex, Integer pageSize);
}
