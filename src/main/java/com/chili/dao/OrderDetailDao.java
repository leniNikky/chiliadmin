package com.chili.dao;

import java.util.List;

import com.chili.pojo.OrderDetail;

public interface OrderDetailDao {
	List<OrderDetail> findODByOrderId(String orderNo);
	
}
