/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Tests the only public method in ProductsWriter.
 * @author Kenny Howard 
 *
 */
class ProductsWriterTest {
	
	/** A path for the text file created in testWriteProductsToFile. */
	public static final String TEST_PATH = "test-files/products_writer_test_actual.txt";

	/** An ArrayList of Products. */
	private ArrayList<Product> products = new ArrayList<Product>();
	
	/**
	 * Test writeProductsToFile
	 */
	@Test
	void testWriteProductsToFile() {
		Product p1 = new Product("NCSU Toolkit");
		String note = "Cups for Gray Hall";
		Task t1 = new Task(1, "Wolf Village cups", Type.BUG, "rjphill4", note);
		p1.addTask(t1);
		products.add(p1);
		assertDoesNotThrow(() -> ProductsWriter.writeProductsToFile(TEST_PATH, products));
		checkFiles("test-files/products_writer_test_1.txt", TEST_PATH);
		
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
