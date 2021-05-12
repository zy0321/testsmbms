package com.smbms.mapper;

import com.smbms.entity.Bill;
import com.smbms.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface Smbms_providerMapper {

    List<Provider> getById(@Param("id") Integer id);

    int getCount();

    List<Provider> getList(@Param("proCode") String proCode,
                           @Param("proName") String proName,
                           @Param("proContact") String proContact,
                           @Param("creationDate") String creationDate);

    int add(Provider provider);

    int update(Provider provider);

    int del(int id);

    List<Provider> getById2(int id);

    List<Provider> getByLike(Map<String, Object> map);

    List<Bill> getByIds(@Param("param") List<Integer> param);

    List<Provider> getLimit(@Param("fromIndex") Integer fromIndex, @Param("pageSize") Integer pageSize);

    Provider getByProCode(String proCode);
}
