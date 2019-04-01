package com.company;

public class Character
{
    private int maxSpeed;
    private double dispersal;
    private double fuelConIn;
    private double fuelConOut;
    private String transmission;

    public void setMaxSpeed(int maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }
    public int getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setDispersal(double dispersal)
    {
        this.dispersal = dispersal;
    }
    public double getDispersal()
    {
        return dispersal;
    }

    public void setFuelConIn(double fuelConIn)
    {
        this.fuelConIn = fuelConIn;
    }
    public double getFuelConIn()
    {
        return fuelConIn;
    }

    public void setFuelConOut(double fuelConOut)
    {
        this.fuelConOut = fuelConOut;
    }
    public double getFuelConOut()
    {
        return fuelConOut;
    }

    public void setTransmission(int transmission) {
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
    public String getTransmission() {
        return transmission;
    }

    @Override
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
