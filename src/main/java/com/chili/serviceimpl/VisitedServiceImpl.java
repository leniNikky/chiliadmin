package com.chili.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chili.dao.VisitedDao;
import com.chili.service.VisitedService;
@Service("VisitedService")
@Transactional
public class VisitedServiceImpl implements VisitedService {

	@Autowired
	private VisitedDao visitedDao;
	public int visitedCount() {
		int a = visitedDao.visitedCount();
		return a;
	}

}
