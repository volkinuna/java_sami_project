package semi01.project;

public class TwinRoomReservation extends RoomReservation {

    // 필드
    public double discountRatio; // 할인율

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
        this.discountRatio = 0.1;
    }

    // 메소드
    @Override
    public int clacPrice(int reservationDays) {
        int totalPrice = roomPrice * reservationDays;
        if (reservationDays >= 3) {
            totalPrice = totalPrice - (int)(totalPrice * discountRatio);
        }
        return totalPrice;
    }
}
