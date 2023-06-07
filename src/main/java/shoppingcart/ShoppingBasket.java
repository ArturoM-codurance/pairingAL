package shoppingcart;


import java.util.ArrayList;

public class ShoppingBasket {
    private final ArrayList<Product> products;
    private  Formatter formatter;

    public ShoppingBasket( Formatter formatter) {
        this.formatter = formatter;
        products = new ArrayList<>();
    }

    public ShoppingBasket(ArrayList<Product> products, Formatter formatter) {
        this.products = products;
        this.formatter = formatter;
    }

    public void store(Product productToStore) {
        products.add(productToStore);
    }

    public String printBasket() {
        String statement = formatter.emptyStatement();

        if (!products.isEmpty()) {
            Product product = products.get(0);
            statement = formatter.oneProductStatement(product);
        }
        return statement;
    }

}
