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
        Formatter formatter = new Formatter();

        //Act
        String statementReceived = formatter.oneProductStatement(bread);

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
    }@Test
    void print_basket_with_another_product(){
        //Arrange
        Product corn = new Product("Corn", 1.50);
        Formatter formatter = new Formatter();

        //Act
        String statementReceived = formatter.oneProductStatement(corn);

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

}