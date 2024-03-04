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

    // 전체 노선 리스트 반환
    public ArrayList<AirRoute> getRouteList() {
        return routeList;
    }

    // 출발지, 출발 시간에 따른 노선 검색
//    public ArrayList<AirRoute> findRoutesByTime(String departurePoint, int departureTime) {
//        ArrayList<AirRoute> matchingRoutes = new ArrayList<>();
//        for (AirRoute route : routeList) {
//            if (route.getDeparturePoint().equals(departurePoint) &&
//                    route.getDepartureTime() == departureTime) {
//                matchingRoutes.add(route);
//            }
//        }
//        return matchingRoutes;
//    }

    public static ArrayList<AirRoute> findRoutesByTime(String departurePoint, int departureTime, int arrivalTime) {
        ArrayList<AirRoute> matchingRoutes = new ArrayList<>();
        for (AirRoute route : routeList) {
            if (route.getDeparturePoint().equals(departurePoint) &&
                    route.getDepartureTime() == departureTime &&
                    route.getArrivalTime() == arrivalTime) {
                matchingRoutes.add(route);
            }
        }
        return matchingRoutes;
    }


}
