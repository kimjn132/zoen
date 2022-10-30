package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.SessionTrackingMode;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.ZDto;
import com.mysql.cj.Session;

public class ZDao {
	
	DataSource dataSource;
	public ZDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	// 제품 검색
		public ArrayList<ZDto> List(){
			ArrayList<ZDto> dtos = new ArrayList<ZDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select pId, pName, pColor, pSize, pDetail, pSaleprice, pCategory, pBrand from product ";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int pId = resultSet.getInt("pId");
					String pName = resultSet.getString("pName");
					String pColor = resultSet.getString("pColor");
					int pSize = resultSet.getInt("pSize");
					String pDetail = resultSet.getString("pDetail");
					int pSaleprice = resultSet.getInt("pSaleprice");
					String pCategory = resultSet.getString("pCategory");
					String pBrand = resultSet.getString("pBrand");
					
					
					
					ZDto dto = new ZDto(pId, pName, pColor, pSize, pDetail, pSaleprice, pCategory, pBrand);
					dtos.add(dto);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dtos;
		} // list
		
		
		public ZDto detail(String sSeq) {
			ZDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select * from product where pId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(sSeq));
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					int pId = resultSet.getInt("pId");
					String pName = resultSet.getString("pName");
					String pColor = resultSet.getString("pColor");
					int pSize = resultSet.getInt("pSize");
					String pDetail = resultSet.getString("pDetail");
					int pSaleprice = resultSet.getInt("pSaleprice");
					String pCategory = resultSet.getString("pCategory");
					String pBrand = resultSet.getString("pBrand");
					
					dto = new ZDto(pId, pName, pColor, pSize, pDetail, pSaleprice, pCategory, pBrand);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dto;
			
		} // Content_view
	
		
		
		public ZDto customer() {
			
			ZDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select cId, cAddress, cEmail, cPhone from customer where cId = 'abcd' ";
				preparedStatement = connection.prepareStatement(query);
				
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					String cId = resultSet.getString("cId");
					String cAddress = resultSet.getString("cAddress");
					String cEmail = resultSet.getString("cEmail");
					String cPhone = resultSet.getString("cPhone");
					
					dto = new ZDto(cId, cAddress, cEmail, cPhone);
					//System.out.println(cId);
					//HttpSession session=reque
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dto;
			
		} // 


		public void order(String cId, String pId, String oPayment) {
			
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "insert into orders (cId, pId, delivery_id, oQuantity, oPayment, oDate) values (?,?,1,1,?,now())";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cId);
				preparedStatement.setString(2, pId);
				preparedStatement.setString(3, oPayment);
		
				
				
				preparedStatement.executeUpdate();
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		} //write
		
		
		public ZDto orderView(String seq) {
			ZDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select * from product where pId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(seq));
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					int pId = resultSet.getInt("pId");
					String pName = resultSet.getString("pName");
					String pColor = resultSet.getString("pColor");
					int pSize = resultSet.getInt("pSize");
					String pDetail = resultSet.getString("pDetail");
					int pSaleprice = resultSet.getInt("pSaleprice");
					String pCategory = resultSet.getString("pCategory");
					String pBrand = resultSet.getString("pBrand");
					
					dto = new ZDto(pId, pName, pColor, pSize, pDetail, pSaleprice, pCategory, pBrand);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dto;
			
		} // Content_view
	
	
}
