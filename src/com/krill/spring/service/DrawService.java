package com.krill.spring.service;

import java.util.List;

import com.krill.spring.entity.LineItem;
import com.krill.spring.entity.Draw;

public interface DrawService {
	public Draw getDraw(int drawId);

	public void saveDraw(Draw draw);

	//public List<LineItem> getLineItems(int drawId);
}
