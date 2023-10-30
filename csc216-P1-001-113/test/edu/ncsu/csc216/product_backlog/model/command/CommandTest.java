/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;

/**
 * Tests the Command class.
 * @author Kenny Howard 
 */
class CommandTest {

	/**
	 * Tests the Command constructor.
	 */
	@Test
	void testCommand() {
		// Testing each legitimate enumeration
		assertDoesNotThrow(() -> new Command(CommandValue.BACKLOG, null, "Backlog test"));
		assertDoesNotThrow(() -> new Command(CommandValue.CLAIM, "rjphill4", "Claim test"));
		assertDoesNotThrow(() -> new Command(CommandValue.PROCESS, null, "Process test"));
		assertDoesNotThrow(() -> new Command(CommandValue.VERIFY, null, "Verify test"));
		assertDoesNotThrow(() -> new Command(CommandValue.COMPLETE, null, "Complete test"));
		assertDoesNotThrow(() -> new Command(CommandValue.REJECT, null, "Reject test"));
		// Testing parameters that throw exceptions
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> 
					new Command(null, null, "Null command test"));
		assertEquals("Invalid command.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> // Null note parameter test
					new Command(CommandValue.BACKLOG, null, null));
		assertEquals("Invalid command.", e2.getMessage());
		
		
		
	}

	/**
	 * Tests the getCommand method.
	 */
	@Test
	void testGetCommand() {
		Command c = new Command(CommandValue.BACKLOG, null, "test");
		assertEquals(CommandValue.BACKLOG, c.getCommand());
	}

	/**
	 * Tests the getOwner method.
	 */
	@Test
	void testGetOwner() {
		Command c = new Command(CommandValue.CLAIM, "rjphill4", "test");
		assertEquals("rjphill4", c.getOwner());
	}

	/**
	 * Tests the getNoteText method.
	 */
	@Test
	void testGetNoteText() {
		Command c = new Command(CommandValue.BACKLOG, null, "test");
		assertEquals("test", c.getNoteText());
	}

}
