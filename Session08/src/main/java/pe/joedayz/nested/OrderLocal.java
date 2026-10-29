package pe.joedayz.nested;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderLocal {

    private Map<Integer, OrderMember.Item> items = new HashMap<>();

    public void manageTax(final String saleLocation){  // parametros y variables locales deben ser final o efectivamente final

        int count = 0;

        class OrderTaxManager{
            private void findRate(Product product){
                // use saleLocation

            }

            private BigDecimal calculateTax(){
               // count = 5; da error
                return BigDecimal.ZERO;
            }
        }



        OrderTaxManager taxManager = new OrderTaxManager();
        BigDecimal taxTotal = taxManager.calculateTax();
    }
}
