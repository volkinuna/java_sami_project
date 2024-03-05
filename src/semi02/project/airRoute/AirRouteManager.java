package semi02.project.airRoute;

import semi02.project.airRoute.AirRoute;

import java.util.ArrayList;

public class AirRouteManager {

    private static ArrayList<AirRoute> routeList;

    public AirRouteManager() {
        this.routeList = new ArrayList<>();
    }

    // 노선 추가
    public void addRoute(AirRoute route) {
        routeList.add(route);
    }

    // 노선 제거
    public void removeRoute(AirRoute route) {
        routeList.remove(route);
    }

    // 출발지와 도착지에 해당하는 노선 조회 메소드
    public AirRoute findRoute(String departurePoint, String destination) {
        for (AirRoute route : routeList) {
            if (route.getDeparturePoint().equalsIgnoreCase(departurePoint) && route.getDestination().equalsIgnoreCase(destination)) {
                return route;
            }
        }
        return null; // 해당하는 노선이 없을 경우 null 반환
    }

    // 전체 노선 리스트 반환
    public ArrayList<AirRoute> getRouteList() {
        return routeList;
    }

}
