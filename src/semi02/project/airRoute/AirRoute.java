package semi02.project.airRoute;

public class AirRoute {

    private String departurePoint; // 출발지
    private String destination; // 도착지
    private int departureTime; // 출발 시간
    private int arrivalTime; // 도착 시간
    private int basePrice; // 기본 요금

    public AirRoute(String departurePoint, String destination, int departureTime, int arrivalTime, int basePrice) {
        this.departurePoint = departurePoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "[출발지 : " + departurePoint +
                " | 도착지 : " + destination +
                " | 출발시간 : " + departureTime +
                "시 | 도착시간 : " + arrivalTime +
                "시 | 기본요금 : " + basePrice + "원]";
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
