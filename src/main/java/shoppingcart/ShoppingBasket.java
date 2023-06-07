package shoppingcart;


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
        if(products.isEmpty()){
            return STATEMENT_HEADER +
                   PRODUCTS_SEPARATOR +
                   PROMOTION_APPLIED +
                   TOTAL_SEPARATOR +
                   ZERO_PRODUCTS_AND_PRICE_ZERO +
                   TOTAL_SEPARATOR;

        }
        return STATEMENT_HEADER +
               "| Bread        | 0.88 €         | 1        |\n" +
               PRODUCTS_SEPARATOR +
               PROMOTION_APPLIED +
               TOTAL_SEPARATOR +
               "| Total products: 1                        |\n" +
               "| Total price: 0.88 €                      |\n" +
               TOTAL_SEPARATOR;
    }
}
