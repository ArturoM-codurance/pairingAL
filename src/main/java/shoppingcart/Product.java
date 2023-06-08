package shoppingcart;

import java.text.DecimalFormat;
import java.util.Objects;

public class Product {
    private final String productName;
    private final double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public boolean isNamed(String name) {
        return productName.equals(name);
    }

    public String printProductStatementLine(int units) {
        return String.format("| %-" + 13 + "s" + "| %-" + 14 + "s " + "| " + units + "        |\n", this.productName, this.FormattedPrice() + " €");
    }

    protected String FormattedPrice() {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}
