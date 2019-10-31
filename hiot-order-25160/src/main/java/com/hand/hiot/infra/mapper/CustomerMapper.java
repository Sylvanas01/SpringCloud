package com.hand.hiot.infra.mapper;

import com.hand.hiot.domain.entity.Company;
import com.hand.hiot.domain.entity.Customer;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper
 */

@Component
public interface CustomerMapper extends BaseMapper<Customer> {
    List<Customer> getCustomers(@Param("companyId") Long companyId, @Param("customerNumber") String customerNumber,
                               @Param("customerName") String customerName);

    int addCustomer(Customer customer);
    Long getIdByNumber(String customerNumber);
    String getNameById(Long customerId);
}
