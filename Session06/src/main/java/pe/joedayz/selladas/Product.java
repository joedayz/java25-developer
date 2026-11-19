package pe.joedayz.selladas;

public abstract sealed class Product permits Food, Drink, Other{
}

final class Drink extends Product{

}

non-sealed class  Food extends Product{

}

final class Other extends Product{

}
