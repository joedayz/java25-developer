package com.acme;

//import static
import java.math.BigDecimal;
import java.time.LocalDate;

import static java.lang.Math.*;

public class StaticImportSample {

    static void main() {
        long n = round(1.99);

        long m = max(3, 5);

        var price = BigDecimal.valueOf(1.99);
        var today = LocalDate.now();
        System.out.println(n);
    }
}
