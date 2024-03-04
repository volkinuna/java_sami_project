package semi02.project.application;

import semi02.project.airRoute.AirRoute;
import semi02.project.airRoute.AirRouteManager;
import semi02.project.airRoute.AirRouteSystem;
import semi02.project.airline.Airline;
import semi02.project.airline.Passenger;

import java.util.ArrayList;
import java.util.Scanner;

public class AirlineResInfoApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static Airline volkiAir = Airline.getInstance();
    private static AirRouteManager routeManager = new AirRouteManager();

    public static void main(String[] args) {

        // AirRouteSystem에서 생성된 노선 추가
        AirRouteSystem.addRouteList(routeManager);

        boolean run = true;

        while (run) {
            System.out.println("-----------------------------------------------------");
            System.out.println("1.항공편예약 | 2.예약확인 | 3.노선정보 | 4.예약목록 | 5.종료");
            System.out.println("-----------------------------------------------------");
            System.out.print("선택> ");

            if (scanner.hasNextInt()) {
                int selectNo = scanner.nextInt();

                switch (selectNo) {
                    case 1:
                        reservation();
                        break;
                    case 2:
                        break;
                    case 3:
                        viewRouteInfo();
                        break;
                    case 4:
                        break;
                    case 5:
                        run = false;
                        break;
                }
            } else {
                System.out.println("숫자로 입력해주세요.");
                scanner.next();
            }
        }
        System.out.println("프로그램 종료");
    }

    // 항공편 예약하기
    public static void reservation() {
        System.out.println(">>>>>>> 예약하기 <<<<<<<<");
        System.out.print("예약자 명 : ");
        String name = scanner.next();
        System.out.print("나이 : ");
        int age = scanner.nextInt();
        System.out.print("여권번호 : ");
        String passportNumber = scanner.next();

        String departurePoint = departurePointMenu();
        //String destination = destinationMenu();

        boolean isRoundTrip = false;
        System.out.print("편도(1) 또는 왕복(2) 선택: ");
        int tripType;
        while (true) {
            if (scanner.hasNextInt()) {
                tripType = scanner.nextInt();
                if (tripType == 1) {
                    isRoundTrip = false; // 편도
                    break;
                } else if (tripType == 2) {
                    isRoundTrip = true; // 왕복
                    break;
                } else {
                    System.out.println("1 또는 2를 입력하세요.");
                }
            }
        }

        Passenger passenger = new Passenger(name, age, tripType == 2); // 왕복 여부를 입력값에 따라 초기화
        passenger.calcFinalPrice(100000, age, tripType == 2); // 기본 요금과 나이, 왕복 여부를 매개변수로 최종 가격 계산

        System.out.println("----- 예약 정보 -----");
        System.out.println("예약자 명: " + name);
        System.out.println("나이: " + age);
        System.out.println("여권번호: " + passportNumber);
        System.out.println("출발지: " + departurePoint);
        //System.out.println("도착지: " + destination);
        System.out.println("편도 여부: " + (isRoundTrip ? "왕복" : "편도"));
        System.out.println(">> 최종 결제금액: " + passenger.getFinalPrice());
    }

    // 출발지를 선택 메소드
    public static String departurePointMenu() {
        System.out.println("--- 출발지로 선택이 가능한 나라 ---");

        String[] cityList = {"서울", "인천", "제주도", "뉴욕", "LA", "하와이", "파리", "런던", "바르셀로나", "로마", "베네치아", "이스탄불", "밴쿠버", "퀘벡", "토론토", "프라하"};
        String[] cityCodeList = {"SEOUL", "INCHEON", "JEJU", "NEW_YORK", "LOS_ANGELES", "HAWAII", "PARIS", "LONDON", "BARCELONA", "ROME", "VENEZIA", "ISTANBUL", "VANCOUVER", "QUEBEC", "TORONTO", "PRAQUE"};

        int citiesLine = 5; // 한 줄에 출력할 도시의 개수

        for (int i = 0; i < cityList.length; i++) {
            System.out.print((i + 1) + "." + cityList[i] + "\t");
            // 한 줄에 5개의 도시를 출력하고 줄 바꿈
            if ((i + 1) % citiesLine == 0 || i == cityList.length - 1) {
                System.out.println();
            }
        }
        System.out.print("출발지 선택 : ");

        int selectIndex = scanner.nextInt() - 1; // 선택된 도시의 인덱스 번호

        // 선택된 인덱스에 해당하는 도시 코드 반환
        String selectedDeparturePoint = cityCodeList[selectIndex];

        // 선택한 출발지에 따른 가능한 출발 시간 목록 표시
        System.out.println("--- 출발 시간 선택 ---");
        ArrayList<Integer> availableDepartureTimes = getAvailableDepartureTimes(selectedDeparturePoint);
        for (int i = 0; i < availableDepartureTimes.size(); i++) {
            System.out.println((i + 1) + ". " + availableDepartureTimes.get(i) + "시");
        }
        System.out.print("출발 시간 선택 : ");
        int selectedDepartureTimeIndex = scanner.nextInt() - 1; // 선택된 출발 시간의 인덱스 번호
        int selectedDepartureTime = availableDepartureTimes.get(selectedDepartureTimeIndex); // 선택된 출발 시간

        // 선택된 출발 시간과 출발지에 따라 가능한 도착지 목록 표시
        ArrayList<AirRoute> matchingRoutes = AirRouteManager.findRoutesByTime(selectedDeparturePoint, selectedDepartureTime, -1); // arrivalTime은 필터링하지 않음
        System.out.println("--- 가능한 도착지 목록 ---");
        for (AirRoute route : matchingRoutes) {
            System.out.println(route.getDestination());
        }
        System.out.print("도착지 선택 : ");
        int selectedDestinationIndex = scanner.nextInt() - 1; // 선택된 도착지의 인덱스 번호
        String selectedDestination = matchingRoutes.get(selectedDestinationIndex).getDestination(); // 선택된 도착지

        return selectedDeparturePoint;
    }

    private static ArrayList<Integer> getAvailableDepartureTimes(String departurePoint) {
        ArrayList<Integer> departureTimes = new ArrayList<>();
        // 각 도시에 따른 출발 시간 목록 설정
        switch (departurePoint) {
            case "SEOUL":
                departureTimes.add(9);
                departureTimes.add(13);
                departureTimes.add(17);
                departureTimes.add(21);
                break;
            case "JEJU":
                departureTimes.add(11);
                departureTimes.add(15);
                departureTimes.add(19);
                departureTimes.add(23);
                break;
        }
        return departureTimes;
    }

    // 도착지를 선택 메소드
