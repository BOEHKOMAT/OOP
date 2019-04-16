package com.company;

public class Character
{
    private String maxSpeed;
    private String dispersal;
    private String fuelConIn;
    private String fuelConOut;
    private String transmission;

    public void setMaxSpeed(String maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }
    public String getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setDispersal(String dispersal)
    {
        this.dispersal = dispersal;
    }
    public String getDispersal()
    {
        return dispersal;
    }

    public void setFuelConIn(String fuelConIn)
    {
        this.fuelConIn = fuelConIn;
    }
    public String getFuelConIn()
    {
        return fuelConIn;
    }

    public void setFuelConOut(String fuelConOut)
    {
        this.fuelConOut = fuelConOut;
    }
    public String getFuelConOut()
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