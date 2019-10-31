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
public interface CompanyMapper extends BaseMapper<Company> {
    List<Company> getCompanys(@Param("companyNumber") String companyNumber, @Param("companyName") String companyName);
    int addCompany(Company company);
    Long getIdByNumber(String companyNumber);
    String getNameById(Long companyId);
}
