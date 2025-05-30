package model;

import option.AirCon;
import option.AutoDrive;

public class Bus extends Car implements AirCon, AutoDrive {
    private boolean extraTank;

    public Bus() {
        super();
        this.name = "현대 유니버스";
        this.efficiency = 5;
        this.speed = 150;
        this.fuelTank = 100;
        this.seats = 20;
    }

    @Override
    public void setMode(boolean isOn) {
        this.extraTank = isOn;
        if (extraTank) fuelTank += 30;
    }

    @Override
    public void printOption() {
        airConOn();
        autoDriveOn();
    }

    @Override
    public void airConOn() {
        System.out.println(name + ": 에어컨 ON");
    }

    @Override
    public void autoDriveOn() {
        System.out.println(name + ": 자율주행 ON");
    }
}
