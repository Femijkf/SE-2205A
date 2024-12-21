package L4Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {

    public static void myHeader(Student myInfo, int labE_number, int q_number) { // the header method
        final String GoalOfExercise; // hardcoded String variables
        final int YourStudentNumber = 251368776; // hardcoded int variable
        String SeparationBars = "=======================================================";
        GoalOfExercise = "Demonstrate understanding on using Comparator<> Interface, Comparable<> Interface and Collections<> class!";

        System.out.printf("%s\nLab Exercise %d-Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, labE_number, q_number, myInfo.getFirstName(), myInfo.getLastName(), YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    public static void myFooter(int labE_number, int q_number) { // the footer method
        final String YourFirstName = "Femi"; // hardcoded String variable
        String SeparationBars = "=======================================================";
        System.out.printf("%s\nCompletion of Lab Exercise %d-Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, labE_number, q_number, YourFirstName, SeparationBars);
    }

    public static void main(String[] args) {
        //creating student instance for header method
        Student myInfo = new Student();

        //calling the header method
        myHeader(myInfo, 4, 2);

        //creating an ArrayList of Students
        ArrayList<Student> students = new ArrayList<>();
        students.add(myInfo); //adds my info from the Student() constructor with no arguments
        students.add(new Student("Harry", "Potter", 75.5));
        students.add(new Student("Ronald", "Weasley", 86.0));
        students.add(new Student("Hermione", "Granger", 91.7));
        students.add(new Student("Parvati", "Patil", 93.75));

        //printing the score card using toString() method
        System.out.println("The Score Card:");
        for (Student s : students) {
            System.out.print(s);
        }

        //sorting the descending score order
        Collections.sort(students);
        System.out.println("\nThe sorted list in terms of score in descending order....");
        for (Student s : students) {
            System.out.print(s);
        }

        //sorting by last names alphabetically using HelperClassCompareLastNames
        Collections.sort(students, new HelperClassCompareLastNames());
        System.out.println("\nThe sorted list in terms of Last Names....");
        for (Student s : students) {
            System.out.print(s);
        }

        //sorting by first names alphabetically using HelperClassCompareFirstNames
        Collections.sort(students, new HelperClassCompareFirstNames());
        System.out.println("\nThe sorted list in terms of First Names....");
        for (Student s : students) {
            System.out.print(s);
        }
        System.out.print("\n");

        //calling the footer method
        myFooter(4,2);
    }

}
