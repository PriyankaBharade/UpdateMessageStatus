package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.order.dto.FulfillmentOrder;
import com.order.services.StatusService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("order/status")
public class OrderStatusController {
	@Autowired
	StatusService startService;

	@ApiOperation(value = "Fetch Order from the DataBase")
	@GetMapping(value = "/fetch/order")
	List<FulfillmentOrder> getOrder() {
		return startService.getXmlConsume();
	}
	
	@ApiOperation(value = "Fetch Order from the DataBase")
	@GetMapping(value="/fetch/orderbyid/{id}")
	public FulfillmentOrder updateOrderStatus(@PathVariable("id") int Id,@RequestParam("orderStatus") String orderStatus) {
		return startService.updateStatus(Id, orderStatus);
	}
}
