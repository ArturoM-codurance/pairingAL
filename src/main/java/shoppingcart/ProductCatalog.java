package shoppingcart;

import java.util.List;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog(List<Product> products) {
        this.products = products;
    }

    public Product findByName(String productName) {
        Product productFound = null;
        for (Product product : products) {
            if (product.isNamed(productName)) {
                productFound = product;
            }
        }
        return productFound;
    }
}
