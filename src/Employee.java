public class Employee extends User
{
private whichRank rank;
private ShoppingCart shoppingCart;

    public Employee(String firstName, String lastName, String userName, String password, whichRank rank) {
        super(firstName, lastName, userName, password);
        this.rank = rank;
    }

    public whichRank getRank() {
        return rank;
    }

    public void setRank(whichRank rank) {
        this.rank = rank;
    }

    public void addAProductToTheShoppingCart(Product product)
    {
        this.shoppingCart.add(product);
    }
}
