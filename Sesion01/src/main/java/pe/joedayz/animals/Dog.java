package pe.joedayz.animals;


import pe.joedayz.Ball;

public class Dog {
    public String name;

    public void fetch(Ball ball) {
        while(ball==null){
            keepLooking();
        }
    }

    private void keepLooking() {
    }

    void makeNoise(Ball ball){
        if(ball!=null){
            dropBall();
        } else{
           bark();
        }
    }

    private void bark() {
    }

    private void dropBall() {
    }
}