//    public static String destinationMenu() {
//        System.out.println("--- 도착지로 선택이 가능한 나라 ---");
//
//        String[] cityList = {"서울", "인천", "제주도", "뉴욕", "LA", "하와이", "파리", "런던", "바르셀로나", "로마", "베네치아", "이스탄불", "밴쿠버", "퀘벡", "토론토", "프라하"};
//        String[] cityCodeList = {"SEOUL", "INCHEON", "JEJU", "NEW_YORK", "LOS_ANGELES", "HAWAII", "PARIS", "LONDON", "BARCELONA", "ROME", "VENEZIA", "ISTANBUL", "VANCOUVER", "QUEBEC", "TORONTO", "PRAQUE"};
//
//        int citiesLine = 5; // 한 줄에 출력할 도시의 개수
//
//        for (int i = 0; i < cityList.length; i++) {
//            System.out.print((i + 1) + "." + cityList[i] + "\t");
//            // 한 줄에 5개의 도시를 출력하고 줄 바꿈
//            if ((i + 1) % citiesLine == 0 || i == cityList.length - 1) {
//                System.out.println();
//            }
//        }
//        System.out.print("도착지 선택 : ");
//
//        int selectIndex = scanner.nextInt() - 1; // 선택된 도시의 인덱스 번호
//
//        // 선택된 인덱스에 해당하는 도시 코드 반환
//        return cityCodeList[selectIndex];
//    }

    // 예약 확인

    // 개설된 모든 노선 정보 확인
    public static void viewRouteInfo() {
        ArrayList<AirRoute> routes = routeManager.getRouteList();
        System.out.println("===== 전체 노선 정보 =====");
        for (AirRoute route : routes) {
            System.out.println(route);
        }
        System.out.println("※ 이코노미 클래스 좌석은 기본요금, 비지니스 클래스 좌석은 40% 할증, 퍼스트 클래스 좌석은 70% 할증됩니다.");
        System.out.println("※ 5세 이하, 70세 이상 승객님은 5% 추가 할인, 왕복으로 선택시 15% 중복 할인 가능합니다.");
    }

    // 예약 목록 보기

}
