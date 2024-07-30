package util;

import model.Payment;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvManager {

    private static final String PAYMENT_CSV_FILE = "HotelReservationSystem/demo/src/main/resources/payments.csv";

    public static void writePaymentToCsv(Payment payment){
        try (FileWriter writer = new FileWriter(PAYMENT_CSV_FILE, true)){
            writer.append(payment.getTransactionID())
                    .append(",")
                    .append(payment.getCardNumber())
                    .append(",")
                    .append(payment.getCardHolderName())
                    .append(",")
                    .append(payment.getExpiryDate())
                    .append(payment.getCvv())
                    .append(String.valueOf(payment.getAmount()))
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Error writing payment to CSV file: " + e.getMessage());
        }
    }

    public static void removePaymentFromCsv(Payment payment){
        Path path = Paths.get(PAYMENT_CSV_FILE);
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }
        catch (IOException e){
            System.out.println("Error reading CSV file: " + e.getMessage());
            return;
        }
        lines.removeIf(line -> line.startsWith(payment.getTransactionID()));

        try {
            Files.write(path, lines);
        }
        catch (IOException e){
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

}

