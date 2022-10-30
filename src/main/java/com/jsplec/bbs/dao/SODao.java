package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.component.SOrderList;
import com.jsplec.bbs.dto.SODto;

public class SODao {
	DataSource dataSource;

	public SODao() {
		try {
			Context context = new InitialContext();	// javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<SOrderList>sOrderList(){
		ArrayList<SOrderList> dtos = new ArrayList<SOrderList>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			// 발주번호, 브랜드, 상품명, 사이즈, 수량, 발주일
			String query = "select so.soId, p.pBrand, p.pName, p.pSize, so.soQuantity, so.soSenddate ";
			String query2 = "from sorders so inner join product p on so.soProduct_pId = p.pId ";
			String query3 = "where so.soGetdate is null";

			ps = connection.prepareStatement(query + query2 + query3);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int soId = rs.getInt("soId");
				String pBrand = rs.getString("pBrand");
				String pName = rs.getString("pName");
				int pSize = rs.getInt("pSize");
				int soQuantity = rs.getInt("soQuantity");
				Timestamp soSenddate = rs.getTimestamp("soSenddate");
				
				SOrderList dto = new SOrderList(soId, pBrand, pName, pSize, soQuantity, soSenddate);
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
	
//	public void placeSOrders (){
//		Connection connection = null;
//		PreparedStatement ps = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "insert into sorders (sName, sPhone, sEmail, sInitdate) values (?,?,?,now())";
//			ps = connection.prepareStatement(query);
//			
//			ps.setString(1, sName);
//			ps.setString(2, sPhone);
//			ps.setString(3, sEmail);
//			
//			ps.executeUpdate();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(ps != null) ps.close();
//				if(connection != null) connection.close();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		
	}
	

	

