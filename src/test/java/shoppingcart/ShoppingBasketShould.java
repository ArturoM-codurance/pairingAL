package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBasketShould {

    @Test
    void store_received_products(){
        //Arrange
        Product productToStore = new Product("Corn");
        ArrayList<Product> storedProducts = new ArrayList<>(List.of());
        ShoppingBasket shoppingBasket = new ShoppingBasket(storedProducts);

        //Act
        shoppingBasket.store(productToStore);
        //Arrange
        assertTrue(storedProducts.contains(productToStore));
    }
    
    @Test
    void print_empty_basket(){
        //Arrange
        ArrayList<Product> products = new ArrayList<>();
        ShoppingBasket shoppingBasket = new ShoppingBasket(products);
        //Act
        String statementReceived = shoppingBasket.printBasket();
        //Arrange
        String statementExpected = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 0                        |
                | Total price: 0.00 €                      |
                --------------------------------------------
                """;
        assertEquals(statementExpected, statementReceived);
    }

}