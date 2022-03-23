package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPLETION_STATUS_FALSE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPLETION_STATUS_TRUE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEADLINE_MIDTERM;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEADLINE_TUTORIAL;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_MIDTERM;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_TUTORIAL;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_MIDTERM;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_TUTORIAL;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_CS2102;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_CS2103T;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TaskList;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task CS2105_MIDTERM = new TaskBuilder().withName("CS2105 Midterm")
            .withCompletionStatus("false").withDeadline("2022-03-03")
            .withDescription("Lecture 1-5, Tutorial 1-4")
            .withTags("CS2105", "exam").build();
    public static final Task CS2105_FINALS = new TaskBuilder().withName("CS2105 Finals")
            .withCompletionStatus("false")
            .withDeadline("2022-11-11").withDescription("All lectures and tutorials")
            .withTags("CS2105", "exam").build();
    public static final Task CS2105_TUTORIAL = new TaskBuilder().withName("CS2105 Tutorial")
            .withDescription("Week 9 Tutorial").withDeadline("2022-03-16").withCompletionStatus("false")
            .withTags("CS2105").build();
    public static final Task CS2103T_PROJECT = new TaskBuilder().withName("CS2103T Project")
            .withDescription("V1.2b completion").withDeadline("2022-03-13").withCompletionStatus("false")
            .withTags("CS2103T").build();
    public static final Task MEET_ALICE = new TaskBuilder().withName("Meet Alice")
            .withDescription("Meeting Alice at NUS").withDeadline("2022-04-01").withCompletionStatus("false").build();
    public static final Task BUY_ART_SUPPLIES = new TaskBuilder().withName("Buy Art Supplies")
            .withDescription("Buy Art supplies for art project").withDeadline("2022-03-21")
            .withCompletionStatus("false").build();
    public static final Task APPLY_INTERNSHIP = new TaskBuilder().withName("Apply Internship")
            .withDescription("Apply for opening at Shopee").withDeadline("2022-03-24")
            .withCompletionStatus("false").build();

    // Manually added
    public static final Task CALL_BOB = new TaskBuilder().withName("Call Bob")
            .withDescription("Call Bob to discuss when to meet").withDeadline("2022-03-05")
            .withCompletionStatus("false").build();
    public static final Task CS2107_ASSIGNMENT = new TaskBuilder().withName("CS2107 Assignment")
            .withDescription("Assignment 2").withDeadline("2022-03-20").withCompletionStatus("false").build();

    // Manually added - Task's details found in {@code CommandTestUtil}
    public static final Task CS2103T_TUTORIAL = new TaskBuilder().withName(VALID_NAME_TUTORIAL)
            .withDescription(VALID_DESCRIPTION_TUTORIAL).withDeadline(VALID_DEADLINE_TUTORIAL)
            .withCompletionStatus(VALID_COMPLETION_STATUS_TRUE).withTags(VALID_TAG_CS2103T).build();
    public static final Task CS2102_MIDTERM = new TaskBuilder().withName(VALID_NAME_MIDTERM)
            .withDescription(VALID_DESCRIPTION_MIDTERM).withDeadline(VALID_DEADLINE_MIDTERM)
            .withCompletionStatus(VALID_COMPLETION_STATUS_FALSE).withTags(VALID_TAG_CS2102, VALID_TAG_TEST).build();

    public static final String KEYWORD_MATCHING_NUS = "NUS"; // A keyword that matches NUS

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskList} with all the typical Tasks.
     */
    public static TaskList getTypicalTaskList() {
        TaskList tl = new TaskList();
        for (Task Task : getTypicalTasks()) {
            tl.addTask(Task);
        }
        return tl;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(CS2103T_PROJECT, CS2105_FINALS, CS2105_MIDTERM,
                CS2105_TUTORIAL, MEET_ALICE));
    }
}
