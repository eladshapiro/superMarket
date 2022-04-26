public class Client extends User
{
private boolean vipMember;

    public Client(String firstName, String lastName, String userName, String password, boolean vipMember) {
        super(firstName, lastName, userName, password);
        this.vipMember = vipMember;

    }

    public void printSumShoppingCart()
    {
        double sum = 0;

            for (Product product : this.getShoppingCart().getProductsInCart())
            {
                sum += vipMember ? product.getPriceWithDiscount() : product.getPrice();
            }
        System.out.println("\nThe sum of the  cart is: "+sum+"\n");

    }

    public double getSumShoppingCart()
    {
        double sum = 0;

        for (Product product : this.getShoppingCart().getProductsInCart())
        {
            sum += vipMember ? product.getPriceWithDiscount() : product.getPrice();
        }
        return sum;

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

}
