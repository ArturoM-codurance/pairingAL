package schoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBasketShould {

    @Test
    void store_received_products(){
        //Arrange
        Product productToStore = new Product("Corn");
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        //Act
        shoppingBasket.store(productToStore);
        //Arrange
        ArrayList<Product> expectedStoredProducts = new ArrayList<>(List.of(productToStore));
        ArrayList<Product> receivedProducts = shoppingBasket.getAllProducts();
        assertEquals(expectedStoredProducts, receivedProducts);
    }

}