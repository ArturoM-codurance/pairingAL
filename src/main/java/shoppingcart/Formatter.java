package shoppingcart;

import java.text.DecimalFormat;
import java.util.ArrayList;

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

    public String productsStatement(ArrayList<Product> products) {
        String statement;

        StringBuilder productList = new StringBuilder();
        int totalProducts = products.size();
        double totalPrice = 0;
        for (Product product : products) {
            productList.append(product.printProductStatementLine());
            totalPrice += Double.parseDouble(product.FormattedPrice().replaceAll(",", "."));
        }

        statement = STATEMENT_HEADER +
                    productList +
                    PRODUCTS_SEPARATOR +
                    PROMOTION_APPLIED +
                    TOTAL_SEPARATOR +
                    "| Total products: " + totalProducts + "                        |\n" +
                    "| Total price: " + formattedTotal(totalPrice) + " €                      |\n" +
                    TOTAL_SEPARATOR;

        return statement;
    }

    private String formattedTotal(double totalPrice) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(totalPrice);
    }
}