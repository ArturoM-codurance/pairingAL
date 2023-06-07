package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBasketShould {

    @Test
    void store_received_products(){
        //Arrange
        Product productToStore = new Product("Corn", 0.73);
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

    @Test
    void print_basket_with_one_product(){
        //Arrange
        Product tomatoe = new Product("Bread", 0.88);
        ArrayList<Product> products = new ArrayList<>(List.of(tomatoe));
        ShoppingBasket shoppingBasket = new ShoppingBasket(products);

        //Act
        String actualStatement = shoppingBasket.printBasket();

        //Arrange
        String expectedStatement = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                | Bread        | 0.88 €         | 1        |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 1                        |
                | Total price: 0.88 €                      |
                --------------------------------------------
                """;
        assertEquals(expectedStatement, actualStatement);
    }@Test
    void print_basket_with_another_product(){
        //Arrange
        Product tomatoe = new Product("Tomatoe", 0.73);
        ArrayList<Product> products = new ArrayList<>(List.of(tomatoe));
        ShoppingBasket shoppingBasket = new ShoppingBasket(products);

        //Act
        String actualStatement = shoppingBasket.printBasket();

        //Arrange
        String expectedStatement = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                | Corn         | 1.50 €         | 1        |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 1                        |
                | Total price: 1.50 €                      |
                --------------------------------------------
                """;
        assertEquals(expectedStatement, actualStatement);
    }

}