package util;

import model.Payment;
import model.Reservation;
import model.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {
    
    private static final String ROOM_CSV_FILE = "HotelReservationSystem/demo/src/main/resources/rooms.csv";
    private static final String PAYMENT_CSV_FILE = "HotelReservationSystem/demo/src/main/resources/payments.csv";
    private static final String RESERVATION_CSV_FILE = "HotelReservationSystem/demo/src/main/resources/reservations.csv";
    
    public static List<Room> loadRoomsFromCsv(){
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ROOM_CSV_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                Room room = new Room(Integer.parseInt(values[0]), 
                        values[1],
                        Double.parseDouble(values[2]),
                        Boolean.parseBoolean(values[3]));
                rooms.add(room);
            }
        } catch (IOException e) {
            System.out.println("Error loading rooms from csv file: " e.getMessage());;
        } 
        return  rooms;
    }
    
    public static void updateRoomInCsv(Room room){
        Path path = Paths.get(ROOM_CSV_FILE);
        List<String> lines = List.of();
        try {
            lines = Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println("Error reading CSV file: "+ e.getMessage());;
        }
        
        for (int i = 0; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            if (Integer.parseInt(values[0])== room.getRoomNumber()){
                lines.set(i, room.getRoomNumber() + "," + room.getType() + "," + room.getPrice()+ "," + room.isAvailable());
                break;
            }
        }
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }

    public static List<Reservation> loadReservationFromCsv(){
        List<Reservation> reservations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_CSV_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                Reservation reservation = getReservation(line);
                reservations.add(reservation);
            }
        }catch (IOException e){
            System.out.println("Error loading reservation from CSV file: " + e.getMessage());
        }
        return reservations;
    }
    
    public static void writeReservationToCsv(Reservation reservation){
        try (FileWriter writer = new FileWriter(RESERVATION_CSV_FILE, true)){
            writer.append(reservation.getReservationID())
                    .append(",")
                    .append(String.valueOf(reservation.getRoomNumber()))
                    .append(reservation.getGuestName())
                    .append(",")
                    .append(reservation.getCheckInDate())
                    .append(",")
                    .append(reservation.getCheckOutDate())
                    .append(",")
                    .append(reservation.getPayment().getCardNumber())
                    .append(",")
                    .append(reservation.getPayment().getCardHolderName())
                    .append(",")
                    .append(reservation.getPayment().getExpiryDate())
                    .append(",")
                    .append(String.valueOf(reservation.getPayment().getAmount()))
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Error writing reservation to CSV file: "+  e.getMessage());
        }
    }

    private static Reservation getReservation(String line) {
        String[] values = line.split(",");
        Payment payment = new Payment(values[5],
                values[6],
                values[7],
                values[8],
                Double.parseDouble(values[9]));

        return new Reservation(
                Integer.parseInt(values[1]),
                values[0],
                values[2],
                values[3],
                values[4],
                payment);
    }

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
