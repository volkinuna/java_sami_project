package semi02.project.airRoute;

import semi02.project.utils.Define;

public class AirRouteSystem {
    public static void addRouteList(AirRouteManager routeManager) {

        // 서울에서 제주(09:00~10:00) 노선 추가
        AirRoute seoulToJeju9 = new AirRoute(Define.SEOUL, Define.JEJU, 9, 10, 100000);
        routeManager.addRoute(seoulToJeju9);

        // 서울에서 제주(13:00~14:00) 노선 추가
        AirRoute seoulToJeju12 = new AirRoute(Define.SEOUL, Define.JEJU, 13, 14, 100000);
        routeManager.addRoute(seoulToJeju12);

        // 서울에서 제주(17:00~18:00) 노선 추가
        AirRoute seoulToJeju15 = new AirRoute(Define.SEOUL, Define.JEJU, 17, 18, 100000);
        routeManager.addRoute(seoulToJeju15);

        // 서울에서 제주(21:00~22:00) 노선 추가
        AirRoute seoulToJeju19 = new AirRoute(Define.SEOUL, Define.JEJU, 21, 22, 100000);
        routeManager.addRoute(seoulToJeju19);

        // 제주에서 서울(11:00~12:00) 노선 추가
        AirRoute jejuToSeoul = new AirRoute(Define.JEJU, Define.SEOUL, 11, 12, 100000);
        routeManager.addRoute(jejuToSeoul);

        // 제주에서 서울(15:00~16:00) 노선 추가
        AirRoute jejuToSeoul12 = new AirRoute(Define.JEJU, Define.SEOUL, 15, 16, 100000);
        routeManager.addRoute(jejuToSeoul12);

        // 제주에서 서울(19:00~20:00) 노선 추가
        AirRoute jejuToSeoul15 = new AirRoute(Define.JEJU, Define.SEOUL, 19, 20, 100000);
        routeManager.addRoute(jejuToSeoul15);

        // 제주에서 서울(23:00~24:00) 노선 추가
        AirRoute jejuToSeoul19 = new AirRoute(Define.JEJU, Define.SEOUL, 23, 24, 100000);
        routeManager.addRoute(jejuToSeoul19);
    }
}
