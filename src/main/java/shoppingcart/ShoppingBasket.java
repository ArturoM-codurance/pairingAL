package shoppingcart;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingBasket {
    private static final String STATEMENT_HEADER = "--------------------------------------------\n" +
                                                   "| Product name | Price with VAT | Quantity |\n" +
                                                   "| -----------  | -------------- | -------- |\n";
    private static final String PROMOTION_APPLIED = "| Promotion:                               |\n";
    private static final String TOTAL_SEPARATOR = "--------------------------------------------\n";
    private static final String PRODUCTS_SEPARATOR = "|------------------------------------------|\n";
    private static final String ZERO_PRODUCTS_AND_PRICE_ZERO = "| Total products: 0                        |\n" +
                                                               "| Total price: 0.00 €                      |\n";
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
        String statement = emptyStatement();

        if (!products.isEmpty()) {
            Product product = products.get(0);
            statement = oneProductStatement(product);
        }
        return statement;
    }

    private static String oneProductStatement(Product product) {
        String statement;
        String productName = product.getName();
        double price = product.getPrice();
        DecimalFormat formatter = new DecimalFormat("#0.00");
        String formattedPrice = formatter.format(price);

        statement = STATEMENT_HEADER +
                    String.format("| %-" + 13 + "s" + "| %-" + 14 + "s " + "| 1        |\n", productName, formattedPrice + " €") +
                    PRODUCTS_SEPARATOR +
                    PROMOTION_APPLIED +
                    TOTAL_SEPARATOR +
                    "| Total products: 1                        |\n" +
                    "| Total price: " + formattedPrice + " €                      |\n" +
                    TOTAL_SEPARATOR;
        return statement;
    }

    private static String emptyStatement() {
        return STATEMENT_HEADER +
               PRODUCTS_SEPARATOR +
               PROMOTION_APPLIED +
               TOTAL_SEPARATOR +
               ZERO_PRODUCTS_AND_PRICE_ZERO +
               TOTAL_SEPARATOR;
    }
}
