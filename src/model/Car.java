package model;

public abstract class Car {
    protected static final int FUEL_PRICE = 2000;
    protected int speed;
    protected int efficiency;
    protected int fuelTank;
    protected int seats;
    public String name;

    Car(String name) {
        this.name = name;
    }

    // 모드 설정
    public abstract void setMode(boolean isOn);

    // 이동 횟수 계산
    public int getTripCount(int passengers) {
        return (int) Math.ceil((double) passengers / seats);
    }

    // 총 이동거리 계산
    public double getTotalDistance(int distance, int tripCount) {
        return distance * tripCount;
    }

    // 총 연료 소모량 계산
    public double getTotalFuelUsed(double totalDistance) {
        return totalDistance / efficiency;
    }

    // 총 주유 횟수 계산
    public int getRefuelCount(double fuelUsed) {
        return (int) Math.ceil(fuelUsed / fuelTank);
    }

    // 총 비용 계산
    public double getCost(double fuelUsed) {
        return fuelUsed * FUEL_PRICE;
    }

    // 이동 시간 계산
    public double getTravelTime(int distance, int tripCount, int weatherFactor) {
        double weatherValue = switch (weatherFactor) {
            case 2 -> 1.2;
            case 3 -> 1.4;
            default -> 1.0;
        };
        return (distance / (double) speed) * tripCount * weatherValue;
    }
}
