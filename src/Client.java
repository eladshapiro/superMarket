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
    public String toString()
    {
        String toString=getFirstName()+" "+getLastName();
        return toString;
    }

    public boolean isShoppingCartEmpty()
    {
        if (shoppingCart.getProductsInCart().isEmpty())
            return true;
        return false;
    }

    public double getSumOfProductsByPrice()
    {
        int sum=0;
        if (vipMember==true)
        {
            for(int i = 0; i < shoppingCart.getProductsInCart().size(); i++)
            {
                sum+=shoppingCart.getProductsInCart().get(i).getPriceWithDiscount();
            }
        }
        else
        {
            for(int i = 0; i < shoppingCart.getProductsInCart().size(); i++)
            {
                sum+=shoppingCart.getProductsInCart().get(i).getPrice();
            }
        }
        return sum;
    }
}
