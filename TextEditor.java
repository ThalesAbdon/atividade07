import java.util.Scanner;

class TextEditNode {
    String action;
    String previousText;
    TextEditNode next;

    public TextEditNode(String action, String previousText) {
        this.action = action;
        this.previousText = previousText;
        this.next = null;
    }
}

class TextEditorHistory {
    private TextEditNode top;
    private String currentText;

    public TextEditorHistory() {
        this.top = null;
        this.currentText = "";
    }

    public void performAction(String newText) {
        TextEditNode newNode = new TextEditNode(newText, currentText);
        newNode.next = top;
        top = newNode;
        currentText = newText;
        System.out.println("Performed action: " + newText);
    }

    public void undo() {
        if (top == null) {
            System.out.println("No actions to undo.");
            return;
        }

        currentText = top.previousText;
        System.out.println("Undone action. Current text: " + currentText);
        top = top.next;
    }

    public void showCurrentText() {
        System.out.println("Current text: " + currentText);
    }

    public String getCurrentText() {
        return currentText;
    }
}

public class TextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditorHistory history = new TextEditorHistory();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add text");
            System.out.println("2. Undo last action");
            System.out.println("3. Show current text");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String newText = scanner.nextLine();
                    history.performAction(history.getCurrentText() + newText);
                    break;
                case 2:
                    history.undo();
                    break;
                case 3:
                    history.showCurrentText();
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
