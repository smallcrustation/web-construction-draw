package com.krill.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krill.spring.dao.DrawDAO;
import com.krill.spring.entity.Draw;
import com.krill.spring.entity.LineItem;

@Service
public class DrawServiceImpl implements DrawService {

	@Autowired
	DrawDAO drawDAO;

	@Override
	@Transactional
	public Draw getDraw(int drawId) {
		Draw draw = drawDAO.getDraw(drawId);
		
		return draw;
	}

	@Override
	@Transactional
	public void saveDraw(Draw draw) {
		drawDAO.saveDraw(draw);
		
	}

//	@Override
//	@Transactional
//	public List<LineItem> getLineItems(int drawId) {
//		List<LineItem> lineItemList = drawDAO.getLineItems(drawId);
//		return lineItemList;
//	}
	
	

}
