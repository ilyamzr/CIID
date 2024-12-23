package org.example;

import java.util.Scanner;

class DequeManager<I> {
    private final AbstractDeque<Integer> deque;

    public DequeManager(AbstractDeque<Integer> deque) {
        this.deque = deque;
    }

    public void manageDeque() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Insert at the front\n2) Insert at the back\n3) Remove from the front\n4) Remove from the back\n5) Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            int item;
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    item = Integer.parseInt(scanner.nextLine());
                    deque.pushLeft(item);
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    item = Integer.parseInt(scanner.nextLine());
                    deque.pushRight(item);
                    break;
                case 3:
                    try {
                        item = deque.popLeft();
                        System.out.println("Removed element: " + item);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        item = deque.popRight();
                        System.out.println("Removed element: " + item);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Current state of the deque: ");
            deque.printDeque();
        }
    }
}