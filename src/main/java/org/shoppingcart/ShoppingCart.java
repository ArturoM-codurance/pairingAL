package org.shoppingcart;

public interface ShoppingCart {
    void addItem(String productName);
    void deletItem(String productName);
    void applyDiscount(Double discount);
    void printShoppingCart();
}
