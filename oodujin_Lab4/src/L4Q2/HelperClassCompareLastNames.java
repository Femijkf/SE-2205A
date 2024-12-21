package L4Q2;

//importing Comparator library/packages
import java.util.Comparator;

//HelperClassCompareLastNames implementing Comparator for Student class
public class HelperClassCompareLastNames implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getLastName().compareTo(s2.getLastName()); //compare the last names of the two Student objects
    }
}
