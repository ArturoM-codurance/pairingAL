package shoppingcart;

import java.text.DecimalFormat;

public class Formatter {
    private final String STATEMENT_HEADER = "--------------------------------------------\n" +
                                            "| Product name | Price with VAT | Quantity |\n" +
                                            "| -----------  | -------------- | -------- |\n";
    private final String PROMOTION_APPLIED = "| Promotion:                               |\n";
    private final String TOTAL_SEPARATOR = "--------------------------------------------\n";
    private final String PRODUCTS_SEPARATOR = "|------------------------------------------|\n";

    public String assembleStatement(ProductsList products) {
        String statement;

        statement = STATEMENT_HEADER +
                    (products.isEmpty() ? "" : products.allProductsString()) +
                    PRODUCTS_SEPARATOR +
                    PROMOTION_APPLIED +
                    TOTAL_SEPARATOR +
                    "| Total products: " + (products.isEmpty() ? 0 : products.totalAmount()) + "                        |\n" +
                    "| Total price: " + formattedTotal((products.isEmpty() ? 0 : products.calculateTotalPrice())) + " €                      |\n" +
                    TOTAL_SEPARATOR;

        return statement;
    }

    private String formattedTotal(double totalPrice) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(totalPrice);
    }
}