package com.hand.hiot.app.service;

import com.hand.hiot.domain.entity.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * ExampleService
 */
public interface CompanyService {
   List<Company> getCompanys(String companyNumber, String companyName);
   int addCompany(Company company);
   Long getIdByNumber(String companyNumber);
   String getNameById(Long companyId);
}
