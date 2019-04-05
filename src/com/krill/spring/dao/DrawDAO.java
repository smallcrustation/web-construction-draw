package com.krill.spring.dao;

import java.util.List;

import com.krill.spring.entity.Draw;
import com.krill.spring.entity.LineItem;

public interface DrawDAO {

	Draw getDraw(int drawId);

	void saveDraw(Draw draw);

	//List<LineItem> getLineItems(int drawId);
}
