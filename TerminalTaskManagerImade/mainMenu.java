package TerminalTaskManagerImade;

import TerminalTaskManagerImade.handlers.*;

public class mainMenu {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        handlers handle = new handlers();

        System.out.print(
                "\nWelcome to your task manager\n[1] Add a Task\n[2] View Tasks\n[3] Mark a Task as complete\n[4] Exit\n");
        int userInput = handle.optionHandler(4);
        System.out.println(userInput);
    }
}