package edu.ncsu.csc216.product_backlog.model.command;
/**
 * The Command class makes a Command object that transitions the state of a Task. It has
 * an enumeration based on the states of Task. It also has a method that formally transitions
 * the state of the Task.
 * @author Kenny howard	
 */
public class Command {
	/**
	 * An enumeration with values based on the states of Task. Each value is used to
	 * set the state of Task to a different state. Each state has different paths
	 * for each state transition.
	 * @author Kenny howard
	 */
	public enum CommandValue { BACKLOG, CLAIM, PROCESS, VERIFY, COMPLETE, REJECT }
	
	/** The current CommandValue. */
	private CommandValue c;
	/** The task's owner. */
	private String owner;
	/** Notes about the task. */
	private String note;
	/**
	 * Constructs Command and sets the fields to the given parameters.
	 * @param c the CommandValue representing the state change
	 * @param owner the owner of the task
	 * @param noteText notes about the task.
	 * @throws IllegalArgumentException if c is null, noteText is null, owner is null when
	 *		   c is set to CLAIM, or owner isn't null when c is set anything but CLAIM
	 */
	public Command(CommandValue c, String owner, String noteText) {
		if (c == null) {
			throw new IllegalArgumentException("Invalid command.");
		}
		
		if ("".equals(noteText) || noteText == null) {
			throw new IllegalArgumentException("Invalid command.");
		}
		
		if (("".equals(owner) || owner == null) && c == CommandValue.CLAIM) {
			throw new IllegalArgumentException("Invalid command.");
		}
		
		if (owner != null && c != CommandValue.CLAIM) {
			throw new IllegalArgumentException("Invalid command.");
		}
		
		this.c = c;
		this.owner = owner;
		note = noteText;
		
	}
	/** 
	 * Gets the CommandValue. 
	 * @return c the current CommandValue
	 */
	public CommandValue getCommand() {
		return c;
	}
	/** 
	 * Gets the task's owner.
	 * @return owner the task's owner
	 */
	public String getOwner() {
		return owner;
	}
	/** 
	 * Gets the note text.
	 * @return note notes about the task.
	 */
	public String getNoteText() {
		return note;
	}
}