package shoppingcart;

public class ShoppingCartService {
    private ProductCatalog productCatalog;
    private ShoppingBasket shoppingBasket;

    public ShoppingCartService(ProductCatalog productCatalog, ShoppingBasket shoppingBasket) {
        this.productCatalog = productCatalog;
        this.shoppingBasket = shoppingBasket;
    }

    public void addItem(String productName) {
        Product foundProduct = productCatalog.findByName(productName);
        shoppingBasket.store(foundProduct);
    }

    public String printShoppingCart() {
        throw new UnsupportedOperationException();
    }
}
