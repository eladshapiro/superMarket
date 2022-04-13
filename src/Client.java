public class Client extends User
{
private boolean vipMember;
private ShoppingCart shoppingCart;

    public Client(String firstName, String lastName, String userName, String password, boolean vipMember) {
        super(firstName, lastName, userName, password);
        this.vipMember = vipMember;
        this.shoppingCart = new ShoppingCart();
    }

    public void addAProductToTheShoppingCart(Product product)
    {
        this.shoppingCart.add(product);
    }

    public void printSumShoppingCart()
    {
        double sum = 0;

            for (Product product : this.shoppingCart.getProductsInCart())
            {
                sum += vipMember ? product.getPriceWithDiscount() : product.getPrice();
            }
        System.out.println("The sum of the  cart is: "+sum);

    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public boolean isVipMember() {
        return vipMember;
    }

    public void setVipMember(boolean vipMember) {
        this.vipMember = vipMember;
    }
}
