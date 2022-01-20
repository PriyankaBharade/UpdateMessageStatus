package com.order.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.FulfillmentOrder;
import com.order.entity.FulfillmentOrderEntity;
import com.order.repo.FulfillOrderRepo;

@Service
public class StatusServiceImpl<FulfillmentOrdeRepo> implements StatusService {
	@Autowired
	FulfillOrderRepo FulfillmentOrdeRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<FulfillmentOrder> getXmlConsume() {
		// TODO Auto-generated method stub
		List<FulfillmentOrderEntity> listEntity = FulfillmentOrdeRepo.findAll();
		List<FulfillmentOrder> orderList = new ArrayList();
		System.out.println("Get all data" + listEntity.toString());
		for (FulfillmentOrderEntity entity : listEntity) {
			FulfillmentOrder order = modelMapper.map(entity, FulfillmentOrder.class);
			orderList.add(order);
		}
		return orderList;
	}

	@Override
	public FulfillmentOrder updateStatus(int orderId, String status) {
		FulfillmentOrderEntity listEntity = FulfillmentOrdeRepo.findByid(orderId);
		listEntity.setOrderStatus(status);
		FulfillmentOrdeRepo.save(listEntity);
		FulfillmentOrder order = modelMapper.map(listEntity, FulfillmentOrder.class);
		return order;
	}

}
