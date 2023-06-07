package shoppingcart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Product lettuceProduct = new Product(productName, 0.73);
        when(productCatalog.findByName(productName)).thenReturn(lettuceProduct);
        //Act
        shoppingCartService.addItem(productName);
        //Assert
        verify(productCatalog,times(1)).findByName(productName);
        verify(shoppingBasket, times(1)).store(lettuceProduct);
    }

    @Test
    void print_shopping_basket(){
        //Arrange
        ShoppingBasket shoppingBasket = mock(ShoppingBasket.class);
        ProductCatalog productCatalog = mock(ProductCatalog.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(productCatalog, shoppingBasket);

        //Act
        shoppingCartService.printShoppingCart();
        //Assert
        verify(shoppingBasket, times(1)).printBasket();
    }


}