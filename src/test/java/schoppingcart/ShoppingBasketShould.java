package schoppingcart;

import org.junit.jupiter.api.Test;
import shoppingcart.Product;
import shoppingcart.ShoppingBasket;

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

}