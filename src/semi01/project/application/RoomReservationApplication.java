package semi01.project.application;

import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SweetRoomReservation;
import semi01.project.TwinRoomReservation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomReservationApplication {
    private static Scanner scanner = new Scanner(System.in);
    public static ArrayList<RoomReservation> roomList = new ArrayList<>();
    private static ArrayList<RoomReservation> reservationList = new ArrayList<>();

    public static void main(String[] args) {

        RoomReservation singleRoom = new RoomReservation();
        RoomReservation doubleRoom = new DoubleRoomReservation();
        RoomReservation twinRoom = new TwinRoomReservation();
        RoomReservation sweetRoom = new SweetRoomReservation();
        roomList.add(singleRoom);
        roomList.add(doubleRoom);
        roomList.add(twinRoom);
        roomList.add(sweetRoom);

        boolean run = true;

        while (run) {
            System.out.println("----------------------------------------------------");
            System.out.println("1.예약하기 | 2.예약확인 | 3.Room정보 | 4.예약목록 | 5.종료");
            System.out.println("----------------------------------------------------");
            System.out.print("메뉴 선택> ");

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
                        showAllRoom();
                        break;
                    case 4:
                        allReservationCheck();
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

    // 예약하기
    public static void reservation() {
        System.out.println("======== 예약하기 ========");
        System.out.print("예약자 명 : ");
        String reservationName = scanner.next();
        System.out.print("예약 일수 : ");
        int reservationDays = scanner.nextInt();
        System.out.print("예약 인원 : ");
        int guests = scanner.nextInt();
        System.out.println("예약할 룸");
        System.out.print("(single, double, twin, sweet 중) : ");
        String roomName = scanner.next();

        RoomReservation reservation = null;

        switch (roomName) {
            case "single":
                RoomReservation singleReservation = new RoomReservation();
                if (guests > singleReservation.maxGuests) {
                    System.out.println("Single Room의 최대 예약 가능 인원은 " + singleReservation.maxGuests + "명입니다.");
                } else {
                    reservation = new RoomReservation(reservationName, reservationDays);
                }
                break;
            case "double":
                RoomReservation doubleReservation = new DoubleRoomReservation();
                if (guests > doubleReservation.maxGuests) {
                    System.out.println("Double Room의 최대 예약 가능 인원은 " + doubleReservation.maxGuests + "명입니다.");
                } else {
                    reservation = new DoubleRoomReservation(reservationName, reservationDays);
                }
                break;
            case "twin":
                RoomReservation twinReservation = new TwinRoomReservation();
                if (guests > twinReservation.maxGuests) {
                    System.out.println("Twin Room의 최대 예약 가능 인원은 " + twinReservation.maxGuests + "명입니다.");
                } else {
                    reservation = new TwinRoomReservation(reservationName, reservationDays);
                }
                break;
            case "sweet":
                RoomReservation sweetReservation = new SweetRoomReservation();
                reservation = new SweetRoomReservation(reservationName, reservationDays);
                break;
            default:
                System.out.println("룸 이름을 잘못 입력하셨습니다.");
        }

        if (reservation != null) {
            System.out.println("======= 예약 정보 =======");
            System.out.println("예약자명 : " + reservation.getReservationName());
            System.out.println("예약한 룸 : " + reservation.roomName + " Room");
            System.out.println("예약 일수 : " + reservation.getReservationDays() + "일");
            System.out.println("조식 제공 여부 : " + (reservation.breakfast ? "제공" : "미제공"));

            DecimalFormat decimalFormat = new DecimalFormat("###,###");
            String formatPrice = decimalFormat.format(reservation.clacPrice(reservationDays));
            System.out.println("총 가격 : " + formatPrice + "원");
            System.out.println(">> 예약이 완료되었습니다.");
            reservationList.add(reservation);
        }
    }

    // 예약 확인
    public static void reservationCheck() {
        System.out.println("========== 예약 확인 ==========");
        System.out.print("예약자명 : ");
        String reservationName = scanner.next();

        for (RoomReservation roomReservation : reservationList) {
            if(roomReservation.getReservationName().equals(reservationName)) {
                System.out.println(reservationName + "님께선 " + roomReservation.roomName + " Room을 " + roomReservation.getReservationDays() + "일 예약하셨습니다.");
                System.out.println("(조식이 " + (roomReservation.breakfast ? "제공됩니다.)" : "제공되지 않습니다.)"));
                return;
            }
        }
        System.out.println(reservationName + "님으로 예약된 내역이 없습니다.");
    }

    // 모든 룸의 정보 보기
    public static void showAllRoom() {
        System.out.println("================== 모든 Room의 정보 ==================");

        for (RoomReservation roomReservation : roomList) {
            System.out.println(roomReservation.showRoomInfo());
        }
    }

    // 예약 목록
    public static void allReservationCheck() {
        System.out.println("=================== 전체 예약 목록 ===================");

        for (RoomReservation reservation : reservationList) {
            System.out.println(reservation.showReservationInfo());
        }

        if (reservationList.size() == 0) System.out.println("예약된 내용이 없습니다.");
    }

}
