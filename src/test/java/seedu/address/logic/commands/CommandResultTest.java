package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CommandResultTest {

    @Test
    public void getType() {
        CommandResult commandResult = new CommandResult("feedback", CommandType.EXIT);
        assertEquals(CommandType.EXIT, commandResult.getType());
    }

    @Test
    public void equals() {
        CommandResult commandResult = new CommandResult("feedback", CommandType.EXIT);

        // same values -> returns true
        assertTrue(commandResult.equals(new CommandResult("feedback", CommandType.EXIT)));

        // same object -> returns true
        assertTrue(commandResult.equals(commandResult));

        // null -> returns false
        assertFalse(commandResult.equals(null));

        // different types -> returns false
        assertFalse(commandResult.equals(0.5f));

        // different feedbackToUser value -> returns false
        assertFalse(commandResult.equals(new CommandResult("different", CommandType.EXIT)));

        // different type value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", CommandType.MODULE)));
    }

    @Test
    public void hashcode() {
        CommandResult commandResult = new CommandResult("feedback", CommandType.EXIT);

        // same values -> returns same hashcode
        assertEquals(commandResult.hashCode(), new CommandResult("feedback", CommandType.EXIT).hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("different", CommandType.EXIT).hashCode());

        // different type value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("feedback", CommandType.MODULE).hashCode());
    }
}
