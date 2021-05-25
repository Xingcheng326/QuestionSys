package com.xadmin.questionsystem.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.xadmin.questionsystem.bean.Question;
import com.xadmin.questionsystem.bean.User;
public class UserDao{
	//Modify these constant to your local setup
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/userdb?useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "Yexu8261303!";
	
	// Query statement	
	static final String INSERT_USERS_SQL = "INSERT INTO users " +"(name, email,country) VALUES "+" (?, ?, ?);" ;
	static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id =? ";
	static final String SELECT_ALL_USERS = "select * from users";
	static final String DELETE_USERS_SQL = "delete from users where id=?";
	static final String UPDATE_USERS_SQL = "update users set name = ?, email=?, country=?  where id=?";
	static final String SELECT_QUESTION_BY_ID = "select * from question where qid =? ";
	static final String UPDATE_QUESTION_CID = "update question set cid=?  where qid=?";
	
	//input output
//	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
	
	//constructor
	public UserDao() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			// Setup driver type
			Class.forName(JDBC_DRIVER);
			System.out.println("Connect to database...");
			
			// Setup connection
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connection established...");
			

		} catch (SQLException se) {
				se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 		
		return connection;
	}
	
	//insert
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);){
			preparedStatement.setObject(1, user.getName());
			preparedStatement.setObject(2, user.getEmail());
			preparedStatement.setObject(3, user.getCountry());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}catch(SQLException se) {
			 printSQLException(se);
		}
		
	}
	
	//select user by id
	public User selectUser(int id)  throws SQLException{
		User user = null;
		System.out.println(SELECT_USER_BY_ID);
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, id);
			
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String country = resultSet.getString("country");
				
		
				System.out.println("id: " + id + ";"
						+"name: " + name + ";"
						+ " email: " + email + "; "
								+ "country: " + country);
				user= new User(id, name, email,country);
			}
			
			
		}catch(SQLException se) {
			 printSQLException(se);
		}
		return user;
	}
	//select question by id
	public Question selectQuestion(int id)  throws SQLException{
		Question question = null;
		System.out.println(SELECT_QUESTION_BY_ID);
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);){
			preparedStatement.setInt(1, id);
			
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String questionText = resultSet.getString("questionText");
				int cid = resultSet.getInt("cid");				
		
				System.out.println("id: " + id + ";"
						+"questionText: " + questionText + ";"
						+ " cid: " + cid + "; ");
				question= new Question(id, questionText, cid);
			}
			
			
		}catch(SQLException se) {
			 printSQLException(se);
		}
		return question;
	}
	
	//select all users
	
	public List<User> selectAllUsers() throws SQLException{
		
		List<User> users = new ArrayList<>();
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
			
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id  = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String country = resultSet.getString("country");
				
		
				System.out.println("id: " + id + ";"
						+"name: " + name + ";"
						+ " email: " + email + "; "
								+ "country: " + country);
				users.add(new User(id, name, email,country)) ;
			}
			
			
		}catch(SQLException se) {
			 printSQLException(se);
		}			
		
		return users;
		
	}
	
	//update user
	public boolean updateUser(User user) throws SQLException {
		
		boolean rowUpdated = false;
		System.out.println("updateUser in UserDao function");
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);){
			System.out.println(preparedStatement);
			preparedStatement.setObject(1, user.getName());
			preparedStatement.setObject(2, user.getEmail());
			preparedStatement.setObject(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			System.out.println(preparedStatement);
			
			rowUpdated = preparedStatement.executeUpdate()>0;
			
		}catch(SQLException se) {
			 printSQLException(se);
		}		
		
		return rowUpdated;
	}
	
	//update Question
	public boolean updateQuestion( int qid, int id) throws SQLException {
		
		boolean rowUpdated = false;
		System.out.println("updateQuestion in UserDao function");
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUESTION_CID);){
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, id);			
			preparedStatement.setInt(2, qid);
			System.out.println(preparedStatement);
			
			rowUpdated = preparedStatement.executeUpdate()>0;
			
		}catch(SQLException se) {
			 printSQLException(se);
		}		
		
		return rowUpdated;
	}	
	//delete user
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowUpdated = false;
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);){
			System.out.println(preparedStatement);
			
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			rowUpdated = preparedStatement.executeUpdate()>0;
			
		}catch(SQLException se) {
			 printSQLException(se);
		}		
		
		return rowUpdated;		
		
	}
	
	
	
	public void printSQLException(SQLException se) {
		// TODO Auto-generated method stub
		for(Throwable e:se) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: "+((SQLException) e).getSQLState());
				System.err.println("Error Code: "+((SQLException) e).getErrorCode());
				System.err.println("Message: "+((SQLException) e).getMessage());
				Throwable t=se.getCause();
				while(t!=null) {
					System.out.println("Cause: "+t);
					t=t.getCause();
				}
			}
		}
		
	}
	

	
	
	
		
	
	
}