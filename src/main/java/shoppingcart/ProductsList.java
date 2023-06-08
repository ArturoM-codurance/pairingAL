package shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductsList {
    private final ArrayList<Product> products;

    public ProductsList(ArrayList<Product> products) {

        this.products = products;
    }

    public void add(Product productToStore) {
        products.add(productToStore);
    }

    public ArrayList<Product> allProducts() {
        return products;
    }

    public String allProductsString() {
        StringBuilder productList = new StringBuilder();
        for (Product product : products) {
            productList.append(product.printProductStatementLine());
        }
        return String.valueOf(productList);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += Double.parseDouble(product.FormattedPrice().replaceAll(",", "."));
        }
        return totalPrice;
    }

    public int totalAmount() {
        return products.size();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
