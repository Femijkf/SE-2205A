package L4Q1;

public class MyStudent {
    private String firstName;
    private Double score;

    //constructor without any arguments
    public MyStudent() {
        this.firstName = "Femi";
        this.score = 99.99;
    }

    //constructor with arguments
    public MyStudent(String firstName, Double score) {
        this.firstName = firstName;
        this.score = score;
    }

    //Override toString() method
    @Override
    public String toString() {
        return String.format("%s: %.2f", firstName, score);
    }
}