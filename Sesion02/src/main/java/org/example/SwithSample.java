package org.example;

public class SwithSample {

    public static void main(String[] args) {

        char status = 'Z';


        switch (status) {  // STATUS puede ser byte, int, short, char, String, enum, Object
            case 'A':
            case 'B':
                System.out.println("Status is A or B");
                break;
            case 'C':
                System.out.println("Status is C");
                break;
            default:
                System.out.println("Status is unknown");
        }


        switch (status) {  // STATUS puede ser byte, int, short, char, String, enum, Object
            case 'A', 'B' -> System.out.println("Status is A or B");
            case 'C' -> System.out.println("Status is C");
            default -> System.out.println("Status is unknown");
        }
        System.out.println("fin");


        double cost = 10.0;


        double price2 = switch (status) {

            case 'A', 'B' : yield cost;
            case 'C' : {
                double discount = cost * 0.10;
                cost -= discount;
                yield cost;
            }
            default : yield 0.0;
        };


        double price = switch (status) {

            case 'A', 'B' -> cost;

            case 'C' -> {
                double discount = cost * 0.10;
                cost -= discount;
                yield cost;
            }
            default -> 0.0;
        };
    }
}
