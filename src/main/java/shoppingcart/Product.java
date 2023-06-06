package shoppingcart;

public class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public boolean isNamed(String name){
        return productName.equals(name);
    }

}
