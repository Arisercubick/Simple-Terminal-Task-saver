package TerminalTaskManagerImade.handlers;

import java.util.Scanner;

public class handlers {
    private static Scanner reader = new Scanner(System.in);

    public int optionHandler(int options) {
        int userInput = 0;
        while (userInput == 0) {
            try {
                System.out.print("\nWhere do you want to go: ");
                userInput = reader.nextInt();
                if (!(userInput > 0 && userInput <= options)) {
                    System.out.println("Pick a valid option");
                    userInput = 0;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                reader.nextLine();
            }
        }
        reader.nextLine();
        return userInput;
    }

    public String[] addTask(String[] arr) {
        String[] newArr;
        if (arr.length > 0 && arr[arr.length - 1] == null) {
            newArr = new String[arr.length];
        } else {
            newArr = new String[arr.length + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[newArr.length - 1] = addATask(newArr.length);
        return newArr;
    }

    public String addATask(int position) {
        boolean validInput = false;
        String userInput;
        String newInput = "[" + position + "] ";
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

    public String[] CompletedTask(String[] arr) {
        boolean validInput = false;
        int userInput = 0;
        while (!validInput) {
            try {
                printArray(arr);
                System.out.print(
                        "\nWhat is the task you completed. this will permanently delete the task (number of the task): ");
                userInput = reader.nextInt();
            } catch (java.util.InputMismatchException e) {
                reader.next();
                System.out.println("Input an integer");
            }
            if (userInput > 0 && userInput <= arr.length) {
                validInput = true;
            }
        }
        System.out.println("Removing the completed task: " + arr[userInput - 1]);
        String[] newArr = new String[arr.length - 1];
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (!(j == userInput - 1)) {
                newArr[i] = arr[j];
                i++;
            }
        }

        return newArr;
    }

    public void printArray(String[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1) {
                    System.out.print(arr[i] + ", ");
                } else {
                    System.out.println(arr[i]);
                }
            }
        } else {
            System.out.println("you have no tasks");
        }
    }
}
