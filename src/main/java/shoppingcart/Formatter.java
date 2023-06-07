package shoppingcart;

public class Formatter {
    private final String STATEMENT_HEADER = "--------------------------------------------\n" +
                                                   "| Product name | Price with VAT | Quantity |\n" +
                                                   "| -----------  | -------------- | -------- |\n";
    private final String PROMOTION_APPLIED = "| Promotion:                               |\n";
    private final String TOTAL_SEPARATOR = "--------------------------------------------\n";
    private final String PRODUCTS_SEPARATOR = "|------------------------------------------|\n";
    private final String ZERO_PRODUCTS_AND_PRICE_ZERO = "| Total products: 0                        |\n" +
                                                               "| Total price: 0.00 €                      |\n";

    public String oneProductStatement(Product product) {
        String statement;

        statement = STATEMENT_HEADER +
                    product.printProductStatementLine() +
                    PRODUCTS_SEPARATOR +
                    PROMOTION_APPLIED +
                    TOTAL_SEPARATOR +
                    "| Total products: 1                        |\n" +
                    "| Total price: " + product.FormattedPrice() + "                      |\n" +
                    TOTAL_SEPARATOR;
        return statement;
    }

    public String emptyStatement() {
        return STATEMENT_HEADER +
               PRODUCTS_SEPARATOR +
               PROMOTION_APPLIED +
               TOTAL_SEPARATOR +
               ZERO_PRODUCTS_AND_PRICE_ZERO +
               TOTAL_SEPARATOR;
    }
}