package edu.ncsu.csc216.product_backlog.model.task;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
/**
 * This is a big class that manages many variables, fields, and Objects. It is dependent
 * on its Type enumeration, and on the Command class that help it transition between its
 * various inner class states. Also features numerous getters and setters to interact with
 * other associated classes.
 * @author Kenny Howard
 */
public class Task {
	
	/**
	 * This enumeration determines the type of task and helps govern its behavior.
	 * Ultimately all but KNOWLEDGE_ACQUISITION function similarly, they require
	 * the Task to be verified before being able to transition into a Done state.
	 * Tasks that have a Type of KNOWLEDGE_ACQUISITION can transition into Done
	 * without verification.
	 * @author Kenny Howard

	 */
	public enum Type { FEATURE, BUG, TECHNICAL_WORK, KNOWLEDGE_ACQUISITION }
	
	/** The name of the backlog state. */
	public static final String BACKLOG_NAME = "Backlog";
	/** The name of the owned state. */
	public static final String OWNED_NAME = "Owned";
	/** The name of the processing state. */
	public static final String PROCESSING_NAME = "Processing";
	/** The name of the verifying state. */
	public static final String VERIFYING_NAME = "Verifying";
	/** The name of the done state. */
	public static final String DONE_NAME = "Done";
	/** The name of the rejected state. */
	public static final String REJECTED_NAME = "Rejected";
	/** The name of the feature type. */
	public static final String FEATURE_NAME = "Feature";
	/** The name of the bug type. */
	public static final String BUG_NAME = "Bug";
	/** The name of the technical work type. */
	public static final String TECHNICAL_WORK_NAME = "Technical Work";
	/** The name of the knowledge acquisition type. */
	public static final String KNOWLEDGE_ACQUISITION_NAME = "Knowledge Acquisition";
	/** The initial of the feature type. */
	public static final String T_FEATURE = "F";
	/** The initial of the bug type. */
	public static final String T_BUG = "B";
	/** The initials of the technical work type. */
	public static final String T_TECHNICAL_WORK = "TW";
	/** The initials of the knowledge acquisition type. */
	public static final String T_KNOWLEDGE_ACQUISITION = "KA";
	/** A placeholder string for a task with no owner. */
	public static final String UNOWNED = "unowned";
	/** The field that holds the task's current Type. */
	private Type type;
	/** The task's id. */
	private int taskId;
	/** The task's title. */
	private String title;
	/** The task's creator. */
	private String creator;
	/** The task's owner. */
	private String owner;
	/** Determines if the task has been verified as finished.*/
	private boolean isVerified;
	/** An ArrayList of notes related to the task. */
	private ArrayList<String> notes;
	/** A final instance of the BacklogState inner class. */
	private final TaskState backlogState = new BacklogState();
	/** A final instance of the OwnedState inner class. */
	private final TaskState ownedState = new OwnedState();
	/** A final instance of the ProcessingState inner class. */
	private final TaskState processingState = new ProcessingState();
	/** A final instance of the VerifyingState inner class. */
	private final TaskState verifyingState = new VerifyingState();
	/** A final instance of the DoneState inner class. */
	private final TaskState doneState = new DoneState();
	/** A final instance of the RejectedState inner class. */
	private final TaskState rejectedState = new RejectedState();
	/** Current state of the Task. */
	private TaskState currentState;
	/**
	 * Constructs Task using five parameters.
	 * @param id String holding task id
	 * @param title String holding task title
	 * @param type Type the task's type
	 * @param creator String holding task's creator
	 * @param note String holding notes about the task
	 */
	public Task(int id, String title, Type type, String creator, String note) {
		setTaskId(id);
		setTitle(title);
		setType(type);
		setCreator(creator);
		setOwner(UNOWNED);
		setVerified("false");
		setState(BACKLOG_NAME);
		notes = new ArrayList<String>();
		addNoteToList(note);
	}
	/**
	 * Constructs Task using eight parameters.
	 * @param id String holding task id
	 * @param state String holding task state
	 * @param title String holding task title
	 * @param type String holding task type
	 * @param creator String holding task's creator
	 * @param owner String holding task's owner
	 * @param verified String holding info on if task has been verified as finished
	 * @param notes ArrayList of Strings holding notes about the task
	 */
	public Task(int id, String state, String title, String type, String creator, String owner, 
				String verified, ArrayList<String> notes) {
		setTaskId(id);
		setTitle(title);
		setTypeFromString(type);
		setCreator(creator);
		setOwner(owner);
		setVerified(verified);
		setNotes(notes);
		setState(state);
	}
	
