package model;

import option.AutoDrive;
import option.Music;

public class SportCar extends Car implements Music, AutoDrive {
    private boolean turbo;

    public SportCar(String name) {
        super(name);
        this.efficiency = 8;
        this.speed = 250;
        this.fuelTank = 30;
        this.seats = 2;
    }

    @Override
    public void setMode(boolean isOn) {
        this.turbo = isOn;
        if (turbo) speed *= 1.2;
    }

    @Override
    public void autoDriveOn() {
        System.out.println(name + ": 자율주행 ON");
    }

    @Override
    public void musicOn() {
        System.out.println(name + ": 오디오 ON");
    }
}