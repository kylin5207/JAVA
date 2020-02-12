package GenericTest;

public class GenericDemo<E> {
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericDemo{" +
                "value=" + value +
                '}';
    }
}
