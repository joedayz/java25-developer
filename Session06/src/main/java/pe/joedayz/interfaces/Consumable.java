package pe.joedayz.interfaces;

public interface Consumable {

    double PI = 3.14159; //public static final

    int measure();

    void consume(int quantity);


}

interface Vendible{
    void sell();


}


interface Liquid {

    public default void prepare() {
        // pour to a cup
    }

    int measure();
}



class Food implements Consumable, Vendible{


    @Override
    public int measure() {
        return 0;
    }

    @Override
    public void consume(int quantity) {

    }


    @Override
    public void sell() {

    }
}
class Drink implements Consumable, Vendible, Liquid{

    @Override
    public int measure() {
        return 0;
    }

    @Override
    public void consume(int quantity) {

    }

    @Override
    public void sell() {

    }

    // en primer intancia los metodos defaults no estamos obligados a sobreescribir
    // a no ser que el metodo default este repetido en otra interfae.

}


class Main{
    void main(){
        Food food = new Food();
        Drink drink = new Drink();

        //Polimorfismo
        //Clase padre = Clase hija
        // Object = clase hija


        // Interface = clase que la implementa
        Consumable c = new Food();
        c.consume(0);

        Vendible v = new Food();
        v.sell();

        Consumable d = new Drink();
        d.consume(0);

        Vendible v2 = new Drink();
        v2.sell();

        //Consumable mal = new Pato();  Interface = cualquier clase que no la implemente - no compila
    }
}