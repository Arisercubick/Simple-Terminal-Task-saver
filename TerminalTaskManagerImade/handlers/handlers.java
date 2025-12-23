package TerminalTaskManagerImade.handlers;

import java.util.Scanner;

public class handlers {
    private static Scanner reader = new Scanner(System.in);

    public int optionHandler(int options) {
        int userInput = 0;
        while (userInput == 0) {
            try {
                System.out.println("Where do you want to go: ");
                userInput = reader.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                reader.nextLine();
            }
            if (!(userInput > 0 && userInput <= options)) {
                System.out.println("Pick a valid option");
                userInput = 0;
            }
        }

        reader.nextLine();
        return userInput;
    }

    public String addTask() {
        boolean validInput = false;
        String userInput;
        String newInput = " ";
        while (!validInput) {
            System.out.print("\nAdd your task: ");
            userInput = reader.nextLine();
            for (int i = 0; i < userInput.length() && !validInput; i++) {
                if (userInput.charAt(i) != ' ') {
                    validInput = true;
                    for (int j = i; j < userInput.length(); j++) {
                        newInput += userInput.charAt(j);
                    }
                }
            }

            if (!validInput) {
                System.out.println("Invalid Input");
            }
        }
        return newInput;
    }
}
