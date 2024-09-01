import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PrintJob {
    String documentName;
    int jobId;

    public PrintJob(String documentName, int jobId) {
        this.documentName = documentName;
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "Print Job " + jobId + ": " + documentName;
    }
}

class PrintQueue {
    private Queue<PrintJob> queue;
    private int nextId;

    public PrintQueue() {
        this.queue = new LinkedList<>();
        this.nextId = 1;
    }

    public void addJob(String documentName) {
        PrintJob newJob = new PrintJob(documentName, nextId++);
        queue.add(newJob);
        System.out.println("Added to queue: " + newJob);
    }

    public void processNextJob() {
        if (queue.isEmpty()) {
            System.out.println("No print jobs in the queue.");
            return;
        }
        PrintJob job = queue.poll();
        System.out.println("Processing: " + job);
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("The print queue is empty.");
            return;
        }
        System.out.println("Current print queue:");
        for (PrintJob job : queue) {
            System.out.println(job);
        }
    }
}

public class PrintManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintQueue printQueue = new PrintQueue();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add print job to queue");
            System.out.println("2. Process next print job");
            System.out.println("3. Show print queue");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter document name: ");
                    String documentName = scanner.nextLine();
                    printQueue.addJob(documentName);
                    break;
                case 2:
                    printQueue.processNextJob();
                    break;
                case 3:
                    printQueue.showQueue();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}