package edu.ncsu.csc216.product_backlog.model.product;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;
/**
 * This class creates a Product object that has its own name, a list of Task objects,
 * and a counter that helps with the order of the tasks. Product's methods are mainly focused
 * on methods that affect the list. It can also take a Command object as a parameter to change
 * individual tasks in the list.
 * @author Kenny Howard
 *
 */
public class Product {
	/** The product's name. */
	private String productName;
	/** An ArrayList of tasks. */
	private ArrayList<Task> tasks;
	/** A counter for setting IDs for accompanying tasks.*/
	private int counter;
	/**
	 * Constructs the Product object, sets productName to the parameter,
	 * creates a new empty ArrayList for tasks, and sets counter to 1.
	 * @param name String of the product's name
	 */
	public Product(String name) {
		setProductName(name);
		emptyList();
		setTaskCounter();
	}
	/**
	 * Sets the product's name to the parameter.
	 * @param name String of the product's name
	 * @throws IllegalArgumentException if name is null or an empty String
	 */
	public void setProductName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Invalid product name.");
		}
		productName = name;
	}
	
	/**
	 * Returns the product's name.
	 * @return productName String of the product's name
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * Sets the counter to the size of the tasks ArrayList plus one.
	 */
	private void setTaskCounter() {
		counter = tasks.size() + 1;
	}
	
	/**
	 * Sets tasks as a new, empty ArrayList.
	 */
	private void emptyList() {
		tasks = new ArrayList<Task>();
	}
	
	/**
	 * Adds a sorted task to Product's list of tasks. Increments the counter after
	 * successful addition. Has a Task object as a parameter.
	 * @param task a Task object to be added to list of tasks
	 */
	public void addTask(Task task) {
		int index = taskOrder(task);
		tasks.add(index, task);
		counter = task.getTaskId() + 1;
	}
	
	/**
	 * Adds a sorted task to Product's list of tasks. Increments the counter after
	 * successful addition. Has a title, Type, creator and note as parameters.
	 * @param title the task's title
	 * @param type the task's Type
	 * @param creator the task's creator
	 * @param note the task's notes
	 */
	public void addTask(String title, Type type, String creator, String note) {
		Task task = new Task(counter, title, type, creator, note);
		tasks.add(taskOrder(task), task);
		counter = task.getTaskId() + 1;
	}
	
	/**
	 * Determines where the Task will be added in the tasks list.
	 * @param task Task to be added in the tasks list
	 * @return order int index of where the Task will be placed in the tasks list
	 * @throws IllegalArgumentException if the id of the parameter Task is a match
	 *         of a Task's id inside the tasks list
	 */
	private int taskOrder(Task task) {
		int id = task.getTaskId();
		int order = 0;
		for (int i = 0; i < tasks.size(); i++) {
			if (id == tasks.get(i).getTaskId()) {
				throw new IllegalArgumentException("Task cannot be added.");
			}
			else if (id > tasks.get(i).getTaskId()) {
				order++;
			}
		}
		return order;
	}
	
	/**
	 * Returns the list of Tasks.
	 * @return tasks the ArrayList of tasks
	 */
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * Finds and returns a task using an id as a parameter. Returns null 
	 * if there no task with the given id.
	 * @param id int of the task's id
	 * @return the Task if it is found with the given id, null otherwise.
	 */
	public Task getTaskById(int id) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId() == id) {
				return tasks.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Finds and deletes a task using an id as a parameter.
	 * @param id int of the task's id
	 */
	public void deleteTaskById(int id) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId() == id) {
				tasks.remove(i);
			}
		}
	}
	
	/**
	 * Finds a task with the given id and will update it based on the Command parameter.
	 * @param id int of the task's id
	 * @param c Command object to change the targeted task
	 */
	public void executeCommand(int id, Command c) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId() == id) {
				tasks.get(i).update(c);
			}
		}
	}
}
