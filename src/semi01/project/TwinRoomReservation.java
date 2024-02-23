package semi01.project;

public class TwinRoomReservation extends RoomReservation {

    // 필드
    public double saleRatio; // 할인율

    // 생성자
    public TwinRoomReservation() {
        super.roomName = "Twin";
        super.roomPrice = 250000;
        super.maxGuests = 3;
        super.breakfast = false;
    }

    public TwinRoomReservation(String reservationName, int reservationDays) {
        super(reservationName, reservationDays);
        super.roomName = "Twin";
        super.roomPrice = 250000;
        super.maxGuests = 3;
        super.breakfast = false;
        this.saleRatio = 0.1;
    }

    public TwinRoomReservation(String reservationName, int reservationDays, String roomName, int maxGuests) {
        super(reservationName, reservationDays, roomName, maxGuests);
    }
}
