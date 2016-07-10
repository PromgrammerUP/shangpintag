package org.javachina.shangpin.service;

import java.util.ArrayList;

import org.javachina.shangpin.dao.LeixingDao;
import org.javachina.shangpin.dao.ShangpinDao;
import org.javachina.shangpin.dto.LeixingDto;
import org.javachina.shangpin.dto.ShangpinDto;

public class UpdateService {
	public ShangpinDto getById(int id){
		return new ShangpinDao().queryById(id);
	}
	public ArrayList<LeixingDto> getAllLeixing(){
		return new LeixingDao().queryAll();
	}
}
