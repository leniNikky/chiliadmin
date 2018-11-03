package com.chili.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chili.dao.OrderDetailDao;
import com.chili.pojo.OrderDetail;
import com.chili.service.OrderDetailService;
@Service("OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	public List<OrderDetail> findODByOrderId(String orderNo) {
		List<OrderDetail> o = orderDetailDao.findODByOrderId(orderNo);
		return o;
	}

}
