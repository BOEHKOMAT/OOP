package com.company;

public class Character
{
    private int maxSpeed;
    private double dispersal;
    private double fuelConIn;
    private double fuelConOut;
    private String transmission;

    void setMaxSpeed(int maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }
    int getMaxSpeed()
    {
        return maxSpeed;
    }

    void setDispersal(double dispersal)
    {
        this.dispersal = dispersal;
    }
    double getDispersal()
    {
        return dispersal;
    }

    void setFuelConIn(double fuelConIn)
    {
        this.fuelConIn = fuelConIn;
    }
    double getFuelConIn()
    {
        return fuelConIn;
    }

    void setFuelConOut(double fuelConOut)
    {
        this.fuelConOut = fuelConOut;
    }
    double getFuelConOut()
    {
        return fuelConOut;
    }

    void setTransmission(int transmission) {
        switch(transmission)
        {
            case 1:
                this.transmission = "Передній";
                break;
            case 2:
                this.transmission = "Задній";
                break;
            case 3:
                this.transmission = "Повний";
                break;
        }
    }
    String getTransmission() {
        return transmission;
    }

    public String toString()
    {
        return "\t+---------------------------------------------------------+\n"
              +"\t| Максимальна швидкість: [ "+maxSpeed+" км/год ]\t\t\t\t\t  |\n"
              +"\t| Розгін до сотні: [ "+dispersal+" с ]\t\t\t\t\t\t\t  |\n"
              +"\t| Витрата палива у місті/поза містом: [ "+ fuelConIn +"/"+ fuelConOut +" л/100км ] |\n"
              +"\t| Привід: [ "+transmission+" ]\t\t\t\t\t\t\t\t\t\t  |\n"
              +"\t+---------------------------------------------------------+\n";
    }
}
