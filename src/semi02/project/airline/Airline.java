package semi02.project.airline;

import semi02.project.airRoute.AirRoute;

import java.util.ArrayList;

public class Airline { // 싱글톤

    private static String AIRLINE_NAME = "Volki-Air"; // 항공사 이름
    private ArrayList<Passenger> passengerList = new ArrayList<>(); // 승객 리스트
    private ArrayList<AirRoute> routeList = new ArrayList<>(); // 노선 리스트

    private static Airline instance = null;

    private Airline() {}

    public static Airline getInstance() {
        if (instance == null) {
            instance = new Airline();
        }
        return instance;
    }
    
    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public ArrayList<AirRoute> getRouteList() {
        return routeList;
    }

    public void setRouteList(ArrayList<AirRoute> routeList) {
        this.routeList = routeList;
    }
}
