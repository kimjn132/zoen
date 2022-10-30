package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.PDto;

public class PDao {
	
	DataSource dataSource;
	public PDao() {
		try {
			Context context = new InitialContext();	// javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public ArrayList<PDto>productListCheck(String sName){
		ArrayList<PDto> dtos = new ArrayList<PDto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pId, pBrand, pName, pStock from product where pBrand = '" + sName + "' order by pId";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("pId");
				String pBrand = rs.getString("pBrand");
				String pName = rs.getString("pName");
				int pStock = rs.getInt("pStock");
				
				PDto dto = new PDto(pId, pBrand, pName, pStock);
				dtos.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}


}
