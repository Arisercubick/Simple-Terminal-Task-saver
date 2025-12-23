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
                tasks = addATask(tasks);
            } else if (userInput == 2) {
                print(tasks);
            } else if (userInput == 3) {
                tasks = CompletedTask(tasks);
            }
        }
    }

    public static String[] CompletedTask(String[] arr) {
        handlers handle = new handlers();
        return handle.CompletedTask(arr);
    }

    public static String[] addATask(String[] tasks) {
        handlers handle = new handlers();
        return handle.addTask(tasks);
    }

    public static void print(String[] arr) {
        handlers handle = new handlers();
        handle.printArray(arr);
    }
}