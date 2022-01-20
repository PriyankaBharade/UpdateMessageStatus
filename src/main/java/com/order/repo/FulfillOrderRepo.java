package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.FulfillmentOrderEntity;


public interface FulfillOrderRepo extends JpaRepository<FulfillmentOrderEntity,Integer>{
	FulfillmentOrderEntity findByid(int id);
	
	//@Transactional
	
	//@Query(value = "UPDATE FulfillmentOrderEntity se SET se.orderStatus = 'Update' WHERE se.id = %:orderId%")
	@Modifying
	@Query(value = "UPDATE FulfillmentOrderEntity fe SET fe.orderStatus = 'Updated' WHERE fe.id = :orderId", nativeQuery = true)
	FulfillmentOrderEntity updateOrderStatus(@Param("orderId") int orderId) ;
}
