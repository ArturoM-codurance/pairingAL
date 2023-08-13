package org.shoppingcart;

public class ShoppingCartService implements ShoppingCart {
    private final CartPrinter cartPrinter;

    public ShoppingCartService(CartPrinter cartPrinter) {
        this.cartPrinter = cartPrinter;
    }

    @Override
    public void addItem(String productName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deletItem(String productName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void applyDiscount(Double discount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printShoppingCart() {
        cartPrinter.print("--------------------------------------------\n" +
                          "| Product name | Price with VAT | Quantity |\n" +
                          "| -----------  | -------------- | -------- |\n" +
                          "|------------------------------------------|\n" +
                          "| Promotion:                               |\n" +
                          "--------------------------------------------\n" +
                          "| Total products: 0                        |\n" +
                          "| Total price: 0.00 €                      |\n" +
                          "--------------------------------------------\n");
    }
}
