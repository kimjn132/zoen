package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.DDto;



public class DDao {
	
	
	DataSource dataSource;
	
	public DDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zoen");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DDto> deliveryCo_list(){
		ArrayList<DDto> dtos = new ArrayList<DDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select deliveryCo_id, deliveryCo_name, deliveryCo_phone, deliveryCo_email from deliveryCo" ;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()) {
				int deliveryCo_id = resultSet.getInt("deliveryCo_id");
				String deliveryCo_name = resultSet.getString("deliveryCo_name");
				String deliveryCo_phone = resultSet.getString("deliveryCo_phone");
				String deliveryCo_email = resultSet.getString("deliveryCo_email");
				
				System.out.println(query);
				System.out.println("리스트디에이");
				
				DDto dto = new DDto(deliveryCo_id, deliveryCo_name, deliveryCo_phone, deliveryCo_email);
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

	//업체등록
	public void deliveryCo_write(String deliveryCo_name, String deliveryCo_phone, String deliveryCo_email) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into deliveryCo (deliveryCo_name, deliveryCo_phone, deliveryCo_email) values(?,?,?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, deliveryCo_name);
			preparedStatement.setString(2, deliveryCo_phone);
			preparedStatement.setString(3, deliveryCo_email);
			
			preparedStatement.executeUpdate();
			System.out.println(query);
			System.out.println(deliveryCo_name);
			System.out.println(deliveryCo_phone);
			System.out.println(deliveryCo_email);
			
			
			
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
		}//등록
	
		public DDto deliveryCo_contentView(String sbId) {
	      DDto dto = null;
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      ResultSet resultSet = null;
	      
	      try {
	         connection = dataSource.getConnection();
	         
	         String query = "select * from deliveryCo where deliveryCo_id = ?";
	         preparedStatement = connection.prepareStatement(query);
	         preparedStatement.setInt(1, Integer.parseInt(sbId));
	         resultSet = preparedStatement.executeQuery();
	         
	         if(resultSet.next()) {
	           int deliveryCo_id = resultSet.getInt("deliveryCo_id");
	           String deliveryCo_name = resultSet.getString("deliveryCo_name");
	           String deliveryCo_phone = resultSet.getString("deliveryCo_phone");
	           String deliveryCo_email = resultSet.getString("deliveryCo_email");
	           
	           dto = new DDto(deliveryCo_id, deliveryCo_name, deliveryCo_phone, deliveryCo_email);
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
//		
		//삭제하기
				public void deliveryCo_delete(String deliveryCo_id) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				try {
					connection = dataSource.getConnection();
					String query="delete from deliveryCo where deliveryCo_id=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, Integer.parseInt(deliveryCo_id));
					preparedStatement.executeUpdate(); //삭제 실행
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
				public void deleveryCo_modify(String deliveryCo_name, String deliveryCo_phone, String deliveryCo_email ,int deliveryCo_id) {
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "update deliveryCo set deliveryCo_name=? , deliveryCo_phone=? , deliveryCo_email=?  where deliveryCo_id=?";
								
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, deliveryCo_name);
						preparedStatement.setString(2, deliveryCo_phone);
						preparedStatement.setString(3, deliveryCo_email);
						preparedStatement.setInt(4, deliveryCo_id);
						
						System.out.println(query);
						System.out.println(deliveryCo_id);
					
						preparedStatement.executeUpdate(); //수정 실행
									
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
				
//	}
//	


















}  //--------------------------DDao


