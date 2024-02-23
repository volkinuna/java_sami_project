package semi01.project.application;

import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SweetRoomReservation;
import semi01.project.TwinRoomReservation;

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
            System.out.println("--------------------------------------------------------");
            System.out.println("1.예약하기 | 2.예약확인 | 3.룸정보보기 | 4.모든예약확인 | 5.종료");
            System.out.println("--------------------------------------------------------");
            System.out.print("메뉴 선택> ");
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
        }
        System.out.println("프로그램 종료");
    }

    // 예약하기
    public static void reservation() {
        System.out.println("======= 예약하기 =======");
        System.out.print("예약자 명 : ");
        String reservationName = scanner.next();
        System.out.print("예약 일수 : ");
        int reservationDays = scanner.nextInt();
        System.out.print("예약할 룸(single, double, twin, sweet 중) : ");
        String roomName = scanner.next();
        System.out.print("예약 인원 : ");
        int guests = scanner.nextInt();

        RoomReservation reservation = null;

        switch (roomName) {
            case "single":
                RoomReservation singleInfo = new RoomReservation();
                if (guests > singleInfo.maxGuests) {
                    System.out.println("Single Room은 최대 " + singleInfo.maxGuests + "명까지 예약 가능합니다.");
                } else {
                    reservation = new RoomReservation(reservationName, reservationDays);
                }
                break;
            case "double":
                RoomReservation doubleInfo = new DoubleRoomReservation();
                if (guests > doubleInfo.maxGuests) {
                    System.out.println("Single Room은 최대 " + doubleInfo.maxGuests + "명까지 예약 가능합니다.");
                } else {
                    reservation = new DoubleRoomReservation(reservationName, reservationDays);
                }
                break;
            case "twin":
                RoomReservation twinInfo = new TwinRoomReservation();
                if (guests > twinInfo.maxGuests) {
                    System.out.println("Single Room은 최대 " + twinInfo.maxGuests + "명까지 예약 가능합니다.");
                } else {
                    reservation = new TwinRoomReservation(reservationName, reservationDays);
                }
                break;
            case "sweet":
                RoomReservation sweetInfo = new SweetRoomReservation();
                if (guests > sweetInfo.maxGuests) {
                    System.out.println("Single Room은 최대 " + sweetInfo.maxGuests + "명까지 예약 가능합니다.");
                } else {
                    reservation = new SweetRoomReservation(reservationName, reservationDays);
                }
                break;
            default:
                System.out.println("룸 이름을 잘못 입력하셨습니다.");
        }

        if (reservation != null) {
            System.out.println("======= 예약 정보 =======");
            System.out.println("예약자명 : " + reservation.getReservationName());
            System.out.println("룸 이름 : " + reservation.roomName + " room");
            System.out.println("예약 일수 : " + reservation.getReservationDays() + "일");
            System.out.println("조식 제공 여부 : " + (reservation.breakfast ? "제공" : "미제공"));
            System.out.println("총 가격 : 원");
            System.out.println("=======================");
            System.out.println("예약이 완료되었습니다.");
            reservationList.add(reservation);
        }

    }

    // 예약확인
    public static void reservationCheck() {
        System.out.println("======= 예약확인 =======");
        System.out.print("예약자명 : ");
        String reservationName = scanner.next();
    }

    // 모든 룸의 정보 보기
    public static void showAllRoom() {
        System.out.println("===================== 모든 룸의 정보 =====================");

        for (RoomReservation roomReservation : roomList) {
            System.out.println(roomReservation.showRoomInfo());
        }
    }

    // 모든 예약 확인
    public static void allReservationCheck() {
        System.out.println("========== 모든 고객의 예약 정보 ==========");
    }

}
