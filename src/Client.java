public class Client extends User
{
private boolean vipMember;
private ShoppingCart shoppingCart;

    public Client(String firstName, String lastName, String userName, String password, boolean vipMember) {
        super(firstName, lastName, userName, password);
        this.vipMember = vipMember;
        this.shoppingCart = new ShoppingCart();
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
