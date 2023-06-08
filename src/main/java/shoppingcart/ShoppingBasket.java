package shoppingcart;


import java.util.ArrayList;

public class ShoppingBasket {
    private final ArrayList<Product> products;
    private final ProductsList productsList;
    private Formatter formatter;

    public ShoppingBasket(Formatter formatter) {
        this.formatter = formatter;
        products = new ArrayList<>();
        productsList = new ProductsList(new ArrayList<>());
    }

    public ShoppingBasket(ArrayList<Product> products, Formatter formatter) {
        this.products = products;
        this.formatter = formatter;
        productsList = new ProductsList(new ArrayList<>());
    }

    public ShoppingBasket(ProductsList productsList, Formatter formatter) {
        this.productsList = productsList;
        products = new ArrayList<>();
        this.formatter = formatter;
    }

    public void store(Product productToStore) {
//        products.add(productToStore);
        productsList.add(productToStore);
    }

    public String printBasket() {
        String statement = formatter.emptyStatement();

        if (!productsList.isEmpty()) {
            statement = formatter.productsStatement(productsList);
        }

        return statement;
    }

}
