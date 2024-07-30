package model;

public class Reservation {
    private String reservationID;
    private int roomNumber;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;
    private Payment payment;

    public Reservation(int roomNumber, String reservationID, String guestName, String checkInDate, Payment payment, String checkOutDate) {
        this.roomNumber = roomNumber;
        this.reservationID = reservationID;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.payment = payment;
        this.checkOutDate = checkOutDate;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    @Override
    public String toString(){
        return "  Reservation {" +
                "\treservationID= '" + reservationID + "'\n" +
                "\troomNumber= '" + roomNumber + "'\n" +
                "\tguestName= '" + guestName + "'\n" +
                "\tcheckInDate= '" + checkInDate + "'\n" +
                "\tcheckOutDate= '" + checkOutDate + "'\n" +
                "\tpayment= '" + payment + "'\n" +
                "}";
    }
}
