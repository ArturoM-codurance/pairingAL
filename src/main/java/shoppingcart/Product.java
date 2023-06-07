package shoppingcart;

public class Product {
    private final String productName;

    private final double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public boolean isNamed(String name){
        return productName.equals(name);
    }

    public String getName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

}
