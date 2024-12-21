package LE6Q2;

import java.util.*;

public class Femi_SortNameAndGrade {

    // Display header information about the lab exercise
    public static void myHeader(int labNumber, int questionNumber) {
        // Hardcoded student details and lab-specific information
        final String YourFirstName, YourLastName, GoalOfExercise;
        final int YourStudentNumber = 251368776;
        String SeparationBars = "=======================================================";

        // Define the student details and goal of the exercise
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Creating a StudentGrade class and applying sorting techniques to organize a list of students by names and grade.";

        // Print the formatted header with student information and the goal
        System.out.printf("%s\nLab Exercise %d, Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, labNumber, questionNumber, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    // Display footer indicating the end of the exercise.
    public static void myFooter(int labE_number, int q_number) {
        final String YourFirstName = "Femi";
        String SeparationBars = "=======================================================";

        // Print the formatted footer with completion status
        System.out.printf("%s\nCompletion of Lab Exercise %d, Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, labE_number, q_number, YourFirstName, SeparationBars);
    }

    // Print the contents of the StudentGrade array
    public static void printArray(StudentGrade[] array) {
        for (StudentGrade sg : array) {
            System.out.println("  " + sg);
        }
    }

    // Sort Method (based on key: 1 -> First Name, 2 -> Last Name)
    public static void sort(StudentGrade[] array, int key) {
        if (key == 1) {
            // Sort by first name using Comparator
            Arrays.sort(array, Comparator.comparing(StudentGrade::getFirstName));
        } else if (key == 2) {
            // Sort by last name using Comparator
            Arrays.sort(array, Comparator.comparing(StudentGrade::getLastName));
        }
    }

    public static void main(String[] args) {
        // Display the header
        myHeader(6, 2);

        // Sample Data: Arrays of first names, last names, and grades
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grades = new Integer[fnArray.length];

        // Generate random grades between 60 and 85
        for (int i = 0; i < grades.length; i++) {
            grades[i] = 60 + (int) (Math.random() * 26); // Generate random grade
        }

        // Create a Vector of StudentGrade objects
        Vector<StudentGrade> sgVector = new Vector<>();
        for (int i = 0; i < fnArray.length; i++) {
            sgVector.add(new StudentGrade(fnArray[i], lnArray[i], grades[i]));
        }

        // Print the unsorted list of students
        System.out.println("\nThe Unsorted Array ................");
        for (StudentGrade sg : sgVector) {
            System.out.println("  " + sg);
        }

        // Sort by Grades using Collections.sort
        Collections.sort(sgVector);
        System.out.println("\nSorted by Grades ..................");
        for (StudentGrade sg : sgVector) {
            System.out.println("  " + sg);
        }

        // Copy Vector to Array
        StudentGrade[] sgArray = new StudentGrade[fnArray.length];
        sgVector.copyInto(sgArray);

        // Sort by First Name
        sort(sgArray, 1);
        System.out.println("\nSorted by First Names .............");
        printArray(sgArray);

        // Sort by Last Name
        sort(sgArray, 2);
        System.out.println("\nSorted by Last Names ..............");
        printArray(sgArray);

        // Display the footer
        myFooter(6, 2);
    }
}