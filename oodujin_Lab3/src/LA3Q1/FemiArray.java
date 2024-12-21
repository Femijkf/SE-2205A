package LA3Q1;

public class FemiArray {
    private Pair[] testArray;

    public FemiArray() {
        testArray = new Pair[0];
    }

    public int getSize() {
        return testArray.length;
    }

    //method that removes the last index element (pop)
    public Pair removeFromLastIndex() {
        if (testArray.length == 0) {
            return null;
        }
        Pair pair = testArray[testArray.length - 1];
        Pair[] newArray = new Pair[testArray.length - 1];
        System.arraycopy(testArray, 0, newArray, 0, testArray.length - 1);
        testArray = newArray;
        return pair;
    }

    //method that removes the first index element (dequeue)
    public Pair removeFromFirstIndex() {
        if (testArray.length == 0) {
            return null;
        }
        Pair pair = testArray[0];
        Pair[] newArray = new Pair[testArray.length - 1];
        System.arraycopy(testArray, 1, newArray, 0, newArray.length);
        testArray = newArray;
        return pair;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < testArray.length; i++) {
            result.append(testArray[i]);
            if (i < testArray.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    //method that adds a last index element
    public void addAtLastIndex(Pair pair) {
        Pair[] newArray = new Pair[testArray.length + 1];
        System.arraycopy(testArray, 0, newArray, 0, testArray.length);
        newArray[testArray.length] = pair;
        testArray = newArray;
    }
}
