package edu.ncsu.csc216.product_backlog.model.backlog;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.io.ProductsReader;
import edu.ncsu.csc216.product_backlog.model.io.ProductsWriter;
import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * The main class that interacts with ProductBacklogGUI. Holds an ArrayList of Products and manages them
 * through various methods. A currentProduct field also helps to narrow focus on an individual Product.
 * Utilizes a singleton instance so that only one instance of it interacts with ProductBacklogGUI.
 * @author Kenny Howard 
 */
public class BacklogManager {
	
	/** A list of Products. */
	private ArrayList<Product> products;
	
	/** The current Product. */
	private Product currentProduct;
	
	/** The single accessible instance of BacklogManager. */
	private static BacklogManager singleton;
	
	/**
	 * Constructs the BacklogManager and creates a new empty ArrayList for products.
	 */
	private BacklogManager() {
		products = new ArrayList<Product>();
	}
	
	/**
	 * Returns the singleton instance of BacklogManager.
	 * @return singleton the accessible instance of BacklogManager
	 */
	public static BacklogManager getInstance() {
		if (singleton == null) {
			singleton = new BacklogManager();
		}
		return singleton;
	}
	
	/**
	 * Makes a new Product with the parameter for its name. Placed at the end of the products list.
	 * @param productName String name of the product
	 * @throws IllegalArgumentException if the parameter is null, empty, or
	 * 		   there is a Product with the same name
	 */
	public void addProduct(String productName) {
		Product p = new Product(productName);
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) == null) {
				continue;
			}
			else if (products.get(i).getProductName().equals(productName)) {
				throw new IllegalArgumentException("Invalid product name.");
			}
		}
		products.add(p);
		loadProduct(productName);
	}
	
	/**
	 * Changes the name of the currentProduct. Immediately ends the method if
	 * there is an existing Product with the parameter name.
	 * @param updateName String name of the product
	 * @throws IllegalArgumentException if the currentProduct is null
	 */
	public void editProduct(String updateName) {
		if (currentProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		if (updateName == null || "".equals(updateName)) {
			return;
		}
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName() == updateName) {
				return;
			}
		}
		currentProduct.setProductName(updateName);
	}
	
	/**
	 * Deletes the currentProduct, and sets it to the Product at the front of
	 * the products list, or null if the list is empty.
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public void deleteProduct() {
		if (currentProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		products.remove(currentProduct);
		if (products.size() == 0) {
			currentProduct = null;
		}
		else {
			currentProduct = products.get(0);
		}
	}
	
	/**
	 * Finds the Product with the given name parameter, and sets it as the
	 * currentProduct.
	 * @param productName String name of the product
	 * @throws IllegalArgumentException if a product with the name parameter cannot be found
	 */
	public void loadProduct(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName() == productName) {
				currentProduct = products.get(i);
				return;
			}
		}
		throw new IllegalArgumentException("Product not available.");
	}
	
	/**
	 * Returns the name of the current Product. If currentProduct is null,
	 * ends the method immediately and returns null.
	 * @return name String of the current product
	 */
	public String getProductName() {
		if (currentProduct == null) {
			return null;
		}
		return currentProduct.getProductName();
	}
	
	/**
	 * Returns a String array of the product names in the order they are
	 * in the products ArrayList.
	 * @return String array of the product names
	 */
	public String[] getProductList() {
		String[] list = new String[products.size()];
		for (int i = 0; i < list.length; i++) {
			list[i] = products.get(i).getProductName();
		}
		return list;
	}
	
	/**
	 * Clears the products ArrayList by setting it as an new empty ArrayList.
	 * currentProduct is set to null.
	 */
	public void clearProducts() {
		products = new ArrayList<Product>();
		currentProduct = null;
	}
	
	/**
	 * Saves the current products list into a parameter file path.
	 * @param filename the file path to create a new text file
	 * @throws IllegalArgumentException if currentProduct is null or
	 *         currentProduct has no Tasks
	 */
	public void saveToFile(String filename) {
		if (currentProduct == null || currentProduct.getTasks().size() == 0) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		ProductsWriter.writeProductsToFile(filename, products);
	}
	
	/**
	 * Loads a text file that, if compatible, will be processed into
	 * the products ArrayList.
	 * @param filename the file path of the target text file
	 */
	public void loadFromFile(String filename) {
			ArrayList<Product> importedProducts = ProductsReader.readProductsFile(filename);
			currentProduct = importedProducts.get(0);
			for (int i = 0; i < importedProducts.size(); i++) {
				products.add(importedProducts.get(i));
			}
	}
	
	/**
	 * Makes a 2D String array representation of the Tasks in
	 * the Product. Each column holds id, name of state, type, and title.
	 * Returns null if currentProduct is null.
	 * @return 2D String array holding Task information
	 */
	public String[][] getTasksAsArray() {
		if (currentProduct == null) {
			return null;
		}
		ArrayList<Task> tasks = currentProduct.getTasks();
		String[][] array = new String[tasks.size()][4];
		for (int i = 0; i < array.length; i++) {
			array[i][0] = "" + tasks.get(i).getTaskId();
			array[i][1] = tasks.get(i).getStateName();
			array[i][2] = tasks.get(i).getTypeLongName();
			array[i][3] = tasks.get(i).getTitle();
		}
		return array;
	}
	
	/**
	 * Finds a Product's Task with a given id. Returns null if
	 * currentProduct is null.
	 * @param id the task's id
	 * @return the Task corresponding to the given id
	 */
	public Task getTaskById(int id) {
		if (currentProduct == null) {
			return null;
		}
		return currentProduct.getTaskById(id);
	}
	
	/**
	 * Deletes a Product's Task with a given id. Ends the method
	 * immediately if currentProduct is null.
	 * @param id the task's id
	 */
	public void deleteTaskById(int id) {
		if (currentProduct == null) {
			return;
		}
		currentProduct.deleteTaskById(id);
	}
	
	/**
	 * Executes a change in a Task with a parameter task id, and Command object.
	 * Ends the method immediately if currentProduct is null.
	 * @param id the task's id
	 * @param c the Command object
	 */
	public void executeCommand(int id, Command c) {
		if (currentProduct == null) {
			return;
		}
		currentProduct.executeCommand(id, c);
	}
	
	/**
	 * Adds a task to the current Product with the parameter title, Type, creator name, and notes.
	 * Ends the method immediately if currentProduct is null.
	 * @param title task's title
	 * @param type the Type of task
	 * @param creator the task's creator
	 * @param note notes about the task
	 */
	public void addTaskToProduct(String title, Type type, String creator, String note) {
		if (currentProduct == null) {
			return;
		}
		currentProduct.addTask(title, type, creator, note);
	}
	
	/**
	 * Sets the singleton instance to null.
	 */
	protected void resetManager() {
		singleton = null;
	}
	
}
