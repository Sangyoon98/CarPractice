import model.Bus;
import model.Car;
import model.Sedan;
import model.SportCar;
import option.AirCon;
import option.AutoDrive;
import option.Music;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 이동 지역 선택
        System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주: ");
        int location = sc.nextInt();

        // 승객 수 입력
        System.out.print("이동할 승객 수 입력: ");
        int people = sc.nextInt();

        // 차량 종류 선택
        System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스: ");
        int carType = sc.nextInt();

        // 부가기능
        System.out.print("부가기능 [1]ON [2]OFF: ");
        boolean mode = sc.nextInt() == 1;

        // 날씨 선택
        System.out.print("날씨 [1]맑음 [2]비 [3]눈: ");
        int weather = sc.nextInt();
        sc.nextLine();

        // 차량 이름 입력
        System.out.print("차량 이름 입력: ");
        String carName = sc.nextLine();

        // Car 객체 결정
        Car car = switch (carType) {
            case 1 -> new SportCar(carName);
            case 2 -> new Sedan(carName);
            case 3 -> new Bus(carName);
            default -> throw new IllegalStateException("Unexpected value: " + carType); // 예외 검출
        };

        // 부가기능 여부 설정
        car.setMode(mode);

        // 선택기능 옵션 여부 설정
        if (car instanceof Music music) music.musicOn();
        if (car instanceof AirCon airCon) airCon.airConOn();
        if (car instanceof AutoDrive autoDrive) autoDrive.autoDriveOn();

        // 이동 횟수
        int trip = car.getTripCount(people);
        // 총 이동거리
        double totalDist = car.getTotalDistance(location, trip);
        // 총 연료 소모량
        double fuelUsed = car.getTotalFuelUsed(totalDist);
        //총 주유 횟수
        int refuel = car.getRefuelCount(fuelUsed);
        // 총 비용
        double cost = car.getCost(fuelUsed);
        // 이동 시간
        double time = car.getTravelTime(location, trip, weather);

        System.out.println("=======" + car.name + "=======");
        System.out.printf("총 비용: %,d원%n", (int) cost);
        System.out.println("총 주유 횟수: " + refuel + "회");
        System.out.printf("총 이동 시간: %.1f시간%n", time);
    }
}
