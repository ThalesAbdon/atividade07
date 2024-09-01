import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    String processName;
    int processId;

    public Process(String processName, int processId) {
        this.processName = processName;
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "Process ID " + processId + ": " + processName;
    }
}

class ProcessQueue {
    private Queue<Process> queue;
    private int nextId;

    public ProcessQueue() {
        this.queue = new LinkedList<>();
        this.nextId = 1;
    }

    public void addProcess(String processName) {
        Process newProcess = new Process(processName, nextId++);
        queue.add(newProcess);
        System.out.println("Added to queue: " + newProcess);
    }

    public void executeNextProcess() {
        if (queue.isEmpty()) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process process = queue.poll();
        System.out.println("Executing: " + process);
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("The process queue is empty.");
            return;
        }
        System.out.println("Current process queue:");
        for (Process process : queue) {
            System.out.println(process);
        }
    }
}

public class ProcessManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessQueue processQueue = new ProcessQueue();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add process to queue");
            System.out.println("2. Execute next process");
            System.out.println("3. Show process queue");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter process name: ");
                    String processName = scanner.nextLine();
                    processQueue.addProcess(processName);
                    break;
                case 2:
                    processQueue.executeNextProcess();
                    break;
                case 3:
                    processQueue.showQueue();
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
