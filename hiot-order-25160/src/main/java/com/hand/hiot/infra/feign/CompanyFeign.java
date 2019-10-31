package com.hand.hiot.infra.feign;


import com.hand.hiot.config.FeignConfig;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name="hzero-file",url="http://172.16.211.161:8080/hfle",configuration = FeignConfig.class)
public interface CompanyFeign {
    @PostMapping(value = "/v1/{organizationId}/files/multipart"
            ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String demo(
            @ApiParam(value = "organizationId", required = true) @PathVariable("organizationId") Long organizationId,
            @ApiParam(value = "bucketName", required = true) @RequestParam("bucketName") String bucketName,
            @ApiParam(value = "file") @RequestPart("file") MultipartFile file);
}
