package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsListShould {
    @Test
    void store_received_products(){
        //Arrange
        Product productToStore = new Product("Corn", 0.73);
        ArrayList<Product> storedProducts = new ArrayList<>(List.of());
        ProductsList productsList = new ProductsList(storedProducts);

        //Act
        productsList.add(productToStore);
        //Arrange
        assertTrue(storedProducts.contains(productToStore));
    }

}