	/**
	 * Sets taskId to the given parameter. Throws exception if the parameter
	 * is less than 1.
	 * @param id int equivalent to the Task's id
	 * @throws IllegalArgumentException if id parameter is less than 1
	 */
	private void setTaskId(int id) {
		if (id < 1) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		taskId = id;
	}
	
	/**
	 * Sets title to the given parameter. Throws exception if the parameter
	 * is null or an empty String.
	 * @param title String representation of the Task's title
	 * @throws IllegalArgumentException if title parameter is null or empty
	 */
	private void setTitle(String title) {
		if (title == null || "".equals(title)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.title = title;
	}
	
	/**
	 * Sets type to the given parameter. Throws exception if the parameter is null.
	 * @param type value that gives the Type of the Task.
	 * @throws IllegalArgumentException if type parameter is null
	 */
	private void setType(Type type) {
		if (type == null) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.type = type;
	}
	
	/**
	 * Sets creator to the given parameter. Throws exception if the parameter
	 * is null or an empty String.
	 * @param creator String representation of a Task's creator
	 * @throws IllegalArgumentException if creator parameter is null or empty
	 */
	private void setCreator(String creator) {
		if (creator == null || "".equals(creator)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.creator = creator;
	}
	
	/**
	 * Sets owner to the given parameter. Throws exception if the parameter
	 * is null or an empty String.
	 * @param owner String representation of a Task's owner
	 * @throws IllegalArgumentException if owner parameter is null or empty
	 */
	private void setOwner(String owner) {
		if (owner == null || "".equals(owner)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		if ("unowned".equals(owner)) {
			this.owner = UNOWNED;
		}
		this.owner = owner;
	}
	
	/**
	 * Sets isVerified based on the given parameter; If the parameter is "true",
	 * isVerified is set to true, and if the parameter is "false", isVerified is set
	 * to false. Throws an exception if it is neither, or if the parameter
	 * is otherwise null or empty.
	 * @param verified String representation on if the Task is verified
	 * @throws IllegalArgumentException if verified is null, empty or
	 *         is neither "true" nor "false"
	 */
	private void setVerified(String verified) {
		if (verified == null || "".equals(verified)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		if ("true".equals(verified)) {
			isVerified = true;
		}
		else if ("false".equals(verified)) {
			isVerified = false;
		}
		else {
			throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * Sets notes based on the given parameter. Will throw an exception if
	 * the size of the parameter is 0.
	 * @param notes an ArrayList of notes for a Task
	 * @throws IllegalArgumentException if the given note's size is 0
	 */
	private void setNotes(ArrayList<String> notes) {
		if (notes.size() == 0) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.notes = notes;
	}
	
	/**
	 * Adds a note to the ArrayList of notes. Makes sure that the parameter is not
	 * null or empty. Returns the index of the new note.
	 * @param note notes to add to the list
	 * @return int index of the new note
	 * @throws IllegalArgumentException if the parameter String is null or empty
	 */
	public int addNoteToList(String note) {
		if(note == null || "".equals(note)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		notes.add("[" + getStateName() + "] " + note);
		return notes.indexOf(note);
	}
	
	/**
	 * Returns the task's id.
	 * @return taskId the task's id
	 */
	public int getTaskId() {
		return taskId;
	}
	
	/**
	 * Returns the State name.
	 * @return String representation of the current State
	 */
	public String getStateName() {
		return currentState.getStateName();
	}
 	
	/**
	 * Sets the Task's State based on the String parameter. Throws an exception if the state
	 * parameter is null or an empty String. An exception will also be thrown if the owner is
	 * set to anything but "unowned" for BacklogState and RejectedState 
	 * and if it is set to "unowned" for the other TaskStates.
	 * @param state String representation of the Task's state
	 * @throws IllegalArgumentException if the state parameter is null, empty, 
	 *         the owner field is not set to unowned for BacklogState and RejectedState
	 *         or if it is set to unowned for the other TaskStates
	 */
	private void setState(String state) {
		if (state == null  || "".equals(state)) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		switch (state) {
			case BACKLOG_NAME:
				if (!owner.equals(UNOWNED)) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				currentState = backlogState;
				break;
			case OWNED_NAME:
				if (owner.equals(UNOWNED)) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				currentState = ownedState;
				break;
			case PROCESSING_NAME:
				if (owner.equals(UNOWNED)) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				currentState = processingState;
				break;
			case VERIFYING_NAME:
				if (owner.equals(UNOWNED)) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				currentState = verifyingState;
				break;
			case DONE_NAME:
				if (owner.equals(UNOWNED)) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				else if (type != Type.KNOWLEDGE_ACQUISITION && !isVerified()) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				else if (type == Type.KNOWLEDGE_ACQUISITION && isVerified()) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				currentState = doneState;
				break;
			case REJECTED_NAME:
				if (!owner.equals(UNOWNED)) {
					throw new IllegalArgumentException("Invalid task information.");
				}
				currentState = rejectedState;
				break;
			default:
				throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * Sets the Task's Type based on the given parameter. Throws an exception if the parameter
	 * does not correspond to any of the Types.
	 * @param type String representation of the Task's Type
	 * @throws IllegalArgumentException if the parameter doesn't correspond to any of the Types
	 */
	private void setTypeFromString(String type) {
		switch(type) {
			case T_FEATURE:
				this.type = Type.FEATURE;
				break;
			case T_BUG:
				this.type = Type.BUG;
				break;
			case T_TECHNICAL_WORK:
				this.type = Type.TECHNICAL_WORK;
				break;
			case T_KNOWLEDGE_ACQUISITION:
				this.type = Type.KNOWLEDGE_ACQUISITION;
				break;
			default:
				throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * Returns the current Type.
	 * @return the current Type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Returns the short String representation of the Type. Returns null
	 * if type does not equal any of the enumerations.
	 * @return a String representation of the Type
	 */
	public String getTypeShortName() {
		if (type == Type.FEATURE) {
			return T_FEATURE;
		}
		if (type == Type.BUG) {
			return T_BUG;
		}
		if (type == Type.TECHNICAL_WORK) {
			return T_TECHNICAL_WORK;
		}
		if (type == Type.KNOWLEDGE_ACQUISITION) {
			return T_KNOWLEDGE_ACQUISITION;
		}
		return null;
	}
	
	/**
	 * Returns the long String representation of the Type. Returns null
	 * if type does not equal any of the enumerations.
	 * @return a long String representation of the Type
	 */
	public String getTypeLongName() {
		if (type == Type.FEATURE) {
			return FEATURE_NAME;
		}
		if (type == Type.BUG) {
			return BUG_NAME;
		}
		if (type == Type.TECHNICAL_WORK) {
			return TECHNICAL_WORK_NAME;
		}
		if (type == Type.KNOWLEDGE_ACQUISITION) {
			return KNOWLEDGE_ACQUISITION_NAME;
		}
		return null;
	}
	
	/**
	 * Returns the task's owner.
	 * @return owner String of the task's owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Returns the task's title
	 * @return title String of the task's title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the task's creator
	 * @return creator String of the task's creator
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * Returns if the task has been verified by someone.
	 * @return isVerified boolean value that holds if someone verified the task
	 */
	public boolean isVerified() {
		return isVerified;
	}
	
	/**
	 * Returns the ArrayList of String notes.
	 * @return notes an ArrayList of String notes
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}
	
	/**
	 * Creates and returns a notes list string based on the notes ArrayList.
	 * @return list String representation of the notes list.
	 */
	public String getNotesList() {
		String list = "";
		for (int i = 0; i < notes.size() - 1; i++) {
			list += "-" + notes.get(i) + "\n";
		}
		list += "-" + notes.get(notes.size() - 1);
		return list;
	}
	
	/**
	 * Creates and returns a String representation of Task.
	 * @return String representation of task.
	 */
	public String toString() {
		String verifiedString;
		if (isVerified()) {
			verifiedString = "true";
		}
		else {
			verifiedString = "false";
		}
		return "" + getTaskId() + "," + getStateName() + "," + getTitle() + "," + getTypeShortName() + "," 
				+ getCreator() + "," + getOwner() + "," + verifiedString;
	}
	
	/**
	 * Updates the current state based on the given Command parameter.
	 * @param command a Command object that can transition states in Task
	 */
	public void update(Command command) {
		currentState.updateState(command);
	}
	
	/**
	 * Returns a String array of task notes.
	 * @return a String array holding task notes
	 */
	public String[] getNotesArray() {
		String[] array = new String[notes.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = notes.get(i);
		}
		return array;
	}
	
	/**
	 * Interface for states in the Task State Pattern.  All 
	 * concrete task states must implement the TaskState interface.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface TaskState {
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command c);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();
	
	}
	
	/**
	 * This class represents the BacklogState of Task's State Pattern. Can transition
	 * into OwnedState or RejectedState. Implements the TaskState interface.
	 * @author Kenny Howard

	 */
	private class BacklogState implements TaskState {
		
		/**
		 * Updates the owner, state, and notes fields based on the values inside the parameter
		 * Command. Throws an exception if the CommandValue is incompatible with BacklogState.
		 * Overrides TaskState's updateState method.
		 * @throws UnsupportedOperationException if CommandValue is not set to CLAIM or REJECT
		 */
		@Override
		public void updateState(Command c) {		
			if (c.getCommand() == CommandValue.CLAIM) {
				setOwner(c.getOwner());
				setState(OWNED_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.REJECT) {
				setState(REJECTED_NAME);
				addNoteToList(c.getNoteText());
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the state name of BacklogState. Overrides TaskState's getStateName method.
		 * @return BACKLOG_NAME the String constant representing BacklogState
		 */
		@Override
		public String getStateName() {
			return BACKLOG_NAME;
		}
	}
	
	/**
	 * This class represents the OwnedState of Task's State Pattern. Can transition
	 * into ProcessingState, RejectedState or BacklogState. Implements the TaskState interface.
	 * @author Kenny Howard

	 */
	private class OwnedState implements TaskState {
		
		/**
		 * Updates the owner, state, and notes fields based on the values inside the parameter
		 * Command. Throws an exception if the CommandValue is incompatible with OwnedState.
		 * Overrides TaskState's updateState method.
		 * @throws UnsupportedOperationException if CommandValue is not set to PROCESS, REJECT
		 *         or BACKLOG
		 */
		@Override
		public void updateState(Command c) {
			if (c.getCommand() == CommandValue.PROCESS) {
				setState(PROCESSING_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.REJECT) {
				setOwner(UNOWNED);
				setState(REJECTED_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.BACKLOG) {
				setOwner(UNOWNED);
				setState(BACKLOG_NAME);
				addNoteToList(c.getNoteText());
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the state name of OwnedState. Overrides TaskState's getStateName method.
		 * @return OWNED_NAME the String constant representing OwnedState
		 */
		@Override
		public String getStateName() {
			return OWNED_NAME;
		}
	}
	
	/**
	 * This class represents the ProcessingState of Task's State Pattern. Can transition
	 * into itself, VerifyingState, DoneState or BacklogState. 
	 * Implements the TaskState interface.
	 * @author Kenny Howard

	 */
	private class ProcessingState implements TaskState {
		
		/**
		 * Updates the owner, state, and notes fields based on the values inside the parameter
		 * Command. Throws an exception if the CommandValue is incompatible with ProcessingState.
		 * Overrides TaskState's updateState method.
		 * @throws UnsupportedOperationException if CommandValue is not set to PROCESS, VERIFY 
		 * 		   (with the Type not being KNOWLEDGE_ACQUISITION), COMPLETE (with the Type being 
		 * 		   KNOWLEDGE_ACQUISITION), or BACKLOG
		 */
		@Override
		public void updateState(Command c) {
			if (c.getCommand() == CommandValue.PROCESS) {
				setState(PROCESSING_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.VERIFY && type != Type.KNOWLEDGE_ACQUISITION) {
				setState(VERIFYING_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.COMPLETE && type == Type.KNOWLEDGE_ACQUISITION) {
				setState(DONE_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.BACKLOG) {
				setOwner(UNOWNED);
				setState(BACKLOG_NAME);
				addNoteToList(c.getNoteText());
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the state name of ProcessingState. Overrides TaskState's getStateName method.
		 * @return PROCESSING_NAME the String constant representing ProcessingState
		 */
		@Override
		public String getStateName() {
			return PROCESSING_NAME;
		}
	}
	
	/**
	 * This class represents the VerifyingState of Task's State Pattern. Can transition
	 * into DoneState or ProcessingState. Implements the TaskState interface.
	 * @author Kenny Howard

	 */
	private class VerifyingState implements TaskState {
		
		/**
		 * Updates the verified, state, and notes fields based on the values inside the parameter
		 * Command. Throws an exception if the CommandValue is incompatible with VerifyingState.
		 * Overrides TaskState's updateState method.
		 * @throws UnsupportedOperationException if CommandValue is not set to COMPLETE OR PROCESS
		 */
		@Override
		public void updateState(Command c) {
			if (c.getCommand() == CommandValue.COMPLETE) {
				setVerified("true");
				setState(DONE_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.PROCESS) {
				setState(PROCESSING_NAME);
				addNoteToList(c.getNoteText());
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the state name of VerifyingState. Overrides TaskState's getStateName method.
		 * @return VERIFYING_NAME the String constant representing VerifyingState
		 */
		@Override
		public String getStateName() {
			return VERIFYING_NAME;
		}
	}
	
	/**
	 * This class represents the DoneState of Task's State Pattern. Can transition
	 * into ProcessingState or BacklogState. Implements the TaskState interface.
	 * @author Kenny Howard

	 */
	private class DoneState implements TaskState {
		
		/**
		 * Updates the verified, owner, state, and notes fields based on the values inside the 
		 * parameter Command. Throws an exception if the CommandValue is incompatible with 
		 * VerifyingState. Overrides TaskState's updateState method.
		 * @throws UnsupportedOperationException if CommandValue is not set to PROCESS OR BACKLOG
		 */
		@Override
		public void updateState(Command c) {
			if (c.getCommand() == CommandValue.PROCESS) {
				setVerified("false");
				setState(PROCESSING_NAME);
				addNoteToList(c.getNoteText());
			}
			else if (c.getCommand() == CommandValue.BACKLOG) {
				setVerified("false");
				setOwner(UNOWNED);
				setState(BACKLOG_NAME);
				addNoteToList(c.getNoteText());
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the state name of DoneState. Overrides TaskState's getStateName method.
		 * @return DONE_NAME the String constant representing DoneState
		 */
		@Override
		public String getStateName() {
			return DONE_NAME;
		}
	}
	
	/**
	 * This class represents the RejectedState of Task's State Pattern. Can only transition
	 * into BacklogState. Implements the TaskState interface.
	 * @author Kenny Howard

	 */
	private class RejectedState implements TaskState {
		
		/**
		 * Updates the state and notes fields based on the values inside the parameter Command.
		 * Throws an exception if the CommandValue is incompatible with RejectedState.
		 * Overrides TaskState's updateState method.
		 * @throws UnsupportedOperationException if CommandValue is not set to BACKLOG
		 */
		@Override
		public void updateState(Command c) {
			if (c.getCommand() == CommandValue.BACKLOG) {
				setState(BACKLOG_NAME);
				addNoteToList(c.getNoteText());
			}
			else {
				throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the state name of RejectedState. Overrides TaskState's getStateName method.
		 * @return REJECTED_NAME the String constant representing RejectedState
		 */
		@Override
		public String getStateName() {
			return REJECTED_NAME;
		}
	}
}