package com.chili.service;

import java.util.List;

import com.chili.pojo.OrderDetail;

public interface OrderDetailService {
	public List<OrderDetail> findODByOrderId(String orderNo);
}
