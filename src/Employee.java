public class Employee extends User
{
private whichRank rank;


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

    public void printSumShoppingCart()
    {
        double sum = 0;

        for (Product product : this.getShoppingCart().getProductsInCart())
        {
            sum+= product.getPrice();
        }

        if (rank.name().equals("regularEmployee"))
        {
            sum*=0.9;
        }
        else if (rank.name().equals("manager"))
        {
            sum*=0.8;
        }
        else if (rank.name().equals("managementMember"))
        {
            sum*=0.7;
        }

        System.out.println("The sum of the  cart is: "+sum);

    }
}
