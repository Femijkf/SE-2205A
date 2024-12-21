package Q1L1;
import java.util.Scanner;

public class TestingExecutionTime {
    public static void myHeader(int n) { //
        final String YourFirstName, YourLastName, GoalOfExercise; // hardcoded String variables
        final int YourStudentNumber = 251368776; // hardcoded int variable
        String SeparationBars = "=======================================================";
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Checking the code-execution time!";

        System.out.printf("%s\nLab Exercise 1-Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                            SeparationBars, n, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    public static void myFooter(int n) {
        final String YourFirstName = "Femi"; // hardcoded String variable
        String SeparationBars = "=======================================================";
        System.out.printf("%s\nCompletion of Lab Exercise 1-Q%d is successful!\nSigning off - %s\n%s",
                            SeparationBars, n, YourFirstName, SeparationBars);
    }

    public static double iterativeMethodForFactorial(int n) { //iterative method to find factorial
        double result = 1;
        int i = 1;
        while (i <= n) {
            result = result*i;
            i++;
        }
        return result;
    }

    public static double recursiveMethodFactorial(int n) { //recursive method to find factorial
        if (n == 0) {
            return 1;
        }
        else {
            //recursively calling the function
            return n*recursiveMethodFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        myHeader(1); // calling the Header method

        int n;
        do { // do while loop to check if integer 0 or greater is selected
            Scanner input = new Scanner(System.in);
            System.out.print("Enter an integer number: ");
            n = input.nextInt();
        } while(n < 0);

        // iterative solution within the main
        double answer = 1;
        int j = 1;
        long start = System.nanoTime();
        while (j <= n) {
            answer = answer*j;
            j++;
        }
        long end = System.nanoTime();
        double time = (end - start)/1000000000.0;

        System.out.printf("Factorial (%d) is %.0e\n", n, answer);
        System.out.printf("Time taken by iterative solution inside main: %.2e sec\n", time);

        // reusing time for new time values
        start = System.nanoTime();
        double iterative = iterativeMethodForFactorial(n);
        end = System.nanoTime();
        System.out.printf("Factorial (%d) with iterative method is %.0e\n", n, iterative);
        time = (end - start)/1000000000.0;
        System.out.printf("Time taken by iterative method call: %.2e sec\n", time);

        start = System.nanoTime();
        double recursive = recursiveMethodFactorial(n);
        end = System.nanoTime();
        System.out.printf("Factorial (%d) with recursive call is %.0e\n", n, recursive);
        time = (end - start)/1000000000.0;
        System.out.printf("Time taken by recursive method call: %.2e sec\n", time);

        myFooter(1); // calling the Footer method
    }
}