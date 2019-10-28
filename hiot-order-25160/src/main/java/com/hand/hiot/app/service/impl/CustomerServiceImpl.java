package com.hand.hiot.app.service.impl;

import com.hand.hiot.app.service.CompanyService;
import com.hand.hiot.app.service.CustomerService;
import com.hand.hiot.domain.entity.Company;
import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.infra.mapper.CompanyMapper;
import com.hand.hiot.infra.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ExampleServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getCustomers(Long companyId,String customerNumber, String customerName) {
        return customerMapper.getCustomers(companyId, customerNumber, customerName);
    }

        public int addCustomer(Customer customer){
            return customerMapper.addCustomer(customer);
        }
        public  Long getIdByNumber(String customerNumber){
        return customerMapper.getIdByNumber(customerNumber);
        }

    public String getNameById(Long customerId){return customerMapper.getNameById(customerId);}
    }

