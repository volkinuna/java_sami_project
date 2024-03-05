package semi02.project.seat;

public class EconomicSeat implements Seat {

    @Override
    public void seatInfo() {
        System.out.println("이코노미 클래스 좌석을 선택하셨습니다.");
    }

    @Override
    public int extraCharge(int basePrice) {
        return basePrice; // 이코노미는 기본 가격
    }
}
