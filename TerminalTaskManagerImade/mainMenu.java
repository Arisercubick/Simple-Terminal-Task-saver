package TerminalTaskManagerImade;

import TerminalTaskManagerImade.handlers.*;

public class mainMenu {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String[] tasks = new String[1];
        boolean stayInMenu = true;
        while (stayInMenu) {
            handlers handle = new handlers();

            System.out.print(
                    "\nWelcome to your task manager\n[1] Add a Task\n[2] View Tasks\n[3] Mark a Task as complete\n[4] Exit\n");
            int userInput = handle.optionHandler(4);
            if (userInput == 1) {
                addATask(tasks);
            }
        }
    }

    public static void addATask(String[] tasks) {
        handlers handle = new handlers();

        if (tasks[tasks.length - 1] == null) {
            tasks[tasks.length - 1] = handle.addTask();
        } else {
            String[] copy = new String[tasks.length];
            for (int i = 0; i < tasks.length; i++) {
                copy[i] = tasks[i];
            }

            tasks = new String[tasks.length + 1];
            for (int i = 0; i < copy.length; i++) {
                tasks[i] = copy[i];
            }

            tasks[tasks.length - 1] = handle.addTask();
        }
    }
}