package shoppingcart;

import java.text.DecimalFormat;

public class Formatter {
    private final String STATEMENT_HEADER = "--------------------------------------------\n" +
                                            "| Product name | Price with VAT | Quantity |\n" +
                                            "| -----------  | -------------- | -------- |\n";
    private final String PROMOTION_APPLIED = "| Promotion:                               |\n";
    private final String TOTAL_SEPARATOR = "--------------------------------------------\n";
    private final String PRODUCTS_SEPARATOR = "|------------------------------------------|\n";
    private final String ZERO_PRODUCTS_AND_PRICE_ZERO = "| Total products: 0                        |\n" +
                                                        "| Total price: 0.00 €                      |\n";

    public String emptyStatement() {
        return STATEMENT_HEADER +
               PRODUCTS_SEPARATOR +
               PROMOTION_APPLIED +
               TOTAL_SEPARATOR +
               ZERO_PRODUCTS_AND_PRICE_ZERO +
               TOTAL_SEPARATOR;
    }

    public String productsStatement(ProductsList products) {
        String statement;

        statement = STATEMENT_HEADER +
                    products.allProductsString() +
                    PRODUCTS_SEPARATOR +
                    PROMOTION_APPLIED +
                    TOTAL_SEPARATOR +
                    "| Total products: " + products.totalAmount() + "                        |\n" +
                    "| Total price: " + formattedTotal(products.calculateTotalPrice()) + " €                      |\n" +
                    TOTAL_SEPARATOR;

        return statement;
    }

    private String formattedTotal(double totalPrice) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(totalPrice);
    }
}