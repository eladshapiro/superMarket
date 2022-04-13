public class Product
{
    private String productName;
    private double price;
    private double discountForMember;
    private int amount;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceWithDiscount()
    {
        return price-(price*discountForMember);
    }
}
