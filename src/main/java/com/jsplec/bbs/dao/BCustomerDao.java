package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.BCustomerDto;


public class BCustomerDao {

	DataSource dataSource;
	
	public BCustomerDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Login(고객과 관리자 로그인)
	public boolean login(String scId, String scPw){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BCustomerDto dto = null;
		boolean Result=false;
		try {
			connection = dataSource.getConnection();
			
			String query = "select cPw from customer where cId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			if(resultSet.next()) {
				String cPw = resultSet.getString("cPw");
				Result = scPw.equals(cPw);
				System.out.println("cPw = " + cPw);
			
			}
			System.out.println("login Result = " + Result);
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
		return Result;
	} // Login
		
	// 전체 고객 검색(관리자 페이지)
	public ArrayList<BCustomerDto> List(){
		ArrayList<BCustomerDto> dtos = new ArrayList<BCustomerDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select cId, cPw, cAddress, cEmail, cPhone, cJoinDate, cDeleteDate from customer";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cPw = resultSet.getString("cPw");
				String cAddress = resultSet.getString("cAddress");
				String cEmail = resultSet.getString("cEmail");
				String cPhone = resultSet.getString("cPhone");
				Timestamp cJoinDate = resultSet.getTimestamp("cJOinDate");
				Timestamp cDeleteDate = resultSet.getTimestamp("cDeleteDate");
				BCustomerDto dto = new BCustomerDto(cId, cPw, cAddress, cEmail, cPhone, cJoinDate, cDeleteDate);
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

	// 고객Id(cID)로 검색
	public BCustomerDto contentCustomerView(String scId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BCustomerDto dto = null; 
		try {
			connection = dataSource.getConnection();
			
			String query = "select cId, cPw, cAddress, cEmail, cPhone, cJoinDate, cDeleteDate from customer where cId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String cId = resultSet.getString("cId");
				String cPw = resultSet.getString("cPw");
				String cAddress = resultSet.getString("cAddress");
				String cEmail = resultSet.getString("cEmail");
				String cPhone = resultSet.getString("cPhone");
				Timestamp cJoinDate = resultSet.getTimestamp("cJoinDate");
				Timestamp cDeleteDate = resultSet.getTimestamp("cDeleteDate");
				dto = new BCustomerDto(cId, cPw, cAddress, cEmail, cPhone, cJoinDate, cDeleteDate);
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
	} // contentCustomerView
	
	
	// 고객 ID 등록
	public void write(String cId, String cPw, String cAddress, String cEmail, String cPhone) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into customer (cId, cPw, cAddress, cEmail, cPhone, cJoinDate) values (?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cId);
			preparedStatement.setString(2, cPw);
			preparedStatement.setString(3, cAddress);
			preparedStatement.setString(4, cEmail);
			preparedStatement.setString(5, cPhone);
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
	
	// 고객 ID 수정(myPage가 없어서 안씀)
	public void modifyCustomer(String cId,String cPw, String cAddress, String cEmail, String cPhone) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update customer set cPw=?, cAddress=?, cEmail=?, cPhone=?, cJoinDate=now() where cId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cPw);
			preparedStatement.setString(2, cAddress);
			preparedStatement.setString(3, cEmail);
			preparedStatement.setString(4, cPhone);
			preparedStatement.setString(5, cId);
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
	} //modifyCustomer
	
	// 고객 삭제(고객Id로 고객삭제날짜 추가)
	public void deleteCustomer(String cId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update from customer set cDeleteDate=now() where cId=? ";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, cId);
			preparedStatement.executeUpdate();
			System.out.println(cId);
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
	} //deleteCustomer
	
	
	
	
	
	
	
	
	
	
}
