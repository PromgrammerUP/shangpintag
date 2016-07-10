package org.javachina.shangpin.service;

import org.javachina.shangpin.dao.ShangpinDao;
import org.javachina.shangpin.dto.ShangpinDto;

public class UpdateDoService {
	public boolean updateSp(ShangpinDto dto){
		
		int i = new ShangpinDao().update(dto);
		if(i==0){
			return false;
		}else{
			return true;
		}
	}
}
