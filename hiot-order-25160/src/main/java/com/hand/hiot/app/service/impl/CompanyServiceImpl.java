package com.hand.hiot.app.service.impl;

import com.hand.hiot.app.service.CompanyService;
import com.hand.hiot.domain.entity.Company;
import com.hand.hiot.infra.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ExampleServiceImpl
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public List<Company> getCompanys(String companyNumber, String companyName) {
        return companyMapper.getCompanys(companyNumber, companyName);
    }

    public int addCompany(Company company){
      return companyMapper.addCompany(company);
    }
    public Long getIdByNumber(String companyNumber){return companyMapper.getIdByNumber(companyNumber);}
    public String getNameById(Long companyId){return companyMapper.getNameById(companyId);}
}
