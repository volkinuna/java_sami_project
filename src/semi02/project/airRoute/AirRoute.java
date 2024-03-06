package semi02.project.airRoute;

import semi02.project.airline.Passenger;
import semi02.project.seat.Seat;

import java.util.ArrayList;
import java.util.HashMap;

public class AirRoute {

    private String departurePoint; // 출발지
    private String destination; // 도착지
    private int departureTime; // 출발 시간
    private int arrivalTime; // 도착 시간
    private int basePrice; // 기본 요금
    private ArrayList<Passenger> passengerList;
    private HashMap<Passenger, Seat> seatMap;

    public AirRoute(String departurePoint, String destination, int departureTime, int arrivalTime, int basePrice) {
        this.departurePoint = departurePoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
        this.passengerList = new ArrayList<>();
        this.seatMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "[출발지 : " + departurePoint +
                " | 도착지 : " + destination +
                " | 출발시간 : " + departureTime +
                "시 | 도착시간 : " + arrivalTime +
                "시 | 기본요금 : " + basePrice + "원]";
    }


    // 승객 추가 메소드
    public void addPassenger(Passenger passenger, Seat seat) {
        passengerList.add(passenger);
    }

    // 승객 목록 반환 메소드
    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    // 승객의 좌석 정보를 저장하는 메소드
    public void assignSeat(Passenger passenger, Seat seat) {
        seatMap.put(passenger, seat);
    }

    // 승객의 좌석 정보 반환 메소드
    public Seat getSeat(Passenger passenger) {
        return seatMap.get(passenger);
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
