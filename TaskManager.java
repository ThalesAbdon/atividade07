import java.util.Scanner;

class Task {
    String description;
    boolean completed;
    Task next;

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.next = null;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return description + (completed ? " (Completed)" : " (Pending)");
    }
}

class TaskList {
    private Task first;

    public TaskList() {
        this.first = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        if (first == null) {
            first = newTask;
        } else {
            Task current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added: " + description);
    }

    public void removeTask(String description) {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (first.description.equals(description)) {
            first = first.next;
            System.out.println("Task removed: " + description);
            return;
        }

        Task current = first;
        while (current.next != null && !current.next.description.equals(description)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task removed: " + description);
        } else {
            System.out.println("Task not found: " + description);
        }
    }

    public void markTaskAsCompleted(String description) {
        Task current = first;
        while (current != null) {
            if (current.description.equals(description)) {
                current.markAsCompleted();
                System.out.println("Task completed: " + description);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + description);
    }

    public void displayTasks() {
        if (first == null) {
            System.out.println("The task list is empty.");
            return;
        }

        Task current = first;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Display tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    list.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String removeDescription = scanner.nextLine();
                    list.removeTask(removeDescription);
                    break;
                case 3:
                    System.out.print("Enter task description to mark as completed: ");
                    String completeDescription = scanner.nextLine();
                    list.markTaskAsCompleted(completeDescription);
                    break;
                case 4:
                    System.out.println("\nTask list:");
                    list.displayTasks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Task Manager.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
