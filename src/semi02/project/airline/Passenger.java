package semi02.project.airline;

import semi02.project.airRoute.AirRoute;
import semi02.project.seat.Seat;

import java.util.ArrayList;

public class Passenger {

    private String name; // 승객 이름
    private int age; // 승객 나이
    private String passportNumber; // 여권번호
    private boolean isRoundTrip; // 왕복 여부
    private int extraCharge; // 좌석 선택에 따라 할증된 금액
    private int finalPrice; // 최종 지불할 금액
    private Seat seat; // 선택한 좌석
    private ArrayList<AirRoute> routeList = new ArrayList<>(); // 노선 리스트

    public Passenger() {}

    public Passenger(String name, int age, boolean isRoundTrip) {
        this.name = name;
        this.age = age;
        this.isRoundTrip = isRoundTrip;
    }

    // 가격 계산 및 할인 적용 메소드
    public int calcFinalPrice(int extraCharge, int age, boolean isRoundTrip) {
        // 나이에 따른 할인 적용
        if (age <= 5 || age >= 70) {
            extraCharge = (int) (extraCharge * 0.95); // 5% 할인
        }

        // 왕복 여부에 따른 추가 할인 적용
        if (isRoundTrip) {
            extraCharge = (int) (extraCharge * 0.85); // 15% 할인
        }

        return extraCharge;
    }

    public boolean isRoundTrip() {
        return isRoundTrip;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
