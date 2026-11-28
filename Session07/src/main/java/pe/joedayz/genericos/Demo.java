package pe.joedayz.genericos;

import pe.joedayz.collections.Food;
import pe.joedayz.collections.Product;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Object cruda = "Café";
        String texto = (String) cruda;
        IO.println(texto);
        try {
            Object numero = 5;
            String mal = (String) numero;
            IO.println(mal);
        } catch (ClassCastException e) {
            IO.println(e.getClass().getSimpleName());
        }
        //----------------

        var caja = new Caja<String>();
        caja.setValor("Café");
        String valor = caja.getValor();
        IO.println(valor);

        Caja<String> otra = new Caja<>();
        otra.setValor("Chocolate");
        IO.println(otra.getValor());

        IO.println(primero(List.of("Café", "Chocolate", "Té")));
        IO.print(primero(List.of(1, 2, 3, 4, 5)));

        Caja c1 = new Caja(); // usa tipo crudo
        var c2 = new Caja<>(); // va a inferir caja object
        var c3 = new Caja(); // va a inferir caja en crudo
        Caja c4 = new Caja<>();

    }
    static <T> T primero(List<T> lista) {
        return lista.get(0);
    }

    //Object o = new Caja<String>();
    //boolean b  = o instanceof Caja<String>; // true


}



class Caja<T> {
    private T valor;

    public void setValor(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
}
