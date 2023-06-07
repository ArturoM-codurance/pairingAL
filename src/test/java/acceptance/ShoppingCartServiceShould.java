package acceptance;

import org.junit.jupiter.api.Test;
import shoppingcart.Product;
import shoppingcart.ProductCatalog;
import shoppingcart.ShoppingBasket;
import shoppingcart.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartServiceShould {

    @Test
    void add_one_product_that_exists_and_print_the_cart(){
        //Arrange
        Product tomatoe = new Product("Tomatoe", 0.73);
        List<Product> catalog = new ArrayList<>(List.of(tomatoe));
        ProductCatalog productCatalog = new ProductCatalog(catalog);
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        ShoppingCartService shoppingCartService = new ShoppingCartService(productCatalog, shoppingBasket);

        //Act
        shoppingCartService.addItem("Tomatoe");

        //Arrange
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

}
