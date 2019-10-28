package com.hand.hiot.api.controller.v1;

import com.hand.hiot.app.service.CompanyService;
import com.hand.hiot.config.SwaggerTags;
import com.hand.hiot.domain.entity.Company;
import com.hand.hiot.infra.feign.CompanyFeign;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.*;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * API接口
 */
@Api(tags = SwaggerTags.COMPANY)
@RestController("companyController.v1")
@RequestMapping
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyFeign companyFeign;

    @ApiOperation(value = "查询公司信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)

    @GetMapping("/v1/companys")
    public ResponseEntity<List<Company>> getCompanys(
            @ApiParam(value = "公司编码", required = false) @RequestParam(value = "companyNumber", required = false) String companyNumber,
        @ApiParam(value = "公司名称", required = false) @RequestParam(value = "companyName", required = false) String companyName) throws UnsupportedEncodingException {

        return Results.success(companyService.getCompanys(companyNumber, companyName));
    }

    @ApiOperation(value = "添加公司信息")
    @PostMapping("/v1/{organizationId}/Addcompany")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    public ResponseEntity addCompanys(
            @ApiParam(value = "organizationId", required = true) @PathVariable("organizationId") Long organizationId,
            @ApiParam(value = "bucketName", required = true) @RequestParam("bucketName") String bucketName,
            @ApiParam(value = "公司编码", required = true) @RequestParam(value = "companyNumber", required = true) String companyNumber,
            @ApiParam(value = "公司名称", required = true) @RequestParam(value = "companyName", required = true) String companyName,
            @ApiParam(value = "公司logo", required = true) @RequestPart("file") MultipartFile file)
    {
            String logoUrl=companyFeign.demo(organizationId, bucketName,file);
            Company company=new Company();
                company.setCompanyLogo(logoUrl);
        company.setCompanyName(companyName);
        company.setCompanyNumber(companyNumber);
        if(companyService.addCompany(company)==1)    {
            return Results.success();
        }
        else
                  return Results.error();
    }
}
