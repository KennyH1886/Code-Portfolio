/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Tests Task class.
 * @author Kenny Howard 
 */
class TaskTest {
	/** For testing the bigger Task constructor and relevant methods. */
	private ArrayList<String> notes = new ArrayList<>();
	/** Command object holding a BACKLOG CommandValue. */
	private Command backlog = new Command(CommandValue.BACKLOG, null, "Backlog");
	/** Command object holding a CLAIM CommandValue. */
	private Command claim = new Command(CommandValue.CLAIM, "owner", "Claim");
	/** Command object holding a PROCESS CommandValue. */
	private Command process = new Command(CommandValue.PROCESS, null, "Process");
	/** Command object holding a VERIFY CommandValue. */
	private Command verify = new Command(CommandValue.VERIFY, null, "Verify");
	/** Command object holding a COMPLETE CommandValue. */
	private Command complete = new Command(CommandValue.COMPLETE, null, "Complete");
	/** Command object holding a REJECT CommandValue. */
	private Command reject = new Command(CommandValue.REJECT, null, "Reject");
	/**
	 * Tests Task constructor with five parameters.
	 */
	@Test
	void testTaskIntStringTypeStringString() {
		Task t = assertDoesNotThrow(() -> new Task(1, "Test1", Type.FEATURE, "rjphill4", "test"));
		assertDoesNotThrow(() -> new Task(2, "Test2", Type.BUG, "rjphill4", "test"));
		assertDoesNotThrow(() -> new Task(3, "Test3", Type.TECHNICAL_WORK, "rjphill4", "test"));
		assertDoesNotThrow(() -> new Task(4, "Test4", Type.KNOWLEDGE_ACQUISITION, "rjphill4", "test"));
		assertEquals(1, t.getTaskId());
		assertEquals("Test1", t.getTitle());
		assertEquals(Type.FEATURE, t.getType());
		assertEquals("rjphill4", t.getCreator());
		assertEquals("unowned", t.getOwner());
		assertFalse(t.isVerified());
		assertEquals("Backlog", t.getStateName());
		assertEquals(1, t.getNotes().size());
		assertEquals("[Backlog] test", t.getNotes().get(0));
		// Tasks that will throw an exception
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(0, "Test5", Type.FEATURE, "rjphill4", "test"));
		assertEquals("Invalid task information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(6, null, Type.FEATURE, "rjphill4", "test"));
		assertEquals("Invalid task information.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(7, "", Type.FEATURE, "rjphill4", "test"));
		assertEquals("Invalid task information.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(8, "Test8", null, "rjphill4", "test"));
		assertEquals("Invalid task information.", e4.getMessage());
		Exception e5 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(9, "Test9", Type.BUG, null, "test"));
		assertEquals("Invalid task information.", e5.getMessage());
		Exception e6 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(10, "Test10", Type.BUG, "", "test"));
		assertEquals("Invalid task information.", e6.getMessage());
		Exception e7 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(11, "Test11", Type.BUG, "rjphill4", null));
		assertEquals("Invalid task information.", e7.getMessage());
		Exception e8 = assertThrows(IllegalArgumentException.class, () -> 
									new Task(12, "Test12", Type.BUG, "rjphill4", ""));
		assertEquals("Invalid task information.", e8.getMessage());
		
	}

	/**
	 * Tests Task constructor with eight parameters.
	 */
	@Test
	void testTaskIntStringStringStringStringStringStringArrayListOfString() {
		notes.add("test");
		assertDoesNotThrow(() -> new Task(1, "Backlog", "Test1", "F", "rjphill4", "unowned", "false", notes));
		Task t = assertDoesNotThrow(() -> new Task(2, "Owned", "Test2", "B", "rjphill4", "owner", "false", notes));
		assertDoesNotThrow(() -> new Task(3, "Processing", "Test3", "TW", "rjphill4", "owner", "false", notes));
		assertDoesNotThrow(() -> new Task(4, "Verifying", "Test4", "KA", "rjphill4", "owner", "false", notes));
		assertDoesNotThrow(() -> new Task(5, "Done", "Test5", "F", "rjphill4", "owner", "true", notes));
		assertDoesNotThrow(() -> new Task(6, "Rejected", "Test6", "F", "rjphill4", "unowned", "false", notes));
		
		assertEquals(2, t.getTaskId());
		assertEquals("Test2", t.getTitle());
		assertEquals(Type.BUG, t.getType());
		assertEquals("rjphill4", t.getCreator());
		assertEquals("owner", t.getOwner());
		assertFalse(t.isVerified());
		assertEquals("Owned", t.getStateName());
		assertEquals(1, t.getNotes().size());
		assertEquals("test", t.getNotes().get(0));
	}

	/**
	 * Tests addNoteToList method
	 */
	@Test
	void testAddNoteToList() {
		Task t1 = new Task(1, "Test", Type.FEATURE, "rjphill4", "test");
		t1.addNoteToList("Testing method");
		assertEquals("-[Backlog] test\n-[Backlog] Testing method", t1.getNotesList());
		assertEquals(t1.getNotes().size(), 2);
		// Testing if it throws an Exception when it should
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> t1.addNoteToList(null));
		assertEquals("Invalid task information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> t1.addNoteToList(""));
		assertEquals("Invalid task information.", e2.getMessage());
		
	}

	/**
	 * Tests getTaskId method.
	 */
	@Test
	void testGetTaskId() {
		Task t1 = new Task(1, "Test", Type.FEATURE, "rjphill4", "test");
		assertEquals(t1.getTaskId(), 1);
	}

	/**
	 * Tests getStateName method.
	 */
	@Test
	void testGetStateName() {
		notes.add("test");
		Task t1 = new Task(1, "Backlog", "Test1", "F", "rjphill4", "unowned", "false", notes);
		Task t2 = new Task(2, "Owned", "Test2", "B", "rjphill4", "owner", "false", notes);
		Task t3 = new Task(3, "Processing", "Test3", "KA", "rjphill4", "owner", "false", notes);
		Task t4 = new Task(4, "Verifying", "Test4", "TW", "rjphill4", "owner", "false", notes);
		Task t5 = new Task(5, "Done", "Test5", "F", "rjphill4", "owner", "true", notes);
		Task t6 = new Task(6, "Rejected", "Test6", "F", "rjphill4", "unowned", "false", notes);
		assertEquals("Backlog", t1.getStateName());
		assertEquals("Owned", t2.getStateName());
		assertEquals("Processing", t3.getStateName());
		assertEquals("Verifying", t4.getStateName());
		assertEquals("Done", t5.getStateName());
		assertEquals("Rejected", t6.getStateName());
	}

	/**
	 * Tests getType method.
	 */
	@Test
	void testGetType() {
		Task t1 = new Task(1, "Test", Type.FEATURE, "rjphill4", "test");
		assertEquals(t1.getType(), Type.FEATURE);
	}

	/**
	 * Tests getTypeShortName method.
	 */
	@Test
	void testGetTypeShortName() {
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "test");
		Task t2 = new Task(2, "Test2", Type.BUG, "rjphill4", "test");
		Task t3 = new Task(3, "Test3", Type.TECHNICAL_WORK, "rjphill4", "test");
		Task t4 = new Task(4, "Test4", Type.KNOWLEDGE_ACQUISITION, "rjphill4", "test");
		assertEquals(t1.getTypeShortName(), "F");
		assertEquals(t2.getTypeShortName(), "B");
		assertEquals(t3.getTypeShortName(), "TW");
		assertEquals(t4.getTypeShortName(), "KA");
	}

	/**
	 * Tests getTypeLongName method.
	 */
	@Test
	void testGetTypeLongName() {
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "test");
		Task t2 = new Task(2, "Test2", Type.BUG, "rjphill4", "test");
		Task t3 = new Task(3, "Test3", Type.TECHNICAL_WORK, "rjphill4", "test");
		Task t4 = new Task(4, "Test4", Type.KNOWLEDGE_ACQUISITION, "rjphill4", "test");
		assertEquals(t1.getTypeLongName(), "Feature");
		assertEquals(t2.getTypeLongName(), "Bug");
		assertEquals(t3.getTypeLongName(), "Technical Work");
		assertEquals(t4.getTypeLongName(), "Knowledge Acquisition");
	}

	/**
	 * Tests getOwner method.
	 */
	@Test
	void testGetOwner() {
		notes.add("test");
		Task t1 = new Task(1, "Owned", "Test", "B", "rjphill4", "owner", "false", notes);
		assertEquals(t1.getOwner(), "owner");
	}

	/**
	 * Tests getTitle method.
	 */
	@Test
	void testGetTitle() {
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "test");
		assertEquals(t1.getTitle(), "Test1");
	}

	/**
	 * Tests getCreator method.
	 */
	@Test
	void testGetCreator() {
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "test");
		assertEquals(t1.getCreator(), "rjphill4");
	}

	/**
	 * Tests isVerified method.
	 */
	@Test
	void testIsVerified() {
		notes.add("test");
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "test");
		assertFalse(t1.isVerified());
		Task t2 = new Task(5, "Done", "Test5", "F", "rjphill4", "owner", "true", notes);
		assertTrue(t2.isVerified());
		
	}

	/**
	 * Tests getNotes method.
	 */
	@Test
	void testGetNotes() {
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "test");
		assertEquals("[Backlog] test", t1.getNotes().get(0));
	}

	/**
	 * Tests getNoteList method.
	 */
	@Test
	void testGetNotesList() {
		Task t1 = new Task(1, "Test1", Type.FEATURE, "rjphill4", "testing the getNotesList method");
		t1.addNoteToList("testing getNoteList()");
		assertEquals("-[Backlog] testing the getNotesList method\n-[Backlog] testing getNoteList()", t1.getNotesList());
	}

	/**
	 * Tests toString method.
	 */
	@Test
	void testToString() {
		notes.add("test");
		Task t1 = new Task(1, "Backlog", "Test1", "F", "rjphill4", "unowned", "false", notes);
		assertEquals("1,Backlog,Test1,F,rjphill4,unowned,false", t1.toString());
	}

	/**
	 * Tests update method.
	 */
	@Test
	void testUpdate() {
		notes.add("test");
		// From a Backlog State
		Task backlog1 = new Task(1, "Backlog", "Test", "F", "rjphill4", "unowned", "false", notes);
		assertDoesNotThrow(() -> backlog1.update(claim)); // Backlog to Owned
		assertEquals("Owned", backlog1.getStateName());
		Task backlog2 = new Task(2, "Backlog", "Test", "F", "rjphill4", "unowned", "false", notes);
		assertDoesNotThrow(() -> backlog2.update(reject)); // Backlog to Rejected
		assertEquals("Rejected", backlog2.getStateName());
		Task backlogThrow = new Task(3, "Backlog", "Test", "F", "rjphill4", "unowned", "false", notes);
		// Exception from a Backlog State
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> backlogThrow.update(complete));
		assertEquals("Invalid transition.", e1.getMessage());
		
		// From an Owned State
		Task owned1 = new Task(1, "Owned", "Test", "B", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> owned1.update(process)); // Owned to Processing
		assertEquals("Processing", owned1.getStateName());
		Task owned2 = new Task(2, "Owned", "Test", "B", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> owned2.update(reject)); // Owned to Rejected
		assertEquals("Rejected", owned2.getStateName());
		assertEquals("unowned", owned2.getOwner());
		Task owned3 = new Task(3, "Owned", "Test", "B", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> owned3.update(backlog)); // Owned to Backlog
		assertEquals("Backlog", owned3.getStateName());
		assertEquals("unowned", owned3.getOwner());
		
		// From a Processing State
		Task processing1 = new Task(1, "Processing", "Test", "TW", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> processing1.update(process)); // Processing to Processing
		assertEquals("Processing", processing1.getStateName());
		assertDoesNotThrow(() -> processing1.update(verify)); // Processing to Verifying
		assertEquals("Verifying", processing1.getStateName());
		Task processing2 = new Task(2, "Processing", "Test", "KA", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> processing2.update(complete)); // Processing to Done
		assertEquals("Done", processing2.getStateName());
		Task processing3 = new Task(3, "Processing", "Test", "F", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> processing3.update(backlog)); // Processing to Backlog
		assertEquals("Backlog", processing3.getStateName());
		assertEquals("unowned", processing3.getOwner());
		
		// From a Verifying State
		Task verifying1 = new Task(1, "Verifying", "Test", "TW", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> verifying1.update(complete)); // Verifying to Done
		assertEquals("Done", verifying1.getStateName());
		assertTrue(verifying1.isVerified());
		Task verifying2 = new Task(2, "Verifying", "Test", "F", "rjphill4", "owner", "false", notes);
		assertDoesNotThrow(() -> verifying2.update(process));
		assertEquals("Processing", verifying2.getStateName());
		
		// From a Done State
		Task done1 = new Task(1, "Done", "Test", "F", "rjphill4", "owner", "true", notes);
		assertDoesNotThrow(() -> done1.update(process)); // Done to Processing
		assertEquals("Processing", done1.getStateName());
		assertFalse(done1.isVerified());
		Task done2 = new Task(2, "Done", "Test", "B", "rjphill4", "owner", "true", notes);
		assertDoesNotThrow(() -> done2.update(backlog));
		assertEquals("Backlog", done2.getStateName());
		assertFalse(done2.isVerified());
		assertEquals("unowned", done2.getOwner());
		
		// From a Rejected State
		Task rejected = new Task(1, "Rejected", "Test", "F", "rjphill4", "unowned", "false", notes);
		assertDoesNotThrow(() -> rejected.update(backlog)); // Rejected to Backlog
		assertEquals("Backlog", rejected.getStateName());
	}

	/**
	 * Tests getNotesArray method.
	 */
	@Test
	void testGetNotesArray() {
		Task t1 = new Task(1, "Test", Type.FEATURE, "rjphill4", "test");
		String[] array = {"[Backlog] test"};
		assertArrayEquals(array, t1.getNotesArray());
	}

}