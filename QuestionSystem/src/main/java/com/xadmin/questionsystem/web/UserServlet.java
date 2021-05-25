package com.xadmin.questionsystem.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.questionsystem.bean.Question;
import com.xadmin.questionsystem.bean.User;
import com.xadmin.questionsystem.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	public int qid=1;
	
	

//	public int getQid() {
//		return qid;
//	}
//
//	public void setQid(int qid) {
//		this.qid = qid;
//	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDao  = new UserDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertUser(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;		
		case "/delete":
			try {
				deleteUser(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm( request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			System.out.println("update in servlet case");
			try {
				updateUser(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/choose":
			System.out.println("choose in servlet case");
			try {
				chooseUser(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;			
			
		default:
			try {
				listUser(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("showNewForm in servlet function");
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	//insert user
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name, email, country);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}
	
	//delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			userDao.deleteUser(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	//edit
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("showEditform in servlet function");
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser;
		try {
			existingUser = userDao.selectUser(id);

			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	//update
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("update in servlet function");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User user = new User(id, name, email, country);
		userDao.updateUser(user);
		response.sendRedirect("list");		
		
				
	}	
	
	private void chooseUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("choose in servlet function");

//		System.out.println( request.getParameter("id"));
//		System.out.println( request.getAttribute("question"));
//		System.out.println( request.getAttribute("qid"));
//		System.out.println( request.getParameter("qid"));
//		
//		int qid = (int) request.getAttribute("qid");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println( id +","+qid);
		
		userDao.updateQuestion(qid, id);
		response.sendRedirect("list");		
		
				
	}	
	
	//default
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		try {
			List<User> listUser = userDao.selectAllUsers();
			Question question =  userDao.selectQuestion(qid);
			request.setAttribute("listUser", listUser);
			request.setAttribute("question", question);
			request.setAttribute("qid", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
