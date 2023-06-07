package acceptance;

import org.junit.jupiter.api.Test;
import shoppingcart.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartServiceShould {

    @Test
    void add_one_product_that_exists_and_print_the_cart(){
        //Given
        Product tomatoe = new Product("Tomatoe", 0.73);
        List<Product> catalog = new ArrayList<>(List.of(tomatoe));
        ProductCatalog productCatalog = new ProductCatalog(catalog);
        Formatter formatter = new Formatter();
        ShoppingBasket shoppingBasket = new ShoppingBasket(formatter);
        ShoppingCartService shoppingCartService = new ShoppingCartService(productCatalog, shoppingBasket);

        //When
        shoppingCartService.addItem("Tomatoe");

        //Then
        String expectedPrintedShoppingCart = """
                --------------------------------------------
                | Product name | Price with VAT | Quantity |
                | -----------  | -------------- | -------- |
                | Tomatoe      | 0,73 €         | 1        |
                |------------------------------------------|
                | Promotion:                               |
                --------------------------------------------
                | Total products: 1                        |
                | Total price: 0,73 €                      |
                --------------------------------------------
                """;
        assertEquals(expectedPrintedShoppingCart, shoppingCartService.printShoppingCart());
    }

    @Test
    void add_two_products_that_exist_and_print_the_cart(){
        //Given
        Product Corn = new Product("Corn", 1.50);
        Product Bread = new Product("Bread", 0.88);
        List<Product> catalog = new ArrayList<>(List.of(Corn, Bread));
        ProductCatalog productCatalog = new ProductCatalog(catalog);
        Formatter formatter = new Formatter();
        ShoppingBasket shoppingBasket = new ShoppingBasket(formatter);
        ShoppingCartService shoppingCartService = new ShoppingCartService(productCatalog, shoppingBasket);

        //When
        shoppingCartService.addItem("Corn");
        shoppingCartService.addItem("Bread");

        //Then
        String receivedPrintedShoppingCart = shoppingCartService.printShoppingCart();
        String expectedPrintedShoppingCart = """
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
        assertEquals(expectedPrintedShoppingCart,receivedPrintedShoppingCart);
    }

}
