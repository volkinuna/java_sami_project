package semi01.project;

import java.text.DecimalFormat;

public class RoomReservation {

    // 필드
    private String reservationName; // 예약자명
    public int maxGuests;           // 예약 가능 인원
    protected int reservationDays;  // 예약 일수
    public int roomPrice;           // 룸 가격
    public String roomName;         // 룸 이름
    public boolean breakfast;       // 조식 제공 여부

    // 생성자
    public RoomReservation() {
        roomInfo();
    }

    public RoomReservation(String reservationName, int reservationDays) {
        this.reservationName = reservationName;
        this.reservationDays = reservationDays;

        roomInfo();
    }

    // 메소드
    public void roomInfo() {
        roomName = "Single";
        roomPrice = 100000;
        maxGuests = 1;
        breakfast = false;
    }

    // 요금
    public int clacPrice(int reservationDays) {
        return roomPrice * reservationDays;
    }
    
    // 해당 룸의 정보 보기
    public String showRoomInfo() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formatPrice = decimalFormat.format(roomPrice);

        return roomName + " Room - 가격: " + formatPrice + "원, 제한인원: " + maxGuests + "명, 조식제공여부: " + (breakfast ? "제공" : "미제공");
    }    

    // 예약 정보 확인
    public String showReservationInfo() {
        return reservationName + "님께서 " + roomName + " Room을 " + reservationDays + "일 예약하셨습니다. (조식제공: " + (breakfast ? "O)" : "X)");
    }

    // Getter & Setter
    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public int getReservationDays() {
        return reservationDays;
    }

    public void setReservationDays(int reservationDays) {
        this.reservationDays = reservationDays;
    }
}
