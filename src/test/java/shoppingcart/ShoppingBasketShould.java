package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShoppingBasketShould {

    @Test
    void store_received_products(){
        //Arrange
        Product productToStore = new Product("Corn", 0.73);
        ArrayList<Product> storedProducts = new ArrayList<>(List.of());
        Formatter formatter = new Formatter();
        ShoppingBasket shoppingBasket = new ShoppingBasket(storedProducts, formatter);

        //Act
        shoppingBasket.store(productToStore);
        //Arrange
        assertTrue(storedProducts.contains(productToStore));
    }
    
    @Test
    void print_empty_basket(){
        //Arrange
        ArrayList<Product> products = new ArrayList<>();
        Formatter formatter = mock(Formatter.class);
        ShoppingBasket shoppingBasket = new ShoppingBasket(products, formatter);

        //Act
        shoppingBasket.printBasket();

        //Arrange
        verify(formatter, times(1)).emptyStatement();
    }

    @Test
    void print_basket_with_one_product(){
        //Arrange
        Product bread = new Product("Bread", 0.88);
        ArrayList<Product> products = new ArrayList<>(List.of(bread));
        Formatter formatter = mock(Formatter.class);
        ShoppingBasket shoppingBasket = new ShoppingBasket(products, formatter);

        //Act
        shoppingBasket.printBasket();

        //Arrange
        verify(formatter, times(1)).oneProductStatement(bread);
    }

}