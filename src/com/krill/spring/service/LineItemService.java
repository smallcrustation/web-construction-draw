package com.krill.spring.service;

import com.krill.spring.entity.LineItem;

public interface LineItemService {
	public LineItem getLineItem(int id);

	public void save(LineItem lineItem);
}
