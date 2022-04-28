import java.time.LocalDate;

public class Client extends User
{
private boolean vipMember;
private  int purchaseCounter;
private  double sumOfPurchase;
private LocalDate lastPurchaseDate;

    public Client(String firstName, String lastName, String userName, String password, boolean vipMember) {
        super(firstName, lastName, userName, password);
        this.vipMember = vipMember;
        this.purchaseCounter=0;
        this.lastPurchaseDate=null;
        this.sumOfPurchase=0;
    }

    public void printSumShoppingCart()
    {
        double sum = 0;

            for (Product product : this.getShoppingCart().getProductsInCart())
            {
                sum += vipMember ? product.getPriceWithDiscount() : product.getPrice();
            }
        System.out.println("\nThe sum of the  cart is: "+sum+"\n");
        purchaseCounter++;
        sumOfPurchase+=sum;
        lastPurchaseDate=LocalDate.now();
        this.getShoppingCart().emptyShoppingCart();

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
        String toString=this.getFirstName()+" "+this.getLastName()+"\nis a VIP member: "+this.vipMember+"\n"+"the number of purchases that the client made: "+this.purchaseCounter
        +"\nthe sum of purchases that the client made: "+this.sumOfPurchase+"\n last purchase date: "+this.lastPurchaseDate+"\n\n";
        return toString;
    }

}
