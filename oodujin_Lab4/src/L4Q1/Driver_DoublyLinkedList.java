package L4Q1;

public class Driver_DoublyLinkedList {

    public static void myHeader(int labE_number, int q_number) { // the header method
        final String YourFirstName, YourLastName, GoalOfExercise; // hardcoded String variables
        final int YourStudentNumber = 251368776; // hardcoded int variable
        String SeparationBars = "=======================================================";
        YourFirstName = "Femi";
        YourLastName = "Odujinrin";
        GoalOfExercise = "Work with Doubly Linked List!";

        System.out.printf("%s\nLab Exercise %d-Q%d\nPrepared By: %s %s\nStudent Number: %d\nGoal of this Exercise: %s\n%s\n",
                SeparationBars, labE_number, q_number, YourFirstName, YourLastName, YourStudentNumber, GoalOfExercise, SeparationBars);
    }

    public static void myFooter(int labE_number, int q_number) { // the footer method
        final String YourFirstName = "Femi"; // hardcoded String variable
        String SeparationBars = "=======================================================";
        System.out.printf("%s\nCompletion of Lab Exercise %d-Q%d is successful!\nSigning off - %s\n%s",
                SeparationBars, labE_number, q_number, YourFirstName, SeparationBars);
    }

    public static void main(String[] args) {
        myHeader(4,1);

        DoublyLinkedList<MyStudent> list = new DoublyLinkedList<>();

        //creation of five reference variables
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        //adding the first four students to the linked list
        list.addLast(s0);
        list.addLast(s1);
        list.addLast(s2);
        list.addLast(s3);

        System.out.println("Adding 4 students to the list.\nThe list Content:\n" + list);

        //using findNode to find info for s2 and then s3
        DoublyLinkedList.Node<MyStudent> node = list.findNode(s2);
        if (node != null) {
            list.addBetween(s4, node, node.getNext());
        }

        System.out.println("Adding Hermione to the list in between Luna and Vincent.....\n" +
                "The list Content:\n" + list);

        myFooter(4,1);
    }
}