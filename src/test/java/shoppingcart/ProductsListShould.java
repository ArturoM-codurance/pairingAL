package shoppingcart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsListShould {
    @Test
    void store_received_products() {
        //Arrange
        Product productToStore = new Product("Corn", 0.73);
        ArrayList<Product> storedProducts = new ArrayList<>(List.of());
        ProductsList productsList = new ProductsList(storedProducts);

        //Act
        productsList.add(productToStore);
        //Arrange
        assertTrue(storedProducts.contains(productToStore));
    }

    @Test
    void return_all_products() {
        //Arrange
        Product productToStore = new Product("Corn", 0.73);
        ArrayList<Product> storedProducts = new ArrayList<>(List.of(productToStore));
        ProductsList productsList = new ProductsList(storedProducts);

        //Act
        ArrayList<Product> receivedProducts = productsList.allProducts();
        //Arrange
        assertEquals(storedProducts, receivedProducts);
    }
    @Test
    void return_a_product_stringified_with_quantity_two() {
        //Arrange
        Product corn1 = new Product("Corn", 0.73);
        Product corn2 = new Product("Corn", 0.73);
        ArrayList<Product> storedProducts = new ArrayList<>(List.of(corn1, corn2));
        ProductsList productsList = new ProductsList(storedProducts);

        //Act
        String receivedProduct = productsList.allProductsString();
        //Arrange
        String expectedString = "| Corn         | 0,73 €         | 2        |\n";
        assertEquals(expectedString, receivedProduct);
    }

    @Test
    void return_products_stringified_with_quantity_two() {
        //Arrange
        Product corn1 = new Product("Corn", 0.73);
        Product corn2 = new Product("Corn", 0.73);
        Product Bread = new Product("Bread", 0.88);
        Product tomatoe1 = new Product("Tomatoe", 0.73);
        Product tomatoe2 = new Product("Tomatoe", 0.73);
        ArrayList<Product> storedProducts = new ArrayList<>(List.of(corn1, corn2, Bread, tomatoe1, tomatoe2));
        ProductsList productsList = new ProductsList(storedProducts);

        //Act
        String receivedProduct = productsList.allProductsString();
        //Arrange
        String expectedString = "| Corn         | 0,73 €         | 2        |\n" +
                                "| Bread        | 0,88 €         | 1        |\n" +
                                "| Tomatoe      | 0,73 €         | 2        |\n";
        assertEquals(expectedString, receivedProduct);
    }


}