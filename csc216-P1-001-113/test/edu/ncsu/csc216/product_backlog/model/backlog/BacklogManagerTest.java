/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.backlog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 *  This JUnit tests the BacklongManager class.
 *  @author Kenny Howard 
 *
 */
class BacklogManagerTest {
	
	/** Singleton instance of BacklogManager. */
	private BacklogManager singleton;
	/**
	 * Resets the singleton after every test by clearing its products
	 * and currentProduct fields and also resetting the singleton.
	 */
	@BeforeEach
	public void setUp() {
		singleton = BacklogManager.getInstance();
		singleton.clearProducts();
		singleton.resetManager();
	}
	
	/**
	 * Tests addProduct method. Also tests the getProductName method.
	 */
	@Test
	void testAddProduct() {
		singleton.addProduct("Test");
		assertEquals("Test", singleton.getProductName());
		// Adding Product with same name
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.addProduct("Test"));
		assertEquals("Invalid product name.", e1.getMessage());
		// null Product name parameter
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> singleton.addProduct(null));
		assertEquals("Invalid product name.", e2.getMessage());
	}

	/**
	 * Tests editProduct method.
	 */
	@Test
	void testEditProduct() {
		singleton.addProduct("Test");
		assertEquals("Test", singleton.getProductName());
		singleton.editProduct("Tortoise");
		assertEquals("Tortoise", singleton.getProductName());
	}

	/**
	 * Tests deleteProduct method.
	 */
	@Test
	void testDeleteProduct() {
		singleton.addProduct("Test");
		singleton.deleteProduct();
		assertNull(singleton.getProductName());
		singleton.addProduct("One");
		singleton.addProduct("Two");
		singleton.deleteProduct();
		assertEquals("One", singleton.getProductName());
		singleton.clearProducts();
		// Exception when trying to delete a product with currentProduct as null.
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.deleteProduct());
		assertEquals("No product selected.", e1.getMessage());
		
	}

	/**
	 * Tests loadProduct method.
	 */
	@Test
	void testLoadProduct() {
		singleton.addProduct("Test1");
		singleton.addProduct("Test2");
		singleton.addProduct("Test3");
		assertEquals("Test3", singleton.getProductName());
		singleton.loadProduct("Test1");
		assertEquals("Test1", singleton.getProductName());
		// Loading a product that isn't in the list
		Exception e = assertThrows(IllegalArgumentException.class, () -> singleton.loadProduct("Test4"));
		assertEquals("Product not available.", e.getMessage());
	}

	/**
	 * Tests getProductList method.
	 */
	@Test
	void testGetProductList() {
		singleton.addProduct("Test1");
		singleton.addProduct("Test2");
		singleton.addProduct("Test3");
		String[] array = {"Test1", "Test2", "Test3"};
		assertArrayEquals(array, singleton.getProductList());
	}

	/**
	 * Tests clearProducts method.
	 */
	@Test
	void testClearProducts() {
		singleton.addProduct("Test1");
		singleton.addProduct("Test2");
		singleton.addProduct("Test3");
		singleton.addProduct("Test4");
		assertEquals(4, singleton.getProductList().length);
		assertEquals("Test4", singleton.getProductName());
		singleton.clearProducts();
		assertEquals(0, singleton.getProductList().length);
		assertNull(singleton.getProductName());
	}

	/**
	 * Tests saveToFile method.
	 */
	@Test
	void testSaveToFile() {
		// Tests saving to a file with no products.
		Exception e = assertThrows(IllegalArgumentException.class, () -> singleton.saveToFile("test-files/save_to_file_test_fail.txt"));
		assertEquals("Unable to save file.", e.getMessage());
		
		singleton.addProduct("Charlotte Hornets Program");
		singleton.addTaskToProduct("Refreshments", Type.FEATURE, "rjphill4", "FIRST NOTE TEST FOR saveToFile");
		singleton.addProduct("Haitian Family Fund");
		singleton.addTaskToProduct("Fixing Transaction Issues", Type.BUG, "rjphill4", "SECOND NOTE TEST FOR saveToFile");
		assertDoesNotThrow(() -> singleton.saveToFile("test-files/save_to_file_test_pass.txt"));
		checkFiles("test-files/save_to_file_test_pass.txt", "test-files/save_to_file_expected.txt");
	}

	/**
	 * Tests loadFromFile method.
	 */
	@Test
	void testLoadFromFile() {
		singleton.loadFromFile("test-files/exp_tasks.txt");
		assertEquals("Test Product", singleton.getProductName());
		assertEquals("Test task 2", singleton.getTaskById(3).getTitle());
		assertEquals("Test task 1", singleton.getTaskById(7).getTitle());
	}

	/**
	 * Tests getTasksAsArray method.
	 */
	@Test
	void testGetTasksAsArray() {
		singleton.addProduct("Test");
		singleton.addTaskToProduct("Title1", Type.BUG, "rjphill4", "test1");
		singleton.addTaskToProduct("Title2", Type.FEATURE, "rjphill4", "test2");
		String[][] array = singleton.getTasksAsArray();
		assertEquals("1", array[0][0]);
		assertEquals("Backlog", array[0][1]);
		assertEquals("Bug", array[0][2]);
		assertEquals("Title1", array[0][3]);
		assertEquals("2", array[1][0]);
		assertEquals("Backlog", array[1][1]);
		assertEquals("Feature", array[1][2]);
		assertEquals("Title2", array[1][3]);
	}

	/**
	 * Tests getTaskById method.
	 */
	@Test
	void testGetTaskById() {
		singleton.addProduct("Test");
		singleton.addTaskToProduct("Title1", Type.BUG, "rjphill4", "test1");
		singleton.addTaskToProduct("Title2", Type.FEATURE, "rjphill4", "test2");
		Task t1 = new Task(1, "Title1", Type.BUG, "rjphill4", "test1");
		Task t2 = new Task(2, "Title2", Type.FEATURE, "rjphill4", "test2");
		assertEquals(t1.toString(), singleton.getTaskById(1).toString());
		assertEquals(t2.toString(), singleton.getTaskById(2).toString());
	}

	/**
	 * Tests deleteTaskById method.
	 */
	@Test
	void testDeleteTaskById() {
		singleton.addProduct("Test");
		singleton.addTaskToProduct("Title1", Type.BUG, "rjphill4", "test1");
		singleton.addTaskToProduct("Title2", Type.FEATURE, "rjphill4", "test2");
		Task t2 = new Task(2, "Title2", Type.FEATURE, "rjphill4", "test2");
		assertEquals(t2.toString(), singleton.getTaskById(2).toString());
		singleton.deleteTaskById(2);
		assertNull(singleton.getTaskById(0));
	}

	/**
	 * Tests executeCommand method.
	 */
	@Test
	void testExecuteCommand() {
		Command c = new Command(CommandValue.CLAIM, "owner", "test");
		singleton.addProduct("Test");
		singleton.addTaskToProduct("Task 1", Type.FEATURE, "rjphill4", "test");
		assertEquals("Backlog", singleton.getTaskById(1).getStateName());
		assertDoesNotThrow(() -> singleton.executeCommand(1, c));
		assertEquals("Owned", singleton.getTaskById(1).getStateName());
	}

	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
