package TerminalTaskManagerImade.handlers;

import java.util.Scanner;

public class handlers {
    public int optionHandler(int options) {
        Scanner reader = new Scanner(System.in);

        int userInput = 0;
        while (userInput == 0) {
            try {
                System.out.println("Where do you want to go: ");
                userInput = reader.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                reader.nextLine();
            }
            System.out.println("HMMMMMMMMM");
            if (!(userInput > 0 && userInput <= options)) {
                System.out.println("Pick a valid option");
                userInput = 0;
            }
        }

        reader.close();
        return userInput;
    }
}
