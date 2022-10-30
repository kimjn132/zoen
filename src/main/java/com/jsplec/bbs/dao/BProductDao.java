package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.BProductDto;

public class BProductDao {
		
	DataSource dataSource;
	
	public BProductDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체 검색
		public ArrayList<BProductDto> productlist(){
			ArrayList<BProductDto> dtos = new ArrayList<BProductDto>();
			Connection connection = null; //데이터 접근을 위한 객체
			PreparedStatement preparedStatement = null; //쿼리문 실행을 위한 객체
			ResultSet resultSet = null; //데이터를 가져와 결과값을 얻기 위한 객체
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select pId, pName, pBrand, pCategory from product";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int pId = resultSet.getInt("pId");
					String pName = resultSet.getString("pName");
					String pBrand = resultSet.getString("pBrand");
					String pCategory = resultSet.getString("pCategory");
					
					System.out.println(pName);
					
					BProductDto dto = new BProductDto(pId, pName, pBrand, pCategory);
					dtos.add(dto);
				}
				
			}catch(Exception e) {
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
		}
	
	
		//상품입력
	public void productadd(String pName, String pColor, String pSize, String pDetail, int pSaleprice, String pCategory,
			String pBrand, int pStock) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into product (pName, pColor, pSize, pDetail, pSaleprice, pCategory, pBrand, pStock) values (?,?,?,?,?,?,?,?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pName);
			preparedStatement.setString(2, pColor);
			preparedStatement.setString(3, pSize);
			preparedStatement.setString(4, pDetail);
			preparedStatement.setInt(5, pSaleprice);
			preparedStatement.setString(6, pCategory);
			preparedStatement.setString(7, pBrand);
			preparedStatement.setInt(8, pStock);
			
			System.out.println(query);
			System.out.println(pName);
			System.out.println(pColor);
			System.out.println(pSize);
			System.out.println(pDetail);
			System.out.println(pSaleprice);
			System.out.println(pCategory);
			System.out.println(pBrand);
			System.out.println(pStock);
		
			preparedStatement.executeUpdate();
						
		}catch(Exception e) {
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
	
	
	
	public BProductDto productView(String spId) {
	      BProductDto dto = null;
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      ResultSet resultSet = null;
	      
	      try {
	         connection = dataSource.getConnection();
	         
	         String query = "select * from product where pId = ?";
	         preparedStatement = connection.prepareStatement(query);
	         preparedStatement.setInt(1, Integer.parseInt(spId));
	         resultSet = preparedStatement.executeQuery();
	         
	         if(resultSet.next()) {
	        	 	int pId = resultSet.getInt("pId");
	        	 	String pName = resultSet.getString("pName");
		            String pColor = resultSet.getString("pColor");
		            String pSize = resultSet.getString("pSize");
		            String pDetail = resultSet.getString("pDetail");
	        	 	int pSaleprice = resultSet.getInt("pSaleprice");
		            String pCategory = resultSet.getString("pCategory");
		            String pBrand = resultSet.getString("pBrand");
		            int pStock = resultSet.getInt("pStock");
		            
		            System.out.println("프로덕트뷰");
		            System.out.println(query);
		            System.out.println(pName);
		            System.out.println(pDetail);
		            System.out.println(pStock);
	        	 	
	            dto = new BProductDto(pId, pName, pColor, pSize, pDetail, pSaleprice, pCategory, pBrand, pStock);
	         }
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(resultSet !=null) resultSet.close();
	            if(preparedStatement != null) preparedStatement.close();
	            if(connection != null) connection.close();
	         }catch(Exception e) {
	            e.printStackTrace();
	           
	         }
	      }
	      return dto;
	   }// content_view
	
		//삭제하기
		public void productdelete(String pId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query="delete from product where pId=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(pId));
			preparedStatement.executeUpdate();
			System.out.println(query);
			System.out.println("dao delete");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//delete
	
		
		//수정하기
		public void productmodify(String pName, String pColor, String pSize, String pBrand, int pSaleprice, String pDetail, int pStock, int pId) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "update product set pName=? , pColor=? , pSize=?, pBrand=?, pSaleprice=?, pDetail=?, pStock=?  where pId=?";
						
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pName);
				preparedStatement.setString(2, pColor);
				preparedStatement.setString(3, pSize);
				preparedStatement.setString(4, pBrand);
				preparedStatement.setInt(5, pSaleprice);
				preparedStatement.setString(6, pDetail);
				preparedStatement.setInt(7, pStock);
				preparedStatement.setInt(8,pId);
				
				System.out.println("모디파이 다ㅣ");
				System.out.println(query);
				System.out.println(pColor);
				System.out.println(pSaleprice);
				System.out.println(pId);
			
				preparedStatement.executeUpdate();
							
			}catch(Exception e) {
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
	
	
	
}
	
	
	
	
	
	
	

