package semi01.project;

public class DoubleRoomReservation extends RoomReservation {

    // 필드
    public double saleRatio; // 할인율

    // 생성자
    public DoubleRoomReservation() {
        super.roomName = "Double";
        super.roomPrice = 200000;
        super.maxGuests = 2;
        super.breakfast = false;
    }

    public DoubleRoomReservation(String reservationName, int reservationDays) {
        super(reservationName, reservationDays);
        super.roomName = "Double";
        super.roomPrice = 200000;
        super.maxGuests = 2;
        super.breakfast = false;
        this.saleRatio = 0.05;
    }

    public DoubleRoomReservation(String reservationName, int reservationDays, String roomName, int maxGuests) {
        super(reservationName, reservationDays, roomName, maxGuests);
    }

}
