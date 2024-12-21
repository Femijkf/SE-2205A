package LA5Q;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AirplaneApplication {

    // Using queues to manage boarding and disembarking passengers
    // Queue is a logical choice here because it operates on a "First In, First Out" (FIFO) basis,
    // meaning that the first person to board will be the first one allowed to disembark.
    private Queue<String> boardingQueue;
    private Queue<String> disembarkingQueue;

    // Display header information about the lab exercise
    public static void myHeader(int labNumber, int questionNumber) {
        // Hardcoded details to identify the student and lab information
        final String YourFirstName, YourLastName, GoalOfExercise;
        final int YourStudentNumber = 251368776;
        String SeparationBars = "=======================================================";

        // Purpose: These details help the grader identify the student and understand the lab's goals
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "To demonstrate understanding of linear data structure design!";

        // Display formatted header
        System.out.printf("%s\nLab Exercise %d-Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, labNumber, questionNumber, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    // Display footer indicating the end of the exercise
    public static void myFooter(int labE_number, int q_number) {
        final String YourFirstName = "Femi";
        String SeparationBars = "=======================================================";

        // Display formatted footer
        System.out.printf("%s\nCompletion of Lab Exercise %d-Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, labE_number, q_number, YourFirstName, SeparationBars);
    }

    // Constructor to initialize the boarding and disembarking queues
    public AirplaneApplication() {
        // LinkedList is used here to implement the Queue interface
        // LinkedLists provide efficient insertion and removal operations, ideal for FIFO queues.
        boardingQueue = new LinkedList<>();
        disembarkingQueue = new LinkedList<>();
    }

    // Adds a passenger to the boarding queue
    public void boardPassenger(String passengerName) {
        // Rationale: The add method in Queue adds the passenger to the end of the boarding list,
        // ensuring the FIFO order for boarding and disembarking operations.
        boardingQueue.add(passengerName);
        System.out.printf("%s is now in the boarding queue.", passengerName);
    }

    // Begins the boarding process, transferring passengers from the boarding queue to the disembarking queue
    public void startBoarding() {
        System.out.println("\nStarting the boarding process...");

        // The while loop here continuously checks if there are any passengers left to board
        while (!boardingQueue.isEmpty()) {
            String passenger = boardingQueue.poll(); // Retrieves and removes the next passenger in line
            disembarkingQueue.add(passenger); // Moves the passenger to the disembarking queue
            System.out.printf("-> %s has boarded the plane.\n", passenger);
        }
        System.out.println("All passengers have boarded the plane!");
    }

    // Begins the disembarking process by removing passengers from the disembarking queue
    public void startDisembarking() {
        System.out.println("\nStarting the disembarking process...");

        // The while loop here operates as long as there are passengers in the disembarking queue
        while (!disembarkingQueue.isEmpty()) {
            String passenger = disembarkingQueue.poll(); // Retrieves and removes the next passenger in line
            System.out.printf("-> %s has disembarked with the plane.\n", passenger);
        }
        System.out.println("All passengers have disembarked");
    }

    // Main method to run the application and present menu options to the user
    public static void main(String[] args) {
        AirplaneApplication app = new AirplaneApplication();
        Scanner input = new Scanner(System.in);

        myHeader(5,1); // Display header information

        System.out.println("Welcome to the Spirit Airlines App!");

        // Main program loop - keeps the application running until user decides to exit
        while (true) {
            System.out.println("\n- Option Select -");
            System.out.println("1 - Add a passenger to the board\n2 - Begin Boarding\n3 - Begin Disembarking\n4 - Exit");

            int choice = 0;

            // Handle invalid inputs gracefully, only accepting integer values 1-4
            while (choice == 0) {
                try {
                    System.out.print("Please enter your choice: ");
                    choice = input.nextInt();
                    input.nextLine(); // Clear newline character
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 - 4.");
                    input.nextLine(); // Clear the invalid input
                    choice = 0; // Reset choice to continue the loop
                }
            }

            // Process user's menu selection
            if (choice == 1) {
                // Option 1: Add passengers to the boarding queue until user enters "2"
                while (true) {
                    System.out.print("\nEnter passenger's name (or press '2' to return to the main menu): ");
                    String name = input.nextLine();

                    if (name.equals("2")) {
                        break; // Break out of loop to return to the main menu
                    } else {
                        app.boardPassenger(name); // Add passenger to the queue
                    }
                }
            } else if (choice == 2) {
                // Option 2: Start boarding process
                app.startBoarding();
            } else if (choice == 3) {
                // Option 3: Start disembarking process
                app.startDisembarking();
            } else if (choice == 4) {
                // Option 4: Exit the application
                System.out.println("\nThanks for using the Spirit Airlines App\n...Exiting Application...");
                input.close(); // Close the input scanner
                myFooter(5,1); // Display footer information
                System.exit(0); // End program
            } else {
                // Catch any unexpected input (this should rarely be reached)
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}