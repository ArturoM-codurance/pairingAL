package schoppingcart;

import org.junit.jupiter.api.Test;
import shoppingcart.Product;
import shoppingcart.ProductCatalog;
import shoppingcart.ShoppingBasket;
import shoppingcart.ShoppingCartService;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class ShoppingCartServiceShould {

    @Test
    void add_a_product_that_exists(){
        //Arrange
        ProductCatalog productCatalog = mock(ProductCatalog.class);
        ShoppingBasket shoppingBasket = mock(ShoppingBasket.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(productCatalog, shoppingBasket);

        String productName = "Lettuce";
        Product lettuceProduct = new Product(productName);
        when(productCatalog.findByName(productName)).thenReturn(lettuceProduct);
        //Act
        shoppingCartService.addItem(productName);
        //Assert
        verify(productCatalog,times(1)).findByName(productName);
        verify(shoppingBasket, times(1)).store(lettuceProduct);
    }


}