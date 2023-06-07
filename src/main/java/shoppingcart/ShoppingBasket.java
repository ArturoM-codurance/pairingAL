package shoppingcart;


import java.util.ArrayList;

public class ShoppingBasket {
    private final ArrayList<Product> products;

    public ShoppingBasket() {
        products = new ArrayList<>();
    }

    public ShoppingBasket(ArrayList<Product> products) {
        this.products = products;
    }

    public void store(Product productToStore) {
        products.add(productToStore);
    }

    public String printBasket() {
        throw new UnsupportedOperationException();
    }
}
