/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Tests Product class.
 * @author Kenny Howard 
 */
class ProductTest {

	/** A representation of Products tasks ArrayList. */
	private ArrayList<Task> fakeTasks = new ArrayList<Task>();
	
	/**
	 * Tests Product's constructor
	 */
	@Test
	void testProduct() {
		Product p = assertDoesNotThrow(() -> new Product("Test"));
		assertEquals("Test", p.getProductName());
		
		//Testing null and empty name parameters
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Product(null));
		assertEquals("Invalid product name.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Product(""));
		assertEquals("Invalid product name.", e2.getMessage());
	}

	/**
	 * Tests setProductName method.
	 */
	@Test
	void testSetProductName() {
		Product p = new Product("Test");
		p.setProductName("Fork");
		assertEquals("Fork", p.getProductName());
	}

	/**
	 * Tests getProductName method.
	 */
	@Test
	void testGetProductName() {
		Product p = new Product("Test");
		assertEquals("Test", p.getProductName());
	}

	/**
	 * Tests addTask method with one Task parameter.
	 */
	@Test
	void testAddTaskTask() {
		Product p = new Product("Test");
		Task t1 = new Task(1, "Task 1", Type.FEATURE, "rjphill4", "test");
		Task t2 = new Task(2, "Task 2", Type.FEATURE, "rjphill4", "test");
		Task t3 = new Task(5, "Task 3", Type.BUG, "rjphill4", "test");
		p.addTask(t2);
		p.addTask(t1);
		p.addTask(t3);
		p.addTask("Task 4", Type.BUG, "rjphill4", "test");
		assertEquals(t1, p.getTaskById(1));
		assertEquals(t2, p.getTaskById(2));
		assertEquals(t3, p.getTaskById(5));
		assertEquals("Task 4", p.getTaskById(6).getTitle());
		
		
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> p.addTask(t1));
		assertEquals("Task cannot be added.", e1.getMessage());
		
	}

	/**
	 * Tests addTask method with Four parameters.
	 */
	@Test
	void testAddTaskStringTypeStringString() {
		Product p = new Product("Test");
		p.addTask("Task 1", Type.BUG, "rjphill4", "test");
		p.addTask("Task 2", Type.TECHNICAL_WORK, "rjphill4", "test");
		assertEquals(1, p.getTaskById(1).getTaskId());
		assertEquals(2, p.getTaskById(2).getTaskId());
	}

	/**
	 * Tests getTasks method.
	 */
	@Test
	void testGetTasks() {
		Product p = new Product("Test");
		Task t1 = new Task(1, "Task 1", Type.FEATURE, "rjphill4", "test");
		Task t2 = new Task(2, "Task 2", Type.FEATURE, "rjphill4", "test");
		p.addTask(t2);
		p.addTask(t1);
		fakeTasks.add(t1);
		fakeTasks.add(t2);
		assertEquals(fakeTasks, p.getTasks());
	}

	/**
	 * Tests getTaskById method.
	 */
	@Test
	void testGetTaskById() {
		Product p = new Product("Test");
		Task t1 = new Task(1, "Task 1", Type.FEATURE, "rjphill4", "test");
		Task t2 = new Task(2, "Task 2", Type.FEATURE, "rjphill4", "test");
		p.addTask(t2);
		p.addTask(t1);
		assertEquals(t1, p.getTaskById(1));
		assertEquals(t2, p.getTaskById(2));
		// Checks for a non-existing id.
		assertEquals(null, p.getTaskById(3));
	}

	/**
	 * Tests deleteTaskById method.
	 */
	@Test
	void testDeleteTaskById() {
		Product p = new Product("Test");
		Task t1 = new Task(1, "Task 1", Type.FEATURE, "rjphill4", "test");
		p.addTask(t1);
		assertEquals(t1, p.getTaskById(1));
		p.deleteTaskById(1);
		// Checks for the deleted task.
		assertEquals(null, p.getTaskById(1));
	}

	/**
	 * Test executeCommand method.
	 */
	@Test
	void testExecuteCommand() {
		Command c = new Command(CommandValue.CLAIM, "owner", "test");
		Product p = new Product("Test");
		Task t1 = new Task(1, "Task 1", Type.FEATURE, "rjphill4", "test");
		p.addTask(t1);
		p.executeCommand(1, c);
		assertEquals("Owned", p.getTaskById(1).getStateName());
	}

}
