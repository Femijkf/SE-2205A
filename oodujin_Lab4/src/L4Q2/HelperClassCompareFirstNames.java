package L4Q2;

//importing Comparator library/packages
import java.util.Comparator;

//HelperClassCompareFirstNames implementing Comparator for Student class
public class HelperClassCompareFirstNames implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName()); //compare the first names of the two Student objects
    }
}
