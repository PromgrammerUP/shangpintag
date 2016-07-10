package org.javachina.shangpin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.javachina.shangpin.dto.LeixingDto;

public class LeixingDao extends BaseDao {
	public ArrayList<LeixingDto> queryAll(){
		ArrayList<LeixingDto> result = new ArrayList<>();
		
		Connection conn = this.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String sql = "select id,name from leixing";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				LeixingDto dto = new LeixingDto();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				dto.setLeixingId(id);;
				dto.setLeixingName(name);
				result.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, stat, rs);
		}
		return result;
	}
}
