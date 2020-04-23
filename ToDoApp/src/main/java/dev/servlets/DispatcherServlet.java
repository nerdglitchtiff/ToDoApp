package dev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.controllers.TaskController;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
	}

	TaskController tcontroller = new TaskController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Welcome to my app");

		//PrintWriter pw = response.getWriter();
//		pw.append("\nBaby girl what's your name?\n");
//
//		String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);



		String uri = request.getRequestURI();
		switch(uri) {
		case "/ToDoApp/api/tasks": tcontroller.getAllTasks(request, response);
		break;
		case "/ToDoApp/api/addtask": tcontroller.addTask(request, response);
		break;
		case "/ToDoApp/api/pendingtasks": tcontroller.getAllPendingTasks(request, response);
		break;
		case "/ToDoApp/api/completedtasks": tcontroller.getAllCompletedTasks(request, response);
		break;
		case "/ToDoApp/api/updatetask" : tcontroller.updateTask(request, response); break;
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
