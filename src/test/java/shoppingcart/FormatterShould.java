package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormatterShould {

    @Test
    void print_empty_basket(){
        //Arrange
        Formatter formatter = new Formatter();
        //Act
        String statementReceived = formatter.emptyStatement();
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
        Product bread = new Product("Bread", 0.88);
        ArrayList<Product> product = new ArrayList<>(List.of(bread));
        ProductsList productsList = new ProductsList(product);
        Formatter formatter = new Formatter();

        //Act
        String statementReceived = formatter.productsStatement(productsList);

        //Arrange
        String expectedStatement = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                | Bread        | 0,88 €         | 1        |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 1                        |
                | Total price: 0,88 €                      |
                --------------------------------------------
                """;
        assertEquals(expectedStatement, statementReceived);
    }
    @Test
    void print_basket_with_another_product(){
        //Arrange
        Product corn = new Product("Corn", 1.50);
        ArrayList<Product> product = new ArrayList<>(List.of(corn));
        ProductsList productsList = new ProductsList(product);
        Formatter formatter = new Formatter();

        //Act
        String statementReceived = formatter.productsStatement(productsList);

        //Arrange
        String expectedStatement = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                | Corn         | 1,50 €         | 1        |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 1                        |
                | Total price: 1,50 €                      |
                --------------------------------------------
                """;
        assertEquals(expectedStatement, statementReceived);
    }
    @Test
    void print_basket_with_two_products(){
        //Arrange
        Product corn = new Product("Corn", 1.50);
        Product bread = new Product("Bread", 0.88);
        ArrayList<Product> products = new ArrayList<>(List.of(corn, bread));
        ProductsList productsList = new ProductsList(products);
        Formatter formatter = new Formatter();

        //Act
        String statementReceived = formatter.productsStatement(productsList);

        //Arrange
        String expectedStatement = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                | Corn         | 1,50 €         | 1        |
                | Bread        | 0,88 €         | 1        |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 2                        |
                | Total price: 2,38 €                      |
                --------------------------------------------
                """;
        assertEquals(expectedStatement, statementReceived);
    }

}