package semi01.project;

public class DoubleRoomReservation extends RoomReservation {

    // 필드
    public double discountRatio; // 할인율

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
        this.discountRatio = 0.05;
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
