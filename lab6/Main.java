package com.company;

import java.util.Scanner;

public class Main
{
    final static int length = 1000;
    static Container example = new Container(length);
    static long[][] result = new long[2][3];

    public static void main(String[] args) throws InterruptedException
    {
        System.out.print("Встановіть ліміт часу(в секундах), після вичерпання якого програму буде завершено не зважаючи на результат: ");
        new Stop(new Scanner(System.in).nextLong() * 1000).start();

        Thread min = new Thread(() -> result[0][0] = example.min());
        Thread max = new Thread(() -> result[0][1] = example.max());
        Thread sum = new Thread(() -> result[0][2] = example.sum());

        long startTime = System.currentTimeMillis();
        min.start();
        max.start();
        sum.start();
        min.join();
        max.join();
        sum.join();
        long endTime1 = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        result[1][0] = example.min();
        result[1][1] = example.max();
        result[1][2] = example.sum();
        long endTime2 = System.currentTimeMillis() - startTime;

        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Спосіб", "Час виконання", "Мінімальне", "Максимальне", "Сума");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Паралельний", endTime1, result[0][0], result[0][1], result[0][2]);
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Послідовний", endTime2, result[1][0], result[1][1], result[1][2]);
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+");
        boolean flag = true;
        if(flag) System.exit(0);
    }
}
