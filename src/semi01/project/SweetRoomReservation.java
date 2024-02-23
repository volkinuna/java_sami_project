package semi01.project;

import java.text.DecimalFormat;

public class SweetRoomReservation extends RoomReservation {

    // 필드
    public double discountRatio; // 할인율

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
        this.discountRatio = 0.2;
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

    @Override
    public String showRoomInfo() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formatPrice = decimalFormat.format(roomPrice);

        return roomName + " Room - 가격: " + formatPrice + "원, 제한인원: 없음, 조식제공여부: " + (breakfast ? "제공" : "미제공");
    }
}
