package L4Q2;

//importing Comparable library/packages
import java.lang.Comparable;

public class Student implements Comparable<Student> {
    private Double score;
    private String firstName;
    private String lastName;

    //no argument Student constructor
    public Student() {
        this.firstName = "Femi";
        this.lastName = "Odujinrin";
        this.score = 99.99;
    }

    //Student constructor with arguments
    public Student(String fN, String lN, Double s) {
        firstName = fN;
        lastName = lN;
        score = s;
    }

    //getter method for score
    public Double getScore() {
        return score;
    }

    //getter method for firstName
    public String getFirstName() {
        return firstName;
    }

    //getter method for lastName
    public String getLastName() {
        return lastName;
    }

    //setter method for score
    public void setScore(Double s) {
        score = s;
    }

    //setter method for firstName
    public void setFirstName(String fN) {
        firstName = fN;
    }

    //setter method for lastName
    public void setLastName(String lN) {
        lastName = lN;
    }

    //produces a string representation of the contents of the list.
    @Override
    public String toString() {
        return String.format("\t%s %s: %.2f\n", firstName, lastName, score);
    }

    //compares students by score in descending order
    @Override
    public int compareTo(Student o) {
        return Double.compare(o.score, this.score);
    }

    //this method was found in lectures notes (Unit 4.2)
    @Override //we need to override Object's equals() method
    public boolean equals(Object obj) {
        return score.equals(((Student)obj).score);
    }
}
