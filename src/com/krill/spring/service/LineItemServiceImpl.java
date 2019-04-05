package com.krill.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krill.spring.dao.LineItemDAO;
import com.krill.spring.entity.LineItem;

@Service
public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemDAO lineItemDAO;
	
	@Override
	@Transactional
	public LineItem getLineItem(int id) {
		// call dao to get lineItem
		LineItem lineItem = lineItemDAO.getLineItem(id);
		
		return lineItem;
	}

	@Override
	@Transactional
	public void save(LineItem lineItem) {
		// connect to dao and save to db
		lineItemDAO.save(lineItem);
		
	}

}
