package com.hand.hiot.api.controller.v1;

import com.hand.hiot.app.service.CustomerService;
import com.hand.hiot.config.SwaggerTags;
import com.hand.hiot.domain.entity.Customer;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * API接口
 */
@Api(tags = SwaggerTags.CUSTOMER)
@RestController("customerController.v1")
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @ApiOperation(value = "查询所有客户信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)

    @GetMapping("/v1/customers")
    public ResponseEntity<List<Customer>> getCustomers(
        @ApiParam(value = "客户所在公司ID", required = true) @RequestParam(value = "companyId", required = true) Long companyId,
        @ApiParam(value = "客户编码", required = false) @RequestParam(value = "customerNumber", required = false) String customerNumber,
        @ApiParam(value = "客户名称", required = false) @RequestParam(value = "customerName", required = false) String customerName)
    {
        return Results.success(customerService.getCustomers(companyId, customerNumber,customerName));
    }


    @ApiOperation(value = "添加客户信息")
    @PostMapping("/v1/Addcustomer")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    public ResponseEntity addCustomer(
            @ApiParam(value = "客户信息", required = true) @RequestBody List<Customer> customerList){
            for ( Customer customer: customerList) {
               customerService.addCustomer(customer);
        }
            return Results.success();
    }

}
