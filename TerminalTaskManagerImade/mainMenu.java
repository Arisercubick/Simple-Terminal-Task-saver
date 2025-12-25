package TerminalTaskManagerImade;

import TerminalTaskManagerImade.handlers.*;
import TerminalTaskManagerImade.handlers.storage.*;

public class mainMenu {
    private static final handlers handle = new handlers();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        TaskManager TaskStorage = new TaskManager();
        String[] tasks = TaskStorage.loadTasks();
        boolean stayInMenu = true;
        while (stayInMenu) {
            System.out.print("\nWelcome to your task manager\n[1] Add a Task\n[2] View Tasks\n[3] Mark a Task as complete\n[4] Exit\n");
            int userInput = handle.optionHandler(4);
            if (userInput == 1) {
                tasks = handle.addTask(tasks);
            } else if (userInput == 2) {
                handle.printArray(tasks);
            } else if (userInput == 3) {
                tasks = handle.CompletedTask(tasks);
            } else {
                stayInMenu = false;
            }
        }
        TaskStorage.saveTasks(tasks);
    }
}