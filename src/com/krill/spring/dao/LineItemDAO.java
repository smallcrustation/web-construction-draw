package com.krill.spring.dao;

import com.krill.spring.entity.LineItem;

public interface LineItemDAO {
	public LineItem getLineItem(int id);

	public void save(LineItem lineItem);
}
