//package seedu.address.logic.commands;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
//import static seedu.address.testutil.Assert.assertThrows;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import seedu.address.commons.core.index.Index;
//import seedu.address.logic.commands.exceptions.CommandException;
//import seedu.address.model.TaskList;
//import seedu.address.model.Model;
//import seedu.address.model.task.NameContainsKeywordsPredicate;
//import seedu.address.model.task.Task;
//import seedu.address.testutil.EditTaskDescriptorBuilder;
//
///**
// * Contains helper methods for testing commands.
// */
//public class CommandTestUtil {
//
//    public static final String VALID_NAME_TUTORIAL = "Complete Tutorial";
//    public static final String VALID_NAME_MIDTERM = "Midterm Test";
//    public static final String VALID_DESCRIPTION_TUTORIAL = "Week 9 Tutorial, draw OODM & activity diagram";
//    public static final String VALID_DESCRIPTION_MIDTERM = "Chapter 1-3";
//    public static final String VALID_DEADLINE_TUTORIAL = "2022-03-17";
//    public static final String VALID_DEADLINE_MIDTERM = "2022-03-21";
//    public static final String VALID_COMPLETION_STATUS_TRUE = "true";
//    public static final String VALID_COMPLETION_STATUS_FALSE = "false";
//    public static final String VALID_TAG_CS2103T = "CS2103T";
//    public static final String VALID_TAG_CS2102 = "CS2102";
//    public static final String VALID_TAG_TEST = "Test";
//
//    public static final String NAME_DESC_TUTORIAL = " " + PREFIX_NAME + VALID_NAME_TUTORIAL;
//    public static final String NAME_DESC_MIDTERM = " " + PREFIX_NAME + VALID_NAME_MIDTERM;
//    public static final String DESCRIPTION_DESC_TUTORIAL = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_TUTORIAL;
//    public static final String DESCRIPTION_DESC_MIDTERM = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_MIDTERM;
//    public static final String DEADLINE_DESC_TUTORIAL = " " + PREFIX_DEADLINE + VALID_DEADLINE_TUTORIAL;
//    public static final String DEADLINE_DESC_MIDTERM = " " + PREFIX_DEADLINE + VALID_DEADLINE_MIDTERM;
//    public static final String TAG_DESC_CS2103T = " " + PREFIX_TAG + VALID_TAG_CS2103T;
//    public static final String TAG_DESC_CS2102 = " " + PREFIX_TAG + VALID_TAG_CS2102;
//    public static final String TAG_DESC_TEST = " " + PREFIX_TAG + VALID_TAG_TEST;
//
//    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME; // empty string not allowed for names
//    public static final String INVALID_DESCRIPTION_DESC = " " + PREFIX_DESCRIPTION + "Lorem ipsum dolor sit amet, "
//            + "consectetur adipiscing elit. Sed metus diam, egestas sed ante pulvinar, fermentum dignissim arcu. "
//            + "Donec pellentesque massa vel dolor blandit imperdiet. In bibendum justo urna, vitae venenatis "
//            + "magna dictum quis. Proin erat curae."; // description should not be more than 255 characters
//    public static final String INVALID_DEADLINE_DESC = " " + PREFIX_DEADLINE + "2022/01/01"; // wrong date format
//    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "test*"; // '*' not allowed in tags
//
//    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
//    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";
//
//    public static final EditCommand.EditTaskDescriptor DESC_TUTORIAL;
//    public static final EditCommand.EditTaskDescriptor DESC_MIDTERM;
//
//    static {
//        DESC_TUTORIAL = new EditTaskDescriptorBuilder().withName(VALID_NAME_TUTORIAL)
//                .withDescription(VALID_DESCRIPTION_TUTORIAL).withDeadline(VALID_DEADLINE_TUTORIAL)
//                .withTags(VALID_TAG_CS2103T).build();
//        DESC_MIDTERM = new EditTaskDescriptorBuilder().withName(VALID_NAME_MIDTERM)
//                .withDescription(VALID_DESCRIPTION_MIDTERM).withDeadline(VALID_DEADLINE_MIDTERM)
//                .withTags(VALID_TAG_CS2102, VALID_TAG_TEST).build();
//    }
//
//    /**
//     * Executes the given {@code command}, confirms that <br>
//     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
//     * - the {@code actualModel} matches {@code expectedModel}
//     */
//    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
//            Model expectedModel) {
//        try {
//            CommandResult result = command.execute(actualModel);
//            assertEquals(expectedCommandResult, result);
//            assertEquals(expectedModel, actualModel);
//        } catch (CommandException ce) {
//            throw new AssertionError("Execution of command should not fail.", ce);
//        }
//    }
//
//    /**
//     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
//     * that takes a string {@code expectedMessage}.
//     */
//    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
//            Model expectedModel) {
//        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
//        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
//    }
//
//    /**
//     * Executes the given {@code command}, confirms that <br>
//     * - a {@code CommandException} is thrown <br>
//     * - the CommandException message matches {@code expectedMessage} <br>
//     * - the task list, filtered task list and selected task in {@code actualModel} remain unchanged
//     */
//    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
//        // we are unable to defensively copy the model for comparison later, so we can
//        // only do so by copying its components.
//        TaskList expectedTaskList = new TaskList(actualModel.getTaskList());
//        List<Task> expectedFilteredList = new ArrayList<>(actualModel.getFilteredTaskList());
//
//        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
//        assertEquals(expectedTaskList, actualModel.getTaskList());
//        assertEquals(expectedFilteredList, actualModel.getFilteredTaskList());
//    }
//
//    /**
//     * Updates {@code model}'s filtered list to show only the task at the given {@code targetIndex} in the
//     * {@code model}'s task list.
//     */
//    public static void showTaskAtIndex(Model model, Index targetIndex) {
//        assertTrue(targetIndex.getZeroBased() < model.getFilteredTaskList().size());
//
//        Task task = model.getFilteredTaskList().get(targetIndex.getZeroBased());
//        final String[] splitName = task.getName().fullName.split("\\s+");
//        model.updateFilteredTaskList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));
//
//        assertEquals(1, model.getFilteredTaskList().size());
//    }
//
//}
