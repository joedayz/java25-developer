package pe.joedayz.genericos;

import pe.joedayz.abstractos.Food;
import pe.joedayz.abstractos.Product;

import java.util.ArrayList;
import java.util.List;

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

        var algoInt = new Algo<>(); // new Algo<Object>()
        algoInt.setValue(5); // Integer.valueOf(5)
        System.out.println(algoInt.getValue());

        //new Algo<int>();
//        List<Food> comidas = new ArrayList<>();
//        List<Product> productos =  comidas;

        //Object o = new Algo<String>();
        //boolean b = o instanceof Algo<String>; // true

        //var algo2 = new Algo<String>();
        //algo2.setValue(5);


        // OPCIÓN 1: Raw Type + Diamond
        Algo a = new Algo<>();
        System.out.println("Opción 1: " + a);

        // OPCIÓN 2: var + Raw Type
        var b = new Algo();
        System.out.println("Opción 2: " + b);

        // OPCIÓN 3: var + Diamond
        var c = new Algo<>();
        c.setValue("Hola Java");
        System.out.println("Opción 3: " + c.getValue());

        // OPCIÓN 4: Raw Type en ambos lados
        Algo d = new Algo();
        System.out.println("Opción 4: " + d);
    }
}
