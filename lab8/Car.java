package com.company;

import java.io.Serializable;

public class Car implements Serializable
{
    private String brand;
    private String yearOfRelease;
    private String color;
    private String maxSpeed;
    private String price;

    public Car(){}

    public void setColor(String color)
    {
        this.color = color;
    }
    public String getColor()
    {
        return color;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getYearOfRelease()
    {
        return yearOfRelease;
    }
    public void setYearOfRelease(String yearOfRelease)
    {
        this.yearOfRelease = yearOfRelease;
    }

    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }

    public void setMaxSpeed(String maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }
    public String getMaxSpeed()
    {
        return maxSpeed;
    }

    public String toString() {
        return "\t+-------------------------------------------------------+\n" +
                "\t| Марка: " + brand + "\n" +
                "\t| Рік випуску: " + yearOfRelease + "\n" +
                "\t| Колір: " + color + "\n" +
                "\t| Максимальна швидкість: " + maxSpeed +
                "\t| Ціна: " + price + "\n" +
                "\t+-------------------------------------------------------+";
    }
}