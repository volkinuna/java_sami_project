package semi02.project.airRoute;

import semi02.project.airRoute.AirRoute;
import semi02.project.utils.Define;

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
    public AirRoute findRoute(Define departurePoint, Define destination) {
        for (AirRoute route : routeList) {
            if (route.getDeparturePoint().equals(departurePoint) && route.getDestination().equals(destination)) {
                return route;
            }
        }
        return null;
    }

    // 전체 노선 리스트 반환
    public ArrayList<AirRoute> getRouteList() {
        return routeList;
    }
}
