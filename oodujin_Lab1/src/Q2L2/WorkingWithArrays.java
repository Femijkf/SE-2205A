package Q2L2;
import java.util.Scanner;

public class WorkingWithArrays {
    public static void myHeader(int n) {
        final String YourFirstName, YourLastName, GoalOfExercise; // hardcoded String variables
        final int YourStudentNumber = 251368776; // hardcoded int variable
        String SeparationBars = "=======================================================";
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Working with arrays and conditional statements!";

        System.out.printf("%s\nLab Exercise 1-Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, n, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    public static void myFooter(int n) {
        final String YourFirstName = "Femi"; // hardcoded String variable
        String SeparationBars = "=======================================================";
        System.out.printf("%s\nCompletion of Lab Exercise 1-Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, n, YourFirstName, SeparationBars);
    }

    public static double[] mma5MethodFemi(double arr[]) {
        int tally = 0; // tally to count how many numbers in the array are divisible by 5
        double YourStudentNumber = 251368776;
        double maxValue = arr[0];
        double minValue = arr[0];
        double total = 0;
        double averageValue = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) { // if statement to check if the given array number is divisible by 5
                tally = tally + 1;
                maxValue = Math.max(maxValue, arr[i]);
                minValue = Math.min(minValue, arr[i]);
                total = total + arr[i];
            }
        }

        System.out.println("\nHere are the results......");

        if (tally == 1){
            averageValue = total / tally;
            System.out.println("Femi found " + tally + " number that is divisible-by-5");
        }
        else if (tally > 1) { // else if for custom print statement if numbers divisible by 5 is plural
            averageValue = total / tally;
            System.out.println("Femi found " + tally + " numbers that are divisible-by-5");
        }
        else {
            averageValue = total / tally;
            if (Double.isNaN(averageValue)) { // if statement to avoid NaN average
                averageValue = 0;
            }
            System.out.printf("\nIn the array, there was no number ‘divisible by 5’ and hence the average remains %.2f.\n", averageValue);
        }

        double[] finalAnswerArray = {maxValue, minValue, averageValue, YourStudentNumber};
        return finalAnswerArray;
    }

    public static void main(String[] args) {
        myHeader(2); // calling the Header method
        Scanner input = new Scanner(System.in);

        int n;
        do { // do while loop to check if integer 0 or greater is selected
            System.out.print("Enter array size: ");
            n = input.nextInt();
        } while(n < 0);

        double[] firstArray = new double[n];

        for (int i = 0; i<n; i++) {
            System.out.printf("Enter value %d: ", (i+1));
            firstArray[i] = input.nextInt();
        }

        // creating a new array to store all the values needed for the print statement
        double[] solutionsArray = mma5MethodFemi(firstArray);
        if (solutionsArray[2] != 0) {
            System.out.printf("The max is %.2f.\nThe min is %.2f.\nThe average of the 'divisible by 5 numbers' is %.2f.\nMy student number is %.0f.\n",
            solutionsArray[0], solutionsArray[1], solutionsArray[2], solutionsArray[3]);
        }

        myFooter(2); // calling the Footer method
    }
}