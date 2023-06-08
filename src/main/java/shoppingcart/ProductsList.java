package shoppingcart;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

        Map<Product, Integer> map = mapProductAndUnits();

        for (Product productMapped : map.keySet()) {
            Integer productUnits = map.get(productMapped);
            productList.append(productMapped.printProductStatementLineWithNumberOfUnits(productUnits));
        }

        return String.valueOf(productList);
    }

    private Map<Product, Integer> mapProductAndUnits() {
        Map<Product, Integer> map = new LinkedHashMap<>();
        for (Product product : products) {
            if (map.containsKey(product)) {
                map.put(product, map.get(product) + 1);
            } else {
                map.put(product, 1);
            }
        }
        return map;
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
