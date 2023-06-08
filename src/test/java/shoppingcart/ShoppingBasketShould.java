package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ShoppingBasketShould {

    @Test
    void store_received_products() {
        //Arrange
        Product productToStore = new Product("Corn", 0.73);
        Formatter formatter = mock(Formatter.class);
        ProductsList productsList = mock(ProductsList.class);
        ShoppingBasket shoppingBasket = new ShoppingBasket(productsList, formatter);

        //Act
        shoppingBasket.store(productToStore);

        //Assert
        verify(productsList, times(1)).add(productToStore);
    }

    @Test
    void print_empty_basket() {
        //Arrange
        Formatter formatter = mock(Formatter.class);
        ProductsList emptyProductsList = mock(ProductsList.class);
        ShoppingBasket shoppingBasket = new ShoppingBasket(emptyProductsList, formatter);

        //Act
        shoppingBasket.printBasket();

        //Assert
        verify(formatter, times(1)).assembleStatement(emptyProductsList);
    }

    @Test
    void print_basket_with_one_product() {
        //Arrange
        Product bread = new Product("Bread", 0.88);
        ArrayList<Product> products = new ArrayList<>(List.of(bread));
        ProductsList productsList = new ProductsList(products);
        Formatter formatter = mock(Formatter.class);
        ShoppingBasket shoppingBasket = new ShoppingBasket(productsList, formatter);

        //Act
        shoppingBasket.printBasket();

        //Assert
        verify(formatter, times(1)).assembleStatement(productsList);
    }

    @Test
    void print_basket_with_two_products() {
        //Arrange
        Product lettuce = new Product("lettuce", 0.73);
        Product bread = new Product("Bread", 0.88);
        ArrayList<Product> products = new ArrayList<>(List.of(lettuce, bread));
        ProductsList productsList = new ProductsList(products);
        Formatter formatter = mock(Formatter.class);
        ShoppingBasket shoppingBasket = new ShoppingBasket(productsList, formatter);

        //Act
        shoppingBasket.printBasket();

        //Assert
        verify(formatter, times(1)).assembleStatement(productsList);
    }

}