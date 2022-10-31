package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.BDeliveryDto;


public class BDeliveryDao {

	DataSource dataSource;
	
	public BDeliveryDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Login
		
	// 전체 검색
	public ArrayList<BDeliveryDto> List(){
		ArrayList<BDeliveryDto> dtos = new ArrayList<BDeliveryDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from delivery";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int delivery_id = Integer.parseInt(resultSet.getString("delivery_id"));
				int deliveryCo_id = Integer.parseInt(resultSet.getString("deliveryCo_id"));
				int pId = Integer.parseInt(resultSet.getString("pId"));
				String cId = resultSet.getString("cId");
				int oId = Integer.parseInt(resultSet.getString("oId"));
				Timestamp delivery_initdate = resultSet.getTimestamp("delivery_initdate");
				Timestamp delivery_enddate = resultSet.getTimestamp("delivery_enddate");
				BDeliveryDto dto = new BDeliveryDto(delivery_id, deliveryCo_id, pId, cId, oId, delivery_initdate, delivery_enddate);
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

	// 전체 일부 검색
	public ArrayList<BDeliveryDto> contentDeliveryView(String scId){
		ArrayList<BDeliveryDto> dtos = new ArrayList<BDeliveryDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BDeliveryDto dto = null; 
		try {
			connection = dataSource.getConnection();
			
			String query = "select delivery_id, deliveryCo_id, pId, cId, oId, delivery_initdate, delivery_enddate from delivery where cId= ? ";
			System.out.println(query);
			System.out.println("scId :" +scId+":");
					
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int delivery_id = resultSet.getInt("delivery_id");
				int deliveryCo_id = resultSet.getInt("deliveryCo_id");
				int pId = resultSet.getInt("pId");
				String cId = resultSet.getString("cId");
				int oId = resultSet.getInt("oId");
				Timestamp delivery_initdate = resultSet.getTimestamp("delivery_initdate");
				Timestamp delivery_enddate = resultSet.getTimestamp("delivery_enddate");
				
				System.out.println(delivery_id);
				System.out.println(deliveryCo_id);
				System.out.println(pId);
				System.out.println(cId);
				System.out.println(oId);
				System.out.println(delivery_initdate);
				System.out.println(delivery_enddate);
				
				dto = new BDeliveryDto(delivery_id, deliveryCo_id, pId, cId, oId, delivery_initdate, delivery_enddate);
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
	} // Content

	// 전체 일부 검색
	public BDeliveryDto contentDeliveryViewId(int cDeliveryId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BDeliveryDto dto = null; 
		try {
			connection = dataSource.getConnection();
			
			String query = "select delivery_id, deliveryCo_id, pId, cId, oId, delivery_initdate, delivery_enddate from delivery where delivery_id= ? ";
			System.out.println(query);
			System.out.println("cDeliveryId :" +cDeliveryId+":");
					
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, cDeliveryId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int delivery_id = resultSet.getInt("delivery_id");
				int deliveryCo_id = resultSet.getInt("deliveryCo_id");
				int pId = resultSet.getInt("pId");
				String cId = resultSet.getString("cId");
				int oId = resultSet.getInt("oId");
				Timestamp delivery_initdate = resultSet.getTimestamp("delivery_initdate");
				Timestamp delivery_enddate = resultSet.getTimestamp("delivery_enddate");
				
				System.out.println(delivery_id);
				System.out.println(deliveryCo_id);
				System.out.println(pId);
				System.out.println(cId);
				System.out.println(oId);
				System.out.println(delivery_initdate);
				System.out.println(delivery_enddate);
				
				dto = new BDeliveryDto(delivery_id, deliveryCo_id, pId, cId, oId, delivery_initdate, delivery_enddate);
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
	} // Content
	
	
	
	
	
	public void write(int deliveryCo_id, int pId, String cId, int oId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into delivery (deliveryCo_id, pId, cId, oId , delivery_initdate) values (?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, deliveryCo_id);
			preparedStatement.setInt(2, pId);
			preparedStatement.setString(3, cId);
			preparedStatement.setInt(4, oId);
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
	
	
	public void modifyDelivery(int delivery_id, int deliveryCo_id, int pId, String cId, int oId, String delivery_initdate, String delivery_enddate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update delivery set deliveryCo_id=?, pId=?, cId=?, oId=?, delivery_initdate=?, delivery_enddate=? where delivery_id=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, deliveryCo_id);
			preparedStatement.setInt(2, pId);
			preparedStatement.setString(3, cId);
			preparedStatement.setInt(4, oId);
			preparedStatement.setString(5, delivery_initdate);
			preparedStatement.setString(6, delivery_enddate);
			preparedStatement.setInt(7, delivery_id);
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
	} //modify
	
	
	public void deleteDelivery(int delivery_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "delete from delivery where delivery_id=? ";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, delivery_id);
			preparedStatement.executeUpdate();
			System.out.println(delivery_id);
			System.out.println(query);
			
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
	} //delete
	
	
	
	
	
	
	
	
	
	
}
