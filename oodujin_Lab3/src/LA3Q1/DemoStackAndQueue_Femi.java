package LA3Q1;

import java.util.Scanner;

public class DemoStackAndQueue_Femi {
    public static Scanner input = new Scanner(System.in);

    public DemoStackAndQueue_Femi() { //this is an empty constructor (no parameters)
    }

    public static void myHeader(int n) { // the header method
        final String YourFirstName, YourLastName, GoalOfExercise; // hardcoded String variables
        final int YourStudentNumber = 251368776; // hardcoded int variable
        String SeparationBars = "=======================================================";
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Demonstrate understanding of the Stack and Queue data structures with the aid of an array!";

        System.out.printf("%s\nLab Exercise %d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, n, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    public static void myFooter(int n) { // the footer method
        final String YourFirstName = "Femi"; // hardcoded String variable
        String SeparationBars = "=======================================================";
        System.out.printf("%s\nCompletion of Lab Exercise %d is successful!\nSigning off - %s\n%s",
                SeparationBars, n, YourFirstName, SeparationBars);
    }

    public static void stackDemo(FemiArray array) {
        System.out.printf("\nYou have an empty stack: %s\n\n", array);

        // while loop to keep choice active unless exited
        while (true) {
            System.out.print("Stack Operation Menu:\na: Push\nb: Pop\nc: Exit\nEnter your choice: ");
            char choice = input.next().charAt(0);

            if (choice == 'a') {
                System.out.print("Let's push a data-item into the stack....\nEnter year: ");
                int year = input.nextInt();
                System.out.print("Enter name: ");
                String name = input.next();
                array.addAtLastIndex(new Pair<>(year, name));
                System.out.printf("The current stack: %s\n\n", array);
            }
            else if (choice == 'b') {
                // setting a new variable to hold the newly popped value
                Pair popped = array.removeFromLastIndex();
                // if statement to check if array can't be popped because it is already empty
                if (popped != null) {
                    System.out.printf("Let's pop a data-item....\n%s is removed! The current stack: %s\n\n", popped, array);
                }
                else {
                    System.out.print("Let's pop a data-item....\nFYI: The stack is empty!\n\n");
                }
            }
            else if (choice == 'c') {
                System.out.println("Ending Stack-demo! Goodbye!\n");
                break;
            }
            else {
                System.out.println("Invalid choice!\n");
            }
        }
    }

    public static void queueDemo(FemiArray array) {
        System.out.printf("\nYou have an empty queue: %s", array);

        // while loop to keep choice active unless exited
        while (true) {
            System.out.print("\n\nQueue Operation Menu:\na: Enqueue\nb: Dequeue\nc: Exit\nEnter your choice: ");
            char choice = input.next().charAt(0);

            if (choice == 'a') {
                System.out.print("Let's enqueue a data-item in the queue....\nEnter year: ");
                int year = input.nextInt();
                System.out.print("Enter name: ");
                String name = input.next();
                array.addAtLastIndex(new Pair<>(year, name));
                System.out.printf("The current queue: %s", array);
            }
            else if (choice == 'b') {
                // setting a new variable to hold the newly dequeued value
                Pair dequeued = array.removeFromFirstIndex();
                // if statement to check if array can't be dequeued because it is already empty
                if (dequeued != null) {
                    System.out.printf("Let's dequeue a data-item....\n%s is dequeued! The current queue: %s", dequeued, array);
                }
                else {
                    System.out.print("Let's dequeue a data-item....\nFYI: The queue is empty!");
                }
            }
            else if (choice == 'c') {
                System.out.println("Ending Queue-demo! Goodbye!\n");
                break;
            }
            else {
                System.out.print("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        myHeader(3);

        System.out.println("\nThe code performs a demo for Stack and Queue:\n");

        FemiArray x = null;

        // while loop to keep choice active unless exited
        while (true) {
            System.out.print("Main Demo-Menu:\n\t1: Stack\n\t2: Queue\n\t3: Exit\n\tEnter your choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                x = new FemiArray();
                stackDemo(x);
            }
            else if (choice == 2) {
                x = new FemiArray();
                queueDemo(x);
            }
            else if (choice == 3) {
                System.out.println("Goodbye!\n");
                break;
            }
            else {
                System.out.println("Invalid choice!\n");
            }
        }
        myFooter(3);
    }
}