import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    String name;
    int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer " + id + ": " + name;
    }
}

class BankQueue {
    private Queue<Customer> queue;
    private int nextId;

    public BankQueue() {
        this.queue = new LinkedList<>();
        this.nextId = 1;
    }

    public void addCustomer(String name) {
        Customer newCustomer = new Customer(name, nextId++);
        queue.add(newCustomer);
        System.out.println("Added to queue: " + newCustomer);
    }

    public void attendNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue.");
            return;
        }
        Customer customer = queue.poll();
        System.out.println("Attending to: " + customer);
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.println("Current queue:");
        for (Customer customer : queue) {
            System.out.println(customer);
        }
    }
}

public class BankSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankQueue bankQueue = new BankQueue();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Attend next customer");
            System.out.println("3. Show queue");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    bankQueue.addCustomer(name);
                    break;
                case 2:
                    bankQueue.attendNextCustomer();
                    break;
                case 3:
                    bankQueue.showQueue();
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
