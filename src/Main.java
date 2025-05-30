import model.Bus;
import model.Car;
import model.Sedan;
import model.SportCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 이동 지역 선택
        int location;
        do {
            System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주: ");
            location = sc.nextInt();
        } while (location < 1 || location > 4);

        // 승객 수 입력
        System.out.print("이동할 승객 수 입력: ");
        int people = sc.nextInt();

        // 차량 종류 선택
        int carType;
        do {
            System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스: ");
            carType = sc.nextInt();
        } while (carType < 1 || carType > 3);

        // 부가기능
        int modeInput = 0;
        do {
            System.out.print("부가기능 [1]ON [2]OFF: ");
            modeInput = sc.nextInt();
        } while (modeInput < 1 || modeInput > 2);
        boolean mode = modeInput == 1;

        // 날씨 선택
        int weather;
        do {
            System.out.print("날씨 [1]맑음 [2]비 [3]눈: ");
            weather = sc.nextInt();
            sc.nextLine();
        } while (weather < 1 || weather > 3);

        // Car 객체 결정
        Car car = switch (carType) {
            case 1 -> new SportCar();
            case 2 -> new Sedan();
            case 3 -> new Bus();
            default -> throw new IllegalStateException("Unexpected value: " + carType); // 예외 검출
        };

        // 부가기능 여부 설정
        car.setMode(mode);

        // 선택기능 옵션 여부 설정
        car.printOption();

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
        String time = car.getTravelTime(location, trip, weather);

        System.out.println();
        System.out.println("=======" + car.name + "=======");
        System.out.printf("총 비용: %,d원\n", (int) cost);
        System.out.println("총 주유 횟수: " + refuel + "회");
        System.out.println("총 이동 시간: " + time);
    }
}
