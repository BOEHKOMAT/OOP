package com.company;

public class Stop extends Thread
{
    private long limit;

    public Stop(long limit)
    {
        this.limit = limit;
    }

    public void run()
    {
        long start = System.currentTimeMillis();
        while(limit > System.currentTimeMillis() - start)
        {
            try
            {
                sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Час вийшов! Завершення програми!");
        System.exit(0);
    }
}