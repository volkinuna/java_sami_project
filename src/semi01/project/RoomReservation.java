package semi01.project;

public class RoomReservation {

    // 필드
    private String reservationName; // 예약자명
    public int maxGuests;           // 예약 인원
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

    public RoomReservation(String reservationName, int reservationDays, String roomName, int maxGuests) {
        this.reservationName = reservationName;
        this.reservationDays = reservationDays;
        this.roomName = roomName;
        this.maxGuests = maxGuests;
    }

    // 메소드
    public void roomInfo() {
        roomName = "Single";
        roomPrice = 100000;
        maxGuests = 1;
        breakfast = false;
    }

    // 해당 룸의 정보 보기
    public String showRoomInfo() {
        return roomName + " Room - 가격: " + roomPrice + "원, 제한인원: " + maxGuests + ", 조식제공여부: " + breakfast;
    }

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
