package dev.tests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import dev.daos.TaskDAO;
import dev.daos.TaskDAOI;
import dev.entities.task.Task;
import dev.services.TaskService;
import dev.services.TaskServiceI;

public class TaskDAOTest {
	static TaskDAOI td = new TaskDAO();
	static TaskServiceI ts = new TaskService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateTask() {
		Task tp = new Task(0, "Test task", "Medium", false);
		Task t = td.createTask(tp);
		assertEquals(t, tp);
	}

	@Test
	public void testGetTaskById() {
		Task t = ts.getTaskById(4);
		assertEquals(4, t.gettId());
	}

	@Test
	public void testGetAllTasks() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCompleteTasks() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllPendingTasks() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTask() {
		Task t = ts.getTaskById(3);
			t=	ts.markTaskComplete(t);
			
			assertEquals(true, t.isComplete());
	}

	@Test
	public void testDeleteTask() {
		fail("Not yet implemented");
	}

}
