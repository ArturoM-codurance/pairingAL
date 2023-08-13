package org.shoppingcart.acceptance;

import org.junit.jupiter.api.Test;
import org.shoppingcart.CartPrinter;
import org.shoppingcart.ShoppingCartService;

import static org.mockito.Mockito.*;

class ShoppingCartAcceptance {
    @Test
    void ShouldPrintEmptyListWhenNoProductsHaveBeenAdded(){
        //Given
        CartPrinter cartPrinter = mock(CartPrinter.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(cartPrinter);

        //When
        shoppingCartService.printShoppingCart();

        //Then
        String expectedProductsList = "--------------------------------------------\n" +
                                      "| Product name | Price with VAT | Quantity |\n" +
                                      "| -----------  | -------------- | -------- |\n" +
                                      "|------------------------------------------|\n" +
                                      "| Promotion:                               |\n" +
                                      "--------------------------------------------\n" +
                                      "| Total products: 0                        |\n" +
                                      "| Total price: 0.00 €                      |\n" +
                                      "--------------------------------------------\n";
        verify(cartPrinter, times(1)).print(expectedProductsList);
    }

    @Test
    void ShouldPrintListWithTheProductThatHasBeenAdded(){
        //Given
        CartPrinter cartPrinter = mock(CartPrinter.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(cartPrinter);

        //When
        shoppingCartService.addItem("Iceberg");

        //Then
        shoppingCartService.printShoppingCart();

        String expectedProductList = "--------------------------------------------\n" +
                                     "| Product name | Price with VAT | Quantity |\n" +
                                     "| -----------  | -------------- | -------- |\n" +
                                     "| Iceberg      | 2.17 €         | 1        |\n" +
                                     "|------------------------------------------|\n" +
                                     "| Promotion:                               |\n" +
                                     "--------------------------------------------\n" +
                                     "| Total products: 1                        |\n" +
                                     "| Total price: 2.17 €                      |\n" +
                                     "--------------------------------------------\n";
        verify(cartPrinter,times(1)).print(expectedProductList);
    }
}
