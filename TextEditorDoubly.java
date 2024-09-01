import java.util.Scanner;

class EditNode {
    String action;
    EditNode prev;
    EditNode next;

    public EditNode(String action) {
        this.action = action;
        this.prev = null;
        this.next = null;
    }
}

class TextEditorHistory {
    private EditNode current;
    private EditNode head;
    private EditNode redoHead;

    public TextEditorHistory() {
        this.head = new EditNode("");
        this.current = head;
        this.redoHead = null;
    }

    public void performAction(String newText) {
        EditNode newNode = new EditNode(newText);

        current.next = newNode;
        newNode.prev = current;

        current = newNode;

        redoHead = null;

        System.out.println("Performed action: " + newText);
    }

    public void undo() {
        if (current == head) {
            System.out.println("No actions to undo.");
            return;
        }

        EditNode undoNode = new EditNode(current.action);
        undoNode.next = redoHead;
        redoHead = undoNode;

        current = current.prev;

        System.out.println("Undo action. Current text: " + (current != null ? current.action : ""));
    }

    public void redo() {
        if (redoHead == null) {
            System.out.println("No actions to redo.");
            return;
        }

        EditNode redoNode = redoHead;
        redoHead = redoHead.next;

        current.next = redoNode;
        redoNode.prev = current;
        current = redoNode;

        System.out.println("Redo action. Current text: " + current.action);
    }

    public void showCurrentText() {
        System.out.println("Current text: " + current.action);
    }
}

public class TextEditorDoubly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditorHistory history = new TextEditorHistory();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add text");
            System.out.println("2. Undo last action");
            System.out.println("3. Redo last undone action");
            System.out.println("4. Show current text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String newText = scanner.nextLine();
                    history.performAction(newText);
                    break;
                case 2:
                    history.undo();
                    break;
                case 3:
                    history.redo();
                    break;
                case 4:
                    history.showCurrentText();
                    break;
                case 5:
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
