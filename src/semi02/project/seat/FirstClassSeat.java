package semi02.project.seat;

public class FirstClassSeat implements Seat {

    @Override
    public void seatInfo() {
        System.out.println("퍼스트 클래스 좌석을 선택하셨습니다.");
    }

    @Override
    public int extraCharge(int basePrice) {
        return (int) (basePrice * 1.7); // 퍼스트 클래스는 70% 할증
    }
}
