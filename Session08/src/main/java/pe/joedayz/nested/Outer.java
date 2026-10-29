package pe.joedayz.nested;

public class Outer {

    public static void createInstance(){
       new StaticNested();
    }

    private static class StaticNested {

        public void method() {

        }
    }


}


class Main {
    static void main() {

        Outer.createInstance();

    }
}

