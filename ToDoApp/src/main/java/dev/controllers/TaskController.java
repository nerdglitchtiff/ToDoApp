package dev.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.entities.task.Task;
import dev.services.TaskService;
import dev.services.TaskServiceI;

public class TaskController {
	TaskServiceI ts = new TaskService();
	public void getAllTasks(HttpServletRequest request, HttpServletResponse response){
		Gson gson = new Gson();
		List<Task> tsks = ts.retrieveAllTasks();
		try (
			PrintWriter pw = response.getWriter()){
			String json = gson.toJson(tsks);
			pw.append(json);
			
			//pw.append(tsks.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}//getAll closure
	
	public void addTask(HttpServletRequest request, HttpServletResponse response) throws IOException{
	String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
	Gson gson = new Gson();
	
	Task task = gson.fromJson(body, Task.class);
	ts.createTask(task);
	response.getWriter().append("Success!!!");

	}//add closure
	
	public void getTaskById(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		int id = Integer.parseInt(request.getParameter("tId"));
		Task t = ts.getTaskById(id);
		try (
				PrintWriter pw = response.getWriter()){
				String json = gson.toJson(t);
				pw.append(json);
				//pw.append(tsks.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}//getById closure
	
	
	public void markComplete(HttpServletRequest request, HttpServletResponse response) {
		
	}

	public void getAllPendingTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(ts.retrievePendingTasks());
		response.getWriter().append(json);
	}

	public void getAllCompletedTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(ts.retrieveCompleteTasks());
		response.getWriter().append(json);
	}

	public void updateTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Task task = gson.fromJson(json, Task.class);
		ts.markTaskComplete(task);
		System.out.println(task);
		response.getWriter().append("Successfully updated Task!!!!");		
	}
	
	
}//controller closure
