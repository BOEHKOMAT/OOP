package com.company;

import java.util.Comparator;


class BrandComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}

class YearComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        return Integer.valueOf(o1.getYearOfRelease()) - Integer.valueOf(o2.getYearOfRelease());
    }
}

class ColorComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        return o1.getColor().compareTo(o2.getColor());
    }
}

class SpeedComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        return Integer.valueOf(o1.getCharacters().getMaxSpeed()) - Integer.valueOf(o2.getCharacters().getMaxSpeed());
    }
}

class DispersalComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        if(Double.valueOf(o1.getCharacters().getDispersal()) > Double.valueOf(o2.getCharacters().getDispersal()))
        {
            return 1;
        }
        else if(Double.valueOf(o1.getCharacters().getDispersal()) > Double.valueOf(o2.getCharacters().getDispersal()))
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

class FuelInComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        if(Double.valueOf(o1.getCharacters().getFuelConIn()) > Double.valueOf(o2.getCharacters().getFuelConIn()))
        {
            return 1;
        }
        else if(Double.valueOf(o1.getCharacters().getFuelConIn()) > Double.valueOf(o2.getCharacters().getFuelConIn()))
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

class FuelOutComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        if(Double.valueOf(o1.getCharacters().getFuelConOut()) > Double.valueOf(o2.getCharacters().getFuelConOut()))
        {
            return 1;
        }
        else if(Double.valueOf(o1.getCharacters().getFuelConOut()) > Double.valueOf(o2.getCharacters().getFuelConOut()))
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

class PriceComparator implements Comparator<Car>
{
    @Override
    public int compare(Car o1, Car o2)
    {
        return Integer.valueOf(o1.getPrice()) - Integer.valueOf(o2.getPrice());
    }
}