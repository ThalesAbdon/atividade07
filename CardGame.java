import java.util.Scanner;

class Card {
    String suit;
    String rank;
    Card prev;
    Card next;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Hand {
    private Card first;
    private Card last;

    public Hand() {
        this.first = null;
        this.last = null;
    }

    public void addCard(String suit, String rank) {
        Card newCard = new Card(suit, rank);
        if (first == null) {
            first = newCard;
            last = newCard;
        } else {
            last.next = newCard;
            newCard.prev = last;
            last = newCard;
        }
        System.out.println("Added card: " + newCard);
    }

    public void removeCard(String suit, String rank) {
        Card current = first;
        while (current != null) {
            if (current.suit.equals(suit) && current.rank.equals(rank)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    first = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    last = current.prev;
                }
                System.out.println("Removed card: " + current);
                return;
            }
            current = current.next;
        }
        System.out.println("Card not found: " + rank + " of " + suit);
    }

    public void showHand() {
        if (first == null) {
            System.out.println("Hand is empty.");
            return;
        }
        Card current = first;
        System.out.println("Current Hand:");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void reorganizeCard(String suit, String rank) {
        Card current = first;
        while (current != null) {
            if (current.suit.equals(suit) && current.rank.equals(rank)) {
                if (current != last) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    if (current == first) {
                        first = current.next;
                    }
                    current.next = null;
                    current.prev = last;
                    last.next = current;
                    last = current;
                }
                System.out.println("Reorganized card: " + current);
                return;
            }
            current = current.next;
        }
        System.out.println("Card not found: " + rank + " of " + suit);
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hand hand = new Hand();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add card");
            System.out.println("2. Remove card");
            System.out.println("3. Show hand");
            System.out.println("4. Reorganize card");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter suit of card: ");
                    String suitAdd = scanner.nextLine();
                    System.out.print("Enter rank of card: ");
                    String rankAdd = scanner.nextLine();
                    hand.addCard(suitAdd, rankAdd);
                    break;
                case 2:
                    System.out.print("Enter suit of card to remove: ");
                    String suitRemove = scanner.nextLine();
                    System.out.print("Enter rank of card to remove: ");
                    String rankRemove = scanner.nextLine();
                    hand.removeCard(suitRemove, rankRemove);
                    break;
                case 3:
                    hand.showHand();
                    break;
                case 4:
                    System.out.print("Enter suit of card to reorganize: ");
                    String suitReorg = scanner.nextLine();
                    System.out.print("Enter rank of card to reorganize: ");
                    String rankReorg = scanner.nextLine();
                    hand.reorganizeCard(suitReorg, rankReorg);
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
