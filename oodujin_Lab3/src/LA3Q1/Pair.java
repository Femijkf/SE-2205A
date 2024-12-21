package LA3Q1;

public class Pair<Y, N> {
    private Y key;
    private N value;

    public Pair(Y key, N value) { // Pair constructor
        this.key = key;
        this.value = value;
    }

    public Pair(){ // this is an empty constructor
    }

    public void setKey(Y key) { //setter method for key
        this.key = key;
    }

    public void setValue(N value) { //setter method of value
        this.value = value;
    }

    public Y getKey() { //getter method for key
        return key;
    }

    public N getValue() { //getter method for value
        return value;
    }

    @Override
    public String toString() {
        return "[YR: " + key + ", NM: " + value + "]";
    }
}
