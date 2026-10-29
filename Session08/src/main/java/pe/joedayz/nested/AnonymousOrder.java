package pe.joedayz.nested;

import java.math.BigDecimal;

public class AnonymousOrder {

    public BigDecimal getDiscount(){
        return BigDecimal.ZERO;
    }
}

// implementación en clase separada
class OnlineOrder extends AnonymousOrder{

    @Override
    public BigDecimal getDiscount() {
        return super.getDiscount();
    }
}

class AnonymousMain{

    static void main() {
        AnonymousOrder order = new AnonymousOrder(){
            @Override
            public BigDecimal getDiscount() {
                return BigDecimal.ONE;
            }
        };
    }
}