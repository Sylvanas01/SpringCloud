package com.hand.hiot.app.service;


import com.hand.hiot.domain.entity.Customer;

import java.util.List;

/**
 * ExampleService
 */
public interface CustomerService {

   List<Customer> getCustomers(Long companyId, String customerNumber, String customerName);
   int addCustomer(Customer customer);

   Long getIdByNumber(String customerNumber);
   String getNameById(Long customerId);
}
