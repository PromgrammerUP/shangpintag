package org.javachina.shangpin.service;

import java.util.ArrayList;

import org.javachina.shangpin.dao.ShangpinDao;
import org.javachina.shangpin.dto.ShangpinDto;

public class ShangpinService {
	public ArrayList<ShangpinDto> listAll(){
		return new ShangpinDao().queryAll();
	}
	public boolean addShangpin(ShangpinDto dto){
		ShangpinDao dao = new ShangpinDao();
		int i  =  dao.insert(dto);
		if(i==0){
			return false;
		}else{
			return true;
		}
	}
}
