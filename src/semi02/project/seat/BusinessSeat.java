package semi02.project.seat;

public class BusinessSeat implements Seat {

    @Override
    public void seatInfo() {
        System.out.println("비지니스 클래스 좌석을 선택하셨습니다.");
    }

    @Override
    public int extraCharge(int basePrice) {
        return (int) (basePrice * 1.4); // 비지니스는 40% 할증
    }
}
