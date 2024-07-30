package model;

public class Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private  double amount;

    public Payment(String cardHolderName, String cardNumber, String expiryDate, String cvv, double amount) {
        if (isNotValidCardNumber(cardNumber)){
            throw new IllegalArgumentException("Invalid card number");
        }
        if (isNotValidExpiryDate(expiryDate)){
            throw new IllegalArgumentException("Invalid expiry date");
        }
        if (isNotValidCvv(cvv)){
            throw new IllegalArgumentException("Invalid cvv");
        }
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.amount = amount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (isNotValidCardNumber(cardNumber)){
            throw new IllegalArgumentException("Invalid card number");
        }
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        if (isNotValidExpiryDate(expiryDate)){
            throw new IllegalArgumentException("Invalid Expiry date");
        }
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        if (isNotValidCvv(cvv)){
            throw new IllegalArgumentException("Invalid Cvv");
        }
        this.cvv = cvv;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    private boolean isNotValidCvv(String cvv) {
        assert cvv != null;
        return !cvv.matches("\\d{3}");
    }

    private boolean isNotValidExpiryDate(String expiryDate) {
        assert expiryDate != null;
        return !expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}");
    }

    private boolean isNotValidCardNumber(String cardNumber) {
        assert cardNumber != null;
        return !cardNumber.matches("\\d{16}");
    }

    @Override
    public String toString(){
        return "Payment{"+
                "cardNumber= '"+ cardNumber + "'"+
                ", cardHolderName= '" + cardHolderName + "'"+
                ", expiryDate= '" + expiryDate + "'"+
                ", cvv= '" + cvv + '\''+
                "amount= "+ amount +
                '}';
    }
}

