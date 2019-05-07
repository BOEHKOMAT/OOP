package com.company;

import java.util.ArrayList;

public class Container
{
    private ArrayList<Long> data = new ArrayList<>();

    public Container(int length)
    {
        for(int i = 0; i < length; i++)
        {
            data.add((long) (Math.random() * 1000));
        }
    }

    public void add(long num)
    {
        data.add(num);
    }

    public long[] toArray()
    {
        long[] arr = new long[size()];
        for(int  i = 0; i < size(); i++)
        {
            arr[i] = data.get(i);
        }
        return arr;
    }

    public int size()
    {
        return data.size();
    }

    public long min()
    {
        long min = data.get(0);
        for(int i = 1; i < size(); i++)
        {
            if(min > data.get(i))
            {
                min = data.get(i);
            }
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return min;
    }

    public long max()
    {
        long max = data.get(0);
        for(int i = 1; i < size(); i++)
        {
            if(max < data.get(i))
            {
                max = data.get(i);
            }
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return max;
    }

    public long sum()
    {
        long sum = 0;
        for(double i: data)
        {
            sum += i;
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return sum;
    }
}