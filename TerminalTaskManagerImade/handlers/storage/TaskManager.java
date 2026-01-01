package handlers.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {

    private static final String FILE_NAME = "TerminalTaskManagerImade/handlers/storage/tasks.txt";

    public String[] loadTasks() {
        File file = new File(FILE_NAME);

        try {
            // Count the amount of lines
            Scanner counter = new Scanner(file);
            int count = 0;
            while (counter.hasNextLine()) {
                counter.nextLine();
                count++;
            }
            counter.close();
            // This just reads the tasks
            String[] tasks = new String[count];
            Scanner reader = new Scanner(file);
            int i = 0;
            while (reader.hasNextLine()) {
                tasks[i++] = reader.nextLine();
            }
            reader.close();
            return tasks;

        } catch (Exception e) {
            System.out.println("failed to read tasks.");
            return new String[1];
        }
    }

    public void saveTasks(String[] tasks) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);

            for (String task : tasks) {
                if (task != null) {
                    writer.write(task + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save tasks.");
        }
    }

}
