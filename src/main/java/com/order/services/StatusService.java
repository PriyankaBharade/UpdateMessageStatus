package com.order.services;

import java.util.List;

import com.order.dto.FulfillmentOrder;

public interface StatusService {
	public List<FulfillmentOrder> getXmlConsume();

	public FulfillmentOrder updateStatus(int orderId, String status);
}
