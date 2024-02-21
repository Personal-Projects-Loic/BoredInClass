import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
    
        while (running) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "1":
                case "Add Task":
                    addTask();
                    break;
                case "2":
                case "Mark Task as Completed":
                    markTaskAsCompleted();
                    break;
                case "3":
                case "Delete Task":
                    deleteTask();
                    break;
                case "4":
                case "View Tasks":
                    viewTasks();
                    break;
                case "5":
                case "Exit":
                    running = false;
                    System.out.println("Exiting...\n");
                    break;
                default:
                    System.out.println("Invalid choice. Dude choose something in the list what are you doing.\n");
            }
        }
    }
    

    private static void addTask() {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.\n");
    }

    private static void markTaskAsCompleted() {
        System.out.print("Enter task number to mark as completed: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            System.out.println("Marking task '" + task + "' as completed.\n");
            tasks.remove(index);
        } else {
            System.out.println("Invalid task number.\n");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            System.out.println("Deleting task '" + task + "'.\n");
            tasks.remove(index);
        } else {
            System.out.println("Invalid task number.\n");
        }
    }

    private static void viewTasks() {
        System.out.println("\nTasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("\n");
    }
}
