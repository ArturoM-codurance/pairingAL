package shoppingcart;


import java.util.ArrayList;

public class ShoppingBasket {
    private final ProductsList productsList;
    private Formatter formatter;

    public ShoppingBasket(Formatter formatter) {
        this.formatter = formatter;
        productsList = new ProductsList(new ArrayList<>());
    }

    public ShoppingBasket(ProductsList productsList, Formatter formatter) {
        this.productsList = productsList;
        this.formatter = formatter;
    }

    public void store(Product productToStore) {
//        products.add(productToStore);
        productsList.add(productToStore);
    }

    public String printBasket() {
        return formatter.assembleStatement(productsList);
    }

}
