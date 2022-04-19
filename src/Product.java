public class Product
{
    private String productName;
    private double price;
    private double discountForMember;
    private boolean inStock;

    public boolean getIsInStock() {
        return inStock;
    }

    public Product(String productName, double price, double discountForMember, boolean inStock)
    {
        this.productName = productName;
        this.price = price;
        this.discountForMember = discountForMember;
        this.inStock = inStock;
    }

    public void setInStock(boolean inStock)
    {
        this.inStock = inStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountForMember() {
        return discountForMember;
    }

    public void setDiscountForMember(double discountForMember) {
        this.discountForMember = discountForMember;
    }


    public double getPriceWithDiscount()
    {
        return price-(price*discountForMember);
    }

    public double GetPriceAfterDiscountForEmployee(User user)
    {
        if (user instanceof Employee)
        {
            if (((Employee) user).getRank()==whichRank.regularEmployee)
            {
                return price-(price*0.1);   //10 percent discount
            }
            if (((Employee) user).getRank()==whichRank.manager)
            {
                return price-(price*0.2);   //20 percent discount
            }
            if (((Employee) user).getRank()==whichRank.managementMember)
            {
                return price-(price*0.3);   //30 percent discount
            }
        }
            return 0;
    }
}
