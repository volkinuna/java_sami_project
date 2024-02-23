package semi01.project;

public class SweetRoomReservation extends RoomReservation {

    // 필드
    public double saleRatio; // 할인율

    // 생성자
    public SweetRoomReservation() {
        super.roomName = "Sweet";
        super.roomPrice = 500000;
        super.breakfast = true;
    }

    public SweetRoomReservation(String reservationName, int reservationDays) {
        super(reservationName, reservationDays);
        super.roomName = "Sweet";
        super.roomPrice = 500000;
        super.breakfast = true;
        this.saleRatio = 0.2;
    }

    public SweetRoomReservation(String reservationName, int reservationDays, String roomName, int maxGuests) {
        super(reservationName, reservationDays, roomName, maxGuests);
    }
}
