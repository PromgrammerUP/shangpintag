package org.javachina.shangpin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.javachina.shangpin.dto.ShangpinDto;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class ShangpinDao extends BaseDao {
	public ArrayList<ShangpinDto> queryAll(){
		ArrayList<ShangpinDto> result = new ArrayList<>();
		
		Connection conn = this.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String sql = "select s.id,s.name,s.price,s.inputdate,s.leixingid,l.name"
					+ " from shangpin s,leixing l where s.leixingid=l.id order by s.id";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ShangpinDto dto = new ShangpinDto();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				Date inputDate = rs.getDate(4);
				int leixingId = rs.getInt(5);
				String leixingName = rs.getString(6);
				dto.setId(id);
				dto.setName(name);
				dto.setPrice(price);
				dto.setInputDate(inputDate);
				dto.setLeixingId(leixingId);
				dto.setLeixingName(leixingName);
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
	public int insert(ShangpinDto dto){
		int result = 0;
		Connection conn = null;
		conn = this.getConnection();
		String sql = "insert into shangpin (id,name,price,inputdate,leixingid) values(seq_shangpin.nextval,?,?,?,?)";
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setDouble(2, dto.getPrice());
			psmt.setDate(3, dto.getInputDate());
			psmt.setInt(4, dto.getLeixingId());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, psmt, null);
		}
		
		return result;
	}
	public ShangpinDto queryById(int id){
		ShangpinDto dto = new ShangpinDto();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		conn = this.getConnection();
		
		String sql = "select name,price,inputdate,leixingid from shangpin where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()){
				dto.setId(id);
				dto.setName(rs.getString(1));
				dto.setPrice(rs.getDouble(2));
				dto.setInputDate(rs.getDate(3));
				dto.setLeixingId(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, psmt, rs);
		}
		return dto;
	}
	public int update(ShangpinDto dto){
		int i = 0;
		Connection conn = this.getConnection();
		PreparedStatement psmt = null;
		String sql = "update shangpin set name=?,price=?,inputdate=?,leixingid=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setDouble(2, dto.getPrice());
			psmt.setDate(3, dto.getInputDate());
			psmt.setInt(4, dto.getLeixingId());
			psmt.setInt(5, dto.getId());
			i = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, psmt, null);
		}
		return i;
	}
}
