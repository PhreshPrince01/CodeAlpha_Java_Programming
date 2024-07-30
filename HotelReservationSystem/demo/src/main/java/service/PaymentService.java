package service;

import model.Payment;
import util.CsvManager;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private List<Payment> paymentLog = new ArrayList<>();

    public boolean processPayment(Payment payment){
        if (isPaymentValid(payment)){
            paymentLog.add(payment);
            CsvManager.writePaymentToCsv(payment);
            System.out.println("Payment processed successfully:\n" + payment);
            return true;
        }
        else{
            System.out.println("Payment failed. Invalid payment details.");
            return false;
        }
    }

    public boolean processRefund(Payment payment){
        if (paymentLog.contains(payment)){
            paymentLog.remove(payment);
            CsvManager.removePaymentFromCsv(payment);
            System.out.println("Refund processed successfully for transaction ID: " + payment.getTransactionID());
            return true;
        }
        else {
            System.out.println("Refund failed. Payment not found.");
            return  false;
        }
    }

    public boolean isPaymentValid(Payment payment){
        // Validate payment details
        return payment != null &&
                payment.getCardHolderName() != null &&
                payment.getCardNumber() != null &&
                payment.getExpiryDate() != null &&
                payment.getCvv() != null &&
                payment.getAmount() > 0;
    }
    
}

