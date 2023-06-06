package schoppingcart;

import org.junit.jupiter.api.Test;
import shoppingcart.Product;
import shoppingcart.ProductCatalog;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductCatalogShould {

    @Test
    void return_a_received_product_exists_in_the_catalog(){
        //Arrange
        Product expectedProduct = new Product("Corn");
        ArrayList<Product> catalog = new ArrayList<>(List.of(expectedProduct));
        ProductCatalog productCatalog = new ProductCatalog(catalog);
        //Act
        Product receivedProduct = productCatalog.findByName("Corn");
        //Assert
        assertEquals(expectedProduct, receivedProduct);
    }

}