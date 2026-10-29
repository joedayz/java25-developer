package com.acme;

import java.time.Period;

public class StaticSample {

    //variable de la clase
    private static Period defaultPeriod = Period.ofDays(30);
    private String name;


    static void main() {
        var s1 = new StaticSample();
        s1.name = "Cafe";

        var s2 = new StaticSample();
        s2.name = "Té";

        var s3 = new StaticSample();
        s3.name = "Chocolate";
        StaticSample.defaultPeriod = Period.ofDays(15);

        s3.defaultPeriod = Period.ofDays(15);

        System.out.println("Default period is " + StaticSample.defaultPeriod);
    }
}
