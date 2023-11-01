package edu.ncsu.csc216.product_backlog.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
/**
 * ProductsReader only has one public method, readProductsFile. Through it, and its
 * private helper methods, ProductsReader makes file input relations in the system workable.
 * This functionality requires a given file and returns to the program an ArrayList of Products.
 * @author Kenny Howard
 * 
 *
 */
public class ProductsReader {
	/**
	 * Reads through a given file and converts it into an ArrayList of Products that is then
	 * returned.
	 * @param filename String name of the file to be processed
	 * @return an ArrayList of Product objects
	 * @throws IllegalArgumentException if the file cannot be found or loaded
	 */
	public static ArrayList<Product> readProductsFile(String filename) {
		String fileText = "";
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Scanner readFile = new Scanner(new FileInputStream(filename));
			while (readFile.hasNextLine()) {
				fileText += readFile.nextLine() + "\n";
			}
			Scanner textReader = new Scanner(fileText);
			if (fileText.indexOf('#') == -1) {
				textReader.useDelimiter("\\r?\\n?[#]");
				textReader.next();
			}
			else {
				fileText = fileText.substring(1);
				fileText = fileText.trim();
				textReader.useDelimiter("\\r?\\n?[#]");
			}
			while (textReader.hasNext()) {
				Product p = processProduct(textReader.next());
				if (p.getTasks().size() == 0) {
					continue;
				}
				products.add(p);
			}
			textReader.close();
			return products;
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	}
	
	/**
	 * Reads through a given String line and converts it into a Product.
	 * @param line that holds information about the Product
	 * @return a newly constructed Product
	 */
	private static Product processProduct(String line) {
		String newLine = line.trim();
		Scanner lineReader = new Scanner(newLine);
		Product product = new Product(lineReader.nextLine());
		lineReader.useDelimiter("\\r?\\n?[*]");
		while (lineReader.hasNext()) {
			Task task = processTask(lineReader.next());
			if (task == null) {
				continue;
			}
			else if (product.getTasks().size() == 0) {
				product.addTask(task);
			}
			else if (product.getTaskById(task.getTaskId()) == null) {
				product.addTask(task);
			}
		}
		lineReader.close();
		return product;
	}
	
	/**
	 * Reads through a given String line and converts it into a Task.
	 * If any exceptions are caught, the method returns null. 
	 * Otherwise, returns the newly constructed Task object.
	 * @param line that holds information about the Task
	 * @return a newly constructed Task
	 */
	private static Task processTask(String line) {
		String newLine = line.substring(1);
		newLine = newLine.trim();
		Scanner lineReader = new Scanner(newLine);
		lineReader.useDelimiter(",");
		int id;
		String state;
		String title;
		String type;
		String creator;
		String owner;
		String verified;
		ArrayList<String> notes;
		try {
			id = lineReader.nextInt();
			state = lineReader.next();
			title = lineReader.next();
			type = lineReader.next();
			creator = lineReader.next();
			owner = lineReader.next();
			lineReader.useDelimiter("\\r?\\n?[-]");
			verified = lineReader.next().substring(1);
			verified = verified.trim();
			notes = new ArrayList<String>();
			while (lineReader.hasNext()) {
				notes.add(lineReader.next().trim());
			}
			lineReader.close();
			return new Task(id, state, title, type, creator, owner, verified, notes);
		} catch (Exception e) {
			return null;
		}
	}
	
}