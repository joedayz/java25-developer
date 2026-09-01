package pe.joedayz.genericos;

public class Algo<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    static void main() {
        Algo<String> algo = new Algo<>();
        algo.setValue("Hola");
        System.out.println(algo.getValue());

        Algo<Integer> algoInt = new Algo<>();
        algoInt.setValue(100);
        System.out.println(algoInt.getValue());
    }
}
