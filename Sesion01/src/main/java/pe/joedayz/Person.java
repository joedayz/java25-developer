package pe.joedayz;


import pe.joedayz.animals.Dog;

public class Person {

    void play(){
        Dog dog = new Dog();
        dog.name = "Rex";

        Ball ball = new Ball();
        dog.fetch(ball);
    }

}
