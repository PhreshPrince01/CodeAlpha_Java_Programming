package service;

import model.Payment;
import model.Reservation;
import util.CsvManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        this.reservations = CsvManager.loadReservationsFromCsv();
    }
    
    public Reservation createReservation(int roomNumber, String guestName, String checkInDate, String checkOutDate, Payment payment){
        String reservationID = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(roomNumber, reservationID, guestName, checkInDate, checkOutDate, payment);
        reservations.add(reservation);
        CsvManager.writeReservationToCsv(reservation);
        return reservation;
    }
    
    public Reservation getReservationById(String reservationID){
        for (Reservation reservation : reservations){
            if (reservation.getReservationID().equalsIgnoreCase(reservationID)){
                return reservation;
            }
        }
        return null;
    }
    
    public List<Reservation> getReservationsByGuestName(String guestName){
        List<Reservation> guestReservations = new ArrayList<>();
        for (Reservation reservation : reservations){
            if (reservation.getGuestName().equalsIgnoreCase(guestName)){
                guestReservations.add(reservation);
            }
        }
        return guestReservations;
    }
}
