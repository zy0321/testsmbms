package com.smbms.service;

import com.smbms.entity.Bill;
import com.smbms.entity.Provider;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProviderService {
    List<Provider> getById(Integer id);

    int getCount();

    List<Provider> getList(String proCode,
                           String proName,
                           String proContact,
                           String creationDate);

    int add(Provider provider) throws Exception;

    int update(Provider provider) throws SQLException;

    int del(int id) throws SQLException;

    List<Provider> getById2(int id);

    List<Provider> getByLike(Map<String, Object> map);

    List<Bill> getByIds(List<Integer> param);

    List<Provider> getLimit(Integer fromIndex, Integer pageSize);

    Provider getByProCode(String proCode);
}
