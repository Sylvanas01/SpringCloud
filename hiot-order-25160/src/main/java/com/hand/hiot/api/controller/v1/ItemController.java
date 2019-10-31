package com.hand.hiot.api.controller.v1;

import com.hand.hiot.app.service.ItemService;
import com.hand.hiot.app.service.OrderDetailService;
import com.hand.hiot.app.service.OrderService;
import com.hand.hiot.config.SwaggerTags;
import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.domain.entity.Item;
import com.hand.hiot.domain.entity.OrderDetail;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API接口
 */

@Api(tags = SwaggerTags.ITEM)
@RestController("itemController.v1")
@RequestMapping
public class ItemController {


    @Autowired
    private ItemService itemService;

    @GetMapping("/v1/items")
    @ApiOperation(value = "查询订单汇总信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)

    public ResponseEntity<List<Item>> getItem(
            @ApiParam(value = "物料编号") @RequestParam(value = "itemCode", required = false) String itemCode,
            @ApiParam(value = "物料描述")@RequestParam(value = "itemDescription", required = false) String itemDescription){
        return  Results.success(itemService.getItems(itemCode,itemDescription));
    }

}
