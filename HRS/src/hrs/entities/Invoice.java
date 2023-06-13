 package hrs.entities;

public class Invoice implements Payable {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    @Override
    public double getPaymentAmount() {
        double paymentAmount = 0;
        return paymentAmount;
    }
}
