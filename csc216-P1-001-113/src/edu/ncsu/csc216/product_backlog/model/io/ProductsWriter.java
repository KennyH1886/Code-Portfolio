package edu.ncsu.csc216.product_backlog.model.io;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
/**
 * ProductsWriter has only one public method, writeProductsToFile. Using this method,
 * the entire Product Backlog system has file output functionality. This functionality
 * requires a given file path and ArrayList of Products.
 * @author Kenny Howard
 */
public class ProductsWriter {
	/**
	 * With a parameter filename path, and ArrayList of Products, writes a file
	 * representation of the ArrayList.
	 * @param filename String of the file path
	 * @param products an ArrayList of Product objects
	 * @throws IllegalArgumentException if the file cannot be saved
	 */
	public static void writeProductsToFile(String filename, ArrayList<Product> products) {
		try {
			PrintStream writer = new PrintStream(new File(filename));
			
			for(int i = 0; i < products.size(); i++) {
				writer.println("# " + products.get(i).getProductName());
				ArrayList<Task> tasks = products.get(i).getTasks();
				for (int j = 0; j < tasks.size(); j++) {
					writer.println("* " + tasks.get(j).toString());
					String[] array = tasks.get(j).getNotesArray();
					for (int k = 0; k < array.length; k++) {
						writer.println("- " + array[k]);
					}
				}
			}
			writer.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		
	}

}
