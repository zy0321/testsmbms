package com.smbms.service.impl;

import com.smbms.entity.Bill;
import com.smbms.entity.Provider;
import com.smbms.mapper.Smbms_providerMapper;
import com.smbms.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    Smbms_providerMapper smbms_providerMapper;

    @Override
    public List<Provider> getById(Integer id) {
        return smbms_providerMapper.getById(id);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public List<Provider> getList(String proCode, String proName, String proContact, String creationDate) {
        return null;
    }

    @Override
    public int add(Provider provider) throws SQLException {
        return smbms_providerMapper.add(provider);
    }

    @Override
    public int update(Provider provider) throws SQLException {
        return smbms_providerMapper.update(provider);
    }

    @Override
    public int del(int id) throws SQLException {
        return smbms_providerMapper.del(id);
    }

    @Override
    public List<Provider> getById2(int id) {
        return null;
    }

    @Override
    public List<Provider> getByLike(Map<String, Object> map) {

        return smbms_providerMapper.getByLike(map);
    }

    @Override
    public List<Bill> getByIds(List<Integer> param) {
        return null;
    }

    @Override
    public List<Provider> getLimit(Integer fromIndex, Integer pageSize) {
        return null;
    }

    @Override
    public Provider getByProCode(String proCode) {
        return smbms_providerMapper.getByProCode(proCode);
    }


}
