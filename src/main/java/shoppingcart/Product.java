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

    public boolean isNamed(String name){
        return productName.equals(name);
    }

    public String printProductStatementLine() {
        return String.format("| %-" + 13 + "s" + "| %-" + 14 + "s " + "| 1        |\n", this.productName, this.FormattedPrice()+" €");
    }

    protected String FormattedPrice(){
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(this.price);
    }

}
