package LE6Q2;

public class StudentGrade implements Comparable<StudentGrade> {
    private String firstName;
    private String lastName;
    private int grade;

    //Default empty constructor
    public StudentGrade() {
        // No initialization performed here
    }

    // Parameterized Constructor
    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // Getter for last name
    public String getFirstName() {
        return firstName;
    }

    // Setter for last name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for grade
    public int getGrade() {
        return grade;
    }

    // Setter for grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Overriding the compareTo method from Comparable interface
    // Purpose: Compare two StudentGrade objects based on their grade
    @Override
    public int compareTo(StudentGrade o) {
        return Integer.compare(this.grade, o.grade);
    }

    // Overriding the toString method for custom output
    // Purpose: Return a formatted string representation of the student's data
    @Override
    public String toString() {
        return firstName + " " + lastName + " : " + grade;
    }
}
