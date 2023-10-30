/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Tests the ProductsReader Class
 * @author Kenny Howard 
 */
class ProductsReaderTest {
	
	/** String representation of a note from exp_tasks.txt to confirm the note is right. */
	private String[] note = {"[Backlog] note 2", "[Owned] note"};

	/**
	 * Tests the readProductsFile method. Checks the first Product, the first Task inside it
	 * and its first note in its String ArrayList of notes.
	 */
	@Test
	void testReadProductsFile() {
		ArrayList<Product> products = assertDoesNotThrow(() -> ProductsReader.readProductsFile("test-files/exp_tasks.txt"));
		Product p = products.get(0);
		assertEquals("Test Product", p.getProductName());
		Task t1 = p.getTaskById(3);
		assertEquals("3,Owned,Test task 2,KA,sesmith,owner,false", t1.toString());
		String[] noteList = t1.getNotesArray();
		assertArrayEquals(note, noteList);
		ArrayList<Product> products2 = assertDoesNotThrow(() -> ProductsReader.readProductsFile("test-files/tasks3.txt"));
		assertEquals(0, products2.size());
		ArrayList<Product> products3 = assertDoesNotThrow(() -> ProductsReader.readProductsFile("test-files/tasks13.txt"));
		assertEquals(0, products3.size());
	}

}