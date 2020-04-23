package dev.daos;

import java.util.List;

import dev.entities.task.Task;

public interface TaskDAOI {
	Task createTask(Task task);
	
	Task getTaskById(int iId);
	List<Task> getAllTasks();
	List<Task> getAllCompleteTasks();
	List<Task> getAllPendingTasks();
	
	Task updateTask(Task task);
	
	boolean deleteTask(Task task);

}
