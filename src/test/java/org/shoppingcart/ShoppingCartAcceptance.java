package org.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ShoppingCartAcceptanceShould {
    @Test
    void add_products_to_my_shopping_cart_and_list_them(){
        //Given
        ShoppingCartPrinter shoppingCartPrinter = mock(ShoppingCartPrinter.class);
        RegularShoppingCart regularShoppingCart = new RegularShoppingCart();

        //When
        regularShoppingCart.addItem("Iceberg");
        regularShoppingCart.addItem("Chicken");
        regularShoppingCart.printShoppingCart();

        //Then
        String expectedProductsList = "--------------------------------------------\n" +
                                      "| Product name | Price with VAT | Quantity |\n" +
                                      "| -----------  | -------------- | -------- |\n" +
                                      "| Iceberg      | 2.17 €         | 1        |\n" +
                                      "| Chicken      | 1.83 €         | 1        |\n" +
                                      "|------------------------------------------|\n" +
                                      "| Promotion:                               |\n" +
                                      "--------------------------------------------\n" +
                                      "| Total products: 2                       |\n" +
                                      "| Total price: 4.00 €                      |\n" +
                                      "--------------------------------------------\n";
        verify(shoppingCartPrinter).printString(expectedProductsList);
        assertEquals(System.out.toString(), expectedProductsList);
    }
}