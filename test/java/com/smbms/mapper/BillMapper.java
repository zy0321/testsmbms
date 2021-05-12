package com.smbms.mapper;

import com.smbms.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BillMapper {
    List<Bill> getLike(@Param("name") String name, @Param("id") int id, @Param("isPayment") int isPayment);
    List<Bill> getLike1(@Param("name") String name, @Param("id") int id, @Param("isPayment") int isPayment);
    List<Bill> getLimit(@Param("fromIndex") Integer fromIndex, @Param("pageSize") Integer pageSize);
}
