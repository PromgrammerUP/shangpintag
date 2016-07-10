package org.javachina.shangpin.service;

import java.util.ArrayList;

import org.javachina.shangpin.dao.LeixingDao;
import org.javachina.shangpin.dto.LeixingDto;

public class LeixingService {
	public ArrayList<LeixingDto> getAllLeixing(){
		return new LeixingDao().queryAll();
	}
}
