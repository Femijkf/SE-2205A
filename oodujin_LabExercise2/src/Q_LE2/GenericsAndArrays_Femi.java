package Q_LE2;
import java.util.Scanner;
import java.util.*;

public class GenericsAndArrays_Femi {
    public static void myHeader(int n) { //
        final String YourFirstName, YourLastName, GoalOfExercise; // hardcoded String variables
        final int YourStudentNumber = 251368776; // hardcoded int variable
        String SeparationBars = "=======================================================";
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Create a data structure that will keep a record of keys and values";

        System.out.printf("%s\nLab Exercise 2-Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, n, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    public static void myFooter(int n) {
        final String YourFirstName = "Femi"; // hardcoded String variable
        String SeparationBars = "=======================================================";
        System.out.printf("%s\nCompletion of Lab Exercise 2-Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, n, YourFirstName, SeparationBars);
    }

    public static void main(String[] args) {
        myHeader(1);

        ArrayList<Integer> yearsOfStudies = new ArrayList(Arrays.asList(2,3,4,3,2,2)); //ArrayList type (integer tag) filled with the integers of the years of studies of the students
        ArrayList<String> namesOfStudents = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent")); //ArrayList type (String tag) filled with the strings of the names of the students

        Pair<Integer, String>[] pairList = new Pair[namesOfStudents.size()];

        for (int i = 0; i < pairList.length; i++) {
            pairList[i] = new Pair<>(yearsOfStudies.get(i), namesOfStudents.get(i));
        }

        System.out.println("The program prints the names of the student leaders from year 2, 3 and 4.\nTo see the list of the students from a specific year enter an integer between 2 and 4 when prompted.\n");
        int year = 0;

        while (true) {
            int counter = 0; //integer to track valid number of years of Studies
            System.out.print("Enter Academic Year (2, 3, or 4): ");
            Scanner input = new Scanner(System.in); //Creates a scanner object called input
            while (true) {
                try {
                    year = input.nextInt();
                    if (year == 2 || year == 3 || year == 4) { //if statement to check for 3 of the year of studies options
                        break;
                    } else {
                        System.out.print("Incorrect input! Enter Academic Year (2, 3, or 4): ");
                    }
                } catch (Exception ex) { //try-catch to exceptions that checks for non-integer values
                    System.out.print("Incorrect Input! The input was not an integer! Enter Academic Year (2, 3, or 4): ");
                    input.nextLine();
                }
            }

            ArrayList<String> leaderList = new ArrayList<>();
            for (int i = 0; i < pairList.length; i++) {
                if (pairList[i].getKey() == year) {
                    leaderList.add(pairList[i].getValue());
                    counter++; //adding onto the counter
                }
            }

            System.out.printf("Found %d leader(s) from year %d.\n", counter, year);
            System.out.printf("Here is the list:\n%s\n", leaderList);
            char resume;
            System.out.print("Do you wish to continue? (Press y to continue and any other key to terminate): ");
            resume = input.next().charAt(0); //checking for only a char value
            if (resume == 'y' || resume == 'Y') {
            }
            else {
                break;
            }
        }
        myFooter(1);
    }
}