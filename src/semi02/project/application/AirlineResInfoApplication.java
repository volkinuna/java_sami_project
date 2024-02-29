package semi02.project.application;

import semi02.project.airline.Airline;

import java.util.Scanner;

public class AirlineResInfoApplication {

    private static Scanner scanner = new Scanner(System.in);
    Airline volkiAir = Airline.getInstance();

    public static void main(String[] args) {

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

        departurePointMenu();
        int departurePoint = scanner.nextInt();
        destinationMenu();
        int destination = scanner.nextInt();

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

        int selectedIndex = scanner.nextInt() - 1; // 선택된 도시의 인덱스 번호

        // 선택된 인덱스에 해당하는 도시 코드 반환
        return cityCodeList[selectedIndex];
    }

    // 도착지를 선택 메소드
    public static String  destinationMenu() {
        System.out.println("--- 도착지로 선택이 가능한 나라 ---");

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
        System.out.print("도착지 선택 : ");

        int selectedIndex = scanner.nextInt() - 1; // 선택된 도시의 인덱스 번호

        // 선택된 인덱스에 해당하는 도시 코드 반환
        return cityCodeList[selectedIndex];
    }


    // 예약 확인
    
    // 개설된 모든 노선 정보 확인

    // 예약 목록 보기

}
