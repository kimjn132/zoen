package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.SDto;


public class SDao {
	
	DataSource dataSource;
	public SDao() {
		try {
			Context context = new InitialContext();	// javax.naming
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public ArrayList<SDto>supplierList(){
		ArrayList<SDto> dtos = new ArrayList<SDto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select sId, sName, sPhone, sEmail from supplier where sEnddate is null";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int sId = rs.getInt("sId");
				String sName = rs.getString("sName");
				String sPhone = rs.getString("sPhone");
				String sEmail = rs.getString("sEmail");
				
				SDto dto = new SDto(sId, sName, sPhone, sEmail);
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
	
	public SDto supplierContentView(String ssId) {
		SDto dto = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from supplier where sId = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(ssId));

			rs = ps.executeQuery();

			if(rs.next()) {
				int sId = rs.getInt("sId");
				String sName = rs.getString("sName");
				String sPhone = rs.getString("sPhone");
				String sEmail = rs.getString("sEmail");
				
				dto = new SDto(sId, sName, sPhone, sEmail);
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
		return dto;
	}
	
	public void supplierModify(SDto sdto) {
		int sId = sdto.getsId();
		String newsName = sdto.getsName();
		String newsPhone = sdto.getsPhone();
		String newsEmail = sdto.getsEmail();
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update supplier set sName = ?, sPhone = ?, sEmail = ? where sId = ? and sInitdate is not null";
			ps = connection.prepareStatement(query);
			
			ps.setString(1, newsName);
			ps.setString(2, newsPhone);
			ps.setString(3, newsEmail);
			ps.setInt(4, sId);
			
			ps.executeUpdate();
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(connection != null) connection.close();

			} catch(Exception e) {
				e.printStackTrace();

			}
		}
	}
	
	
	public void addSupplier(String sName, String sPhone, String sEmail) {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into supplier (sName, sPhone, sEmail, sInitdate) values (?,?,?,now())";
			ps = connection.prepareStatement(query);
			
			ps.setString(1, sName);
			ps.setString(2, sPhone);
			ps.setString(3, sEmail);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(connection != null) connection.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<String>availableS(){
		ArrayList<String> dto = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select sName from supplier where sEnddate is null";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String sName = rs.getString("sName");
				
				dto.add(sName);
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
		return dto;
	}
	
	
//	public void deleteSupplier(int sId) {
//		PreparedStatement ps = null;
//		Connection connection = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "delete from supplier where sId = ?";
//
//			ps = connection.prepareStatement(query);
//			
//			ps.setInt(1, sId);
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
//	
//	}
	
	public void deleteSupplier(int sId) {
		PreparedStatement ps = null;
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update supplier set sEnddate = now() where sId = ?";
			ps = connection.prepareStatement(query);
			
			ps.setInt(1, sId);
			
			ps.executeUpdate();
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(connection != null) connection.close();

			} catch(Exception e) {
				e.printStackTrace();

			}
		}
	}

}
