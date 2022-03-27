---
layout: page
title: User Guide
---

Harmonia is a **desktop app for managing tasks related to your academic life, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Harmonia can get your task management done faster than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------
## Table of Contents
- [Quick Start](#quick-start)
- [Features](#features)
  - [Adding a task: add](#adding-a-task-add)
  - [Listing all tasks: list](#listing-all-tasks-list)
  - [Deleting a task: delete](#deleting-a-task-delete)
  - [Locating a task: find](#locating-a-task-find)
  - [Marking as complete: mark](#marking-as-complete--mark)
  - [Marking as complete: unmark](#marking-as-incomplete--unmark)
  - [Editing a task: edit](#editing-a-task--edit)
  - [Exiting the program: exit](#exiting-the-program--exit)
  - [Saving the data](#saving-the-data)
- [Command Summary](#command-summary)


## Quick start

1. Ensure that you have Java `11` or above installed in your Computer.
2. Download the latest `Harmonia.jar` from [here](https://github.com/AY2122S2-CS2103T-T09-1/tp.git)
3. Copy the file to the folder you want to use as the home folder for your Harmonia.
4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds.
   ![Ui](images/Ui.png)
5. Type the command in the command box and press Enter to execute it. (E.g type `list` to list down all the tasks)

--------------------------------------------------------------------------------------------------------------------
## Features

### Adding a task: `add`

Adds a task into the Harmonia.

Format:  `add d/DESCRIPTION`
Example: `add d/CS2103T tp meeting`

### Listing all tasks: `list`

Shows a list of all the existing tasks in the task list.

Format: `list`

### Deleting a task: `delete`

Deletes a specified task from Harmonia.

Format: `delete INDEX`
- Deletes the task at the specified `INDEX` from the task list.
- The index refers to the index number shown in the displayed task list.
- The index **must be a positive integer** 1, 2, 3

Example: `delete 3` deletes the 3rd task in the task list

### Locating a task: `find`

Finds a task which description or tag contains the given keywords.

Format:
- `find KEYWORD [MORE KEYWORDS]`
- `find t/TAG`

Example:
- `find book`
- `find book read`
- `find t/CS2103T`


### Marking as complete : `mark`

Marks specified task from the existing task list from as complete.

Format: `mark INDEX`
- Marks the task at the specified `INDEX` as complete.
- The index refers to the index number shown in the displayed task list.
- The index **must be a positive integer** 1, 2, 3,


Example: `list` followed by `mark 2` marks the 2nd task in the task list as complete.

### Marking as incomplete : `unmark`

Marks specified task from the existing task list from as incomplete.

Format: `unmark INDEX`
- Marks the task at the specified `INDEX` as incomplete.
- The index refers to the index number shown in the displayed task list.
- The index **must be a positive integer** 1, 2, 3,


Example: `list` followed by `unmark 3` marks the 3rd task in the task list as incomplete.

### Editing a task : `edit`

Edits the specified task in the task list.

Format: `edit INDEX [d/DESCRIPTION] [t/TAG]`
- Edits the task at the specified `INDEX`. The index refers to the index number shown in the displayed task list. The index **must be a positive integer** 1, 2, 3, …​
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- When editing tags, the existing tags of the task will be removed i.e adding of tags is not cumulative.
- You can remove all the task’s tags by typing `t/` without specifying any tags after it.

Example: `edit 2 d/Prepare for CS2103T Tutorial` Edits the description of the 2nd task to be `Prepare for CS2103T Tutorial`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

Harmonia's data is saved in the hard disk automatically after any command changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------
## Command summary

| Action     | Format, Examples                                                                                                                  |
|------------|-----------------------------------------------------------------------------------------------------------------------------------|
| **Add**    | `add d/DESCRIPTION` <br> e.g., `add d/read book`                                                                                  |
| **Delete** | `delete INDEX`<br> e.g., `delete 3`                                                                                               |
| **Edit**   | `edit INDEX [d/DESCRIPTION] [t/TAG]`<br> e.g.,`edit 2 n/CS2101 meeting t/CS2101`                                                  |
| **Mark**   | `mark INDEX` <br> e.g., `mark 3`                                                                                                  |
| **Unmark** | `unmark INDEX` <br> e.g., `unmark 3`                                                                                              |
| **List**   | `list`                                                                                                                            |
| **Find**   | `find KEYWORD [MORE_KEYWORDS]` <br> `find t/[TAG]` <br> e.g., `find book` <br> e.g., `find book read` <br> e.g., `find t/CS2103T` |
| **Exit**   | `exit`                                                                                                                            |
