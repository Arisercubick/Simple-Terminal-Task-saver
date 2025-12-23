package TerminalTaskManagerImade.handlers;

import java.util.Scanner;

public class handlers {
    public int optionHandler(int options) {
        Scanner reader = new Scanner(System.in);

        int[] arr = new int[options];
        for (int i = 1, j = 0; i <= options; i++, j++) {
            arr[j] = i;
        }

        int userInput = 0;
        while (userInput == 0) {
            try {
                System.out.println("Where do you want to go: ");
                userInput = reader.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                reader.nextLine();
            }

            boolean choice = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == userInput) {
                    choice = true;
                }
            }
            if (!choice) {
                System.out.println("Pick a valid option");
                userInput = 0;
            }
        }

        reader.close();
        return userInput;
    }
}
