package semi02.project.airline;

import java.util.ArrayList;

public class AirRouteManager {

    private ArrayList<AirRoute> routeList;

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

}
