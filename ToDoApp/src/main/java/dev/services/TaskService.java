package dev.services;

import java.util.List;

import dev.daos.TaskDAO;
import dev.daos.TaskDAOI;
import dev.entities.task.Task;

public class TaskService implements TaskServiceI{

	private TaskDAOI tdao = new TaskDAO();
	
	
	public Task createTask(Task task) {
		tdao.createTask(task);
		return task;
	}

	
	public Task markTaskComplete(Task task) {
		task.setComplete(true);
		tdao.updateTask(task);
		return task;
	}

	
	public List<Task> retrieveAllTasks() {		
		return tdao.getAllTasks();
	}

	public List<Task> retrievePendingTasks() {
		return tdao.getAllPendingTasks();
	}

	
	public List<Task> retrieveCompleteTasks() {
		return tdao.getAllCompleteTasks();
	}

	
	public Task getTaskById(int id) {		
		return tdao.getTaskById(id);
	}


	
}
