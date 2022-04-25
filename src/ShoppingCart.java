import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart
{
    private ArrayList<Product> productsInCart;


    public ShoppingCart()
    {
        this.productsInCart = new ArrayList<>() ;
    }
    public void add(Product product) {
        this.productsInCart.add(product);
    }



    public ArrayList<Product> getProductsInCart() {
        return productsInCart;
    }




}
