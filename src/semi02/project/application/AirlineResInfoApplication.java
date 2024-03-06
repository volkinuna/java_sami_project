package semi02.project.application;

import semi02.project.airRoute.AirRoute;
import semi02.project.airRoute.AirRouteManager;
import semi02.project.airRoute.AirRouteSystem;
import semi02.project.airline.Airline;
import semi02.project.airline.Passenger;
import semi02.project.seat.BusinessSeat;
import semi02.project.seat.EconomicSeat;
import semi02.project.seat.FirstClassSeat;
import semi02.project.seat.Seat;

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
                        reservationCheck();
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

    // 1.항공편예약
    public static void reservation() {
        System.out.println(">>>>>>> 예약하기 <<<<<<<<");

        // 현재 선택 가능한 노선 목록 가져오기
        ArrayList<AirRoute> availableRoutes = routeManager.getRouteList();

        System.out.println("--- 현재 선택 가능한 노선 목록 ---");
        for (int i = 0; i < availableRoutes.size(); i++) {
            System.out.println((i + 1) + ". " + availableRoutes.get(i));
        }

        System.out.print("노선 선택 : ");
        int selectedRouteIndex = scanner.nextInt() - 1;

        if (selectedRouteIndex >= 0 && selectedRouteIndex < availableRoutes.size()) {
            AirRoute selectedRoute = availableRoutes.get(selectedRouteIndex);
            System.out.println("선택한 노선 : " + selectedRoute);

            // 선택한 노선에 따른 기본 요금 조회
            int basePrice = selectedRoute.getBasePrice();

            Seat selectedSeat = null;

            while (selectedSeat == null) {
                // 좌석 선택
                System.out.println("--- 좌석 선택 ---");
                System.out.println("1. 이코노미 클래스(기본 요금)");
                System.out.println("2. 비지니스 클래스(40% 할증)");
                System.out.println("3. 퍼스트 클래스(70% 할증)");
                System.out.print("좌석 선택 : ");
                int seatChoice = scanner.nextInt();

                // 좌석 선택에 따라 해당 Seat 객체 생성
                switch (seatChoice) {
                    case 1:
                        selectedSeat = new EconomicSeat();
                        break;
                    case 2:
                        selectedSeat = new BusinessSeat();
                        break;
                    case 3:
                        selectedSeat = new FirstClassSeat();
                        break;
                    default:
                        System.out.println("올바른 좌석을 선택하세요.");
                        break;
                }
            }

            // 선택한 좌석 정보 출력
            selectedSeat.seatInfo();

            // 예약 정보 입력
            System.out.print("예약자 명 : ");
            String name = scanner.next();
            System.out.print("나이 : ");
            int age = scanner.nextInt();
            System.out.print("여권번호 : ");
            String passportNumber = scanner.next();

            boolean isRoundTrip = false;
            System.out.print("편도(1) 또는 왕복(2) 선택 : ");
            int tripType;
            while (true) {
                if (scanner.hasNextInt()) {
                    tripType = scanner.nextInt();
                    if (tripType == 1 || tripType == 2) {
                        isRoundTrip = (tripType == 2);
                        break;
                    } else {
                        System.out.println("1 또는 2를 입력하세요.");
                    }
                } else {
                    System.out.println("숫자로 입력해주세요.");
                    scanner.next();
                }
            }

            // 선택한 좌석에 따른 할증 금액 계산
            int extraCharge = selectedSeat.extraCharge(basePrice);

            // 예약 객체 생성
            Passenger passenger = new Passenger(name, age, isRoundTrip);
            passenger.setPassportNumber(passportNumber); // 여권번호 설정

            // 최종 요금 계산
            int finalPrice = passenger.calcFinalPrice(extraCharge, age, isRoundTrip);
            passenger.calcFinalPrice(selectedRoute.getBasePrice(), age, isRoundTrip);
            passenger.setFinalPrice(finalPrice);

            // 노선에 승객 추가
            selectedRoute.addPassenger(passenger, selectedSeat);

            // AirRoute에 승객과 좌석 정보 추가
            selectedRoute.addPassenger(passenger, selectedSeat);

            // AirRoute에 승객과 좌석 정보를 할당
            selectedRoute.assignSeat(passenger, selectedSeat);

            // 예약 정보 출력
            System.out.println("----- 예약 정보 -----");
            System.out.println("예약자 명 : " + name);
            System.out.println("나이 : " + age);
            System.out.println("여권번호 : " + passportNumber);
            System.out.println("노선 : " + selectedRoute);
            System.out.println("좌석 등급 : " + selectedSeat.getClass().getSimpleName());
            System.out.println("편도 여부 : " + (isRoundTrip ? "왕복" : "편도"));
            System.out.println("최종 결제금액 : " + finalPrice);
        } else {
            System.out.println("올바른 노선을 선택하세요.");
        }
    }

    // 2.예약확인
    public static void reservationCheck() {
        System.out.println(">>>>>>> 예약 확인 <<<<<<<<");
        System.out.print("예약자 명 : ");
        String name = scanner.next();

        // 예약 정보 확인
        boolean foundReservation = false;
        for (AirRoute route : routeManager.getRouteList()) {
            for (Passenger passenger : route.getPassengerList()) {
                if (passenger.getName().equals(name)) {
                    if (!foundReservation) {
                        System.out.println("----- 예약 정보 -----");
                        foundReservation = true;
                    }
                    System.out.println("예약자 명 : " + passenger.getName());
                    System.out.println("나이 : " + passenger.getAge());
                    System.out.println("여권번호 : " + passenger.getPassportNumber());
                    System.out.println("노선 : " + route);
                    // 예약한 좌석 정보 가져오기
                    Seat reservedSeat = route.getSeat(passenger);
                    if (reservedSeat != null) {
                        System.out.println("좌석 등급 : " + reservedSeat.getClass().getSimpleName());
                    } else {
                        System.out.println("예약한 좌석 정보를 가져올 수 없습니다.");
                    }
                    // 왕복 여부 출력
                    System.out.println("왕복 여부 : " + (passenger.isRoundTrip() ? "왕복" : "편도"));
                    int finalPrice = passenger.getFinalPrice(); // 최종 결제금액 가져오기
                    System.out.println("최종 결제금액 : " + finalPrice);
                    break; // 해당 예약자명에 대한 정보를 찾았으면 더 이상 반복할 필요가 없으므로 반복문을 빠져나옴
                }
            }
        }

        if (!foundReservation) {
            System.out.println("해당 예약자명으로 된 예약 정보가 없습니다.");
        }
    }

    // 3.노선정보
    public static void viewRouteInfo() {
        ArrayList<AirRoute> routes = routeManager.getRouteList();
        System.out.println("===== 전체 노선 정보 =====");
        for (AirRoute route : routes) {
            System.out.println(route);
        }
        System.out.println("※ 이코노미 클래스 좌석은 기본요금, 비지니스 클래스 좌석은 40% 할증, 퍼스트 클래스 좌석은 70% 할증됩니다.");
        System.out.println("※ 5세 이하, 70세 이상 승객님은 5% 추가 할인, 왕복으로 선택시 15% 중복 할인 가능합니다.");
    }

    // 4.예약목록


}
