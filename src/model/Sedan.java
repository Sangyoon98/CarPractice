package model;

import option.AirCon;
import option.Music;

public class Sedan extends Car implements AirCon, Music {
    private boolean trunkSet;

    public Sedan() {
        super();
        this.name = "그랜저";
        this.efficiency = 12;
        this.speed = 200;
        this.fuelTank = 45;
        this.seats = 4;
    }

    @Override
    public void setMode(boolean isOn) {
        this.trunkSet = isOn;
        if (trunkSet) seats += 1;
    }

    @Override
    public void printOption() {
        airConOn();
        musicOn();
    }

    @Override
    public void airConOn() {
        System.out.println(name + ": 에어컨 ON");
    }

    @Override
    public void musicOn() {
        System.out.println(name + ": 오디오 ON");
    }
}