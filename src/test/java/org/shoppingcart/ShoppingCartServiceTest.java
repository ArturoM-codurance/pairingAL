package org.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ShoppingCartServiceTest {

    @Test
    void Should_print_empty_basket_when_no_products_have_been_added(){
        //Arrange
        CartPrinter cartPrinter = mock(CartPrinter.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(cartPrinter);
        //Act
        shoppingCartService.printShoppingCart();
        //Assert
        String emptyList = "--------------------------------------------\n" +
                           "| Product name | Price with VAT | Quantity |\n" +
                           "| -----------  | -------------- | -------- |\n" +
                           "|------------------------------------------|\n" +
                           "| Promotion:                               |\n" +
                           "--------------------------------------------\n" +
                           "| Total products: 0                        |\n" +
                           "| Total price: 0.00 €                      |\n" +
                           "--------------------------------------------\n";
        verify(cartPrinter, times(1)).print(emptyList);
    }

    @Test
    void Should_call_shopping_basket_to_add_a_new_item(){
        //Arrange
        CartPrinter cartPrinter = mock(CartPrinter.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(cartPrinter);

        //act
        String itemToAdd = "Bread";
        shoppingCartService.addItem(itemToAdd);

        //assert
        ShoppingBasket shoppingbasket = new ShoppingBasket();
        verify(shoppingbasket, times(1)).addItem(itemToAdd);
    }

}