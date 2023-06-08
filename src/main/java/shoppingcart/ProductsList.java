package shoppingcart;

import java.util.ArrayList;

public class ProductsList {
    private final ArrayList<Product> products;

    public ProductsList(ArrayList<Product> products) {

        this.products = products;
    }

    public void add(Product productToStore) {
        products.add(productToStore);
    }
}
