package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args)
    {
        boolean auto = false;
        LinkedList<Car> autoshow = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        for(String s: args)
        {
            if(s.equals("-auto"))
            {
                System.out.println("+---------------------------------------+");
                System.out.println("|          Auto mode включений          |");
                System.out.println("+---------------------------------------+");
                auto = true;
            }
        }
        if(auto){
            try {
                scanner = new Scanner(new BufferedInputStream(new FileInputStream("F:\\Programs\\IntelliJ\\projects\\lab4\\demo.txt")));
            }catch(FileNotFoundException ex){
                System.err.println("Автоматичний режим не запущено!");
                scanner = new Scanner(System.in);
            }
        }

            while(true)
            {
                if(auto)
                {
                    try
                    {
                        TimeUnit.SECONDS.sleep(2);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("+---------------------------------------+");
                System.out.println("| 1 - добавити машину до автосалону     |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 2 - оформити продаж машини            |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 3 - список машин                      |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 4 - меню машини                       |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 5 - завантажити базу даних у файл     |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 6 - зчитати дані з файлу              |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 7 - вихід                             |");
                System.out.println("+---------------------------------------+");
                System.out.print("->");
                switch (scanner.nextByte())
                {
                    case 1:
                        scanner.nextLine();
                        System.out.print("Введіть назву бренду: ");
                        Car bufferCar = new Car();
                        bufferCar.setBrand(scanner.nextLine());
                        System.out.println("Машину "+bufferCar.getBrand()+" добавлено до бази даних під індексом "+(i+1)+".");
                        System.out.print("Бажаєте добавити детальну інформацію про машину зараз?(1 - так/2 - ні): ");
                        switch (scanner.nextInt())
                        {
                            case 1:
                                System.out.println("Почнімо заповнення даних:");
                                System.out.print("Рік випуску: ");
                                bufferCar.setYearOfRelease(scanner.nextInt());
                                scanner.nextLine();
                                System.out.print("Колір: ");
                                bufferCar.setColor(scanner.nextLine());
                                System.out.print("Характеристики:\n");
                                System.out.print(" - максимальна швидкість: ");
                                bufferCar.getCharacters().setMaxSpeed(scanner.nextInt());
                                System.out.print(" - розгін: ");
                                bufferCar.getCharacters().setDispersal(scanner.nextDouble());
                                System.out.print(" - витрата палива у місті: ");
                                bufferCar.getCharacters().setFuelConIn(scanner.nextDouble());
                                System.out.print(" - витрата палива поза містом: ");
                                bufferCar.getCharacters().setFuelConOut(scanner.nextDouble());
                                System.out.print(" - привід :");
                                bufferCar.getCharacters().setTransmission(scanner.nextInt());
                                System.out.print("Ціна: ");
                                bufferCar.setPrice(scanner.nextLong());
                                break;
                            case 2:
                                System.out.println("Тоді заповніть інформацію пізніше через особисте меню машини!");
                                break;
                            default:
                                System.out.println("Некорректний ввід. Процес заповнення не відбувся, заповніть особисте меню машини");
                                break;
                        }
                        autoshow.add(bufferCar);
                        i++;
                        break;
                    case 2:
                        System.out.print("Введіть індекс машини: ");
                        int deleteID = scanner.nextInt() - 1;
                        if(autoshow.remove(deleteID))
                        {
                            System.out.println("Продано!");
                            i--;
                        }
                        else
                        {
                            System.out.println("Помилка! Мабуть такого індексу не існує! Попробуйте ще раз.");
                        }
                        break;
                    case 3:
                        if(autoshow.size() == 0)
                        {
                            System.out.println("Автосалон пустий!");
                            break;
                        }
                        int count = 1;
                        Iterator<Car> iterator = autoshow.iterator();
                        while(iterator.hasNext())
                        {
                            System.out.println(count+++". "+iterator.next().getBrand());
                        }
                        break;
                    case 4:
                        System.out.print("Введіть індекс машини: ");
                        int id = scanner.nextInt() - 1;
                        if(id > autoshow.size())
                        {
                            System.out.println("Такої машини немає!");
                        }
                        else
                        {
                            System.out.println("Машину знайдено\n");
                            System.out.println("\tВи в меню керування інформацією машини '"+autoshow.get(id).getBrand()+"'");
                            boolean exit = false;
                            while(!exit)
                            {
                                System.out.println("\t+---------------------------------------+");
                                System.out.println("\t| 1 - відобразити детальну інформацію   |");
                                System.out.println("\t+---------------------------------------+");
                                System.out.println("\t| 2 - змінити інформацію                |");
                                System.out.println("\t+---------------------------------------+");
                                System.out.println("\t| 3 - вихід з меню                      |");
                                System.out.println("\t+---------------------------------------+");
                                System.out.print("\t->");
                                switch (scanner.nextByte())
                                {
                                    case 1:
                                        System.out.println(autoshow.get(id).toString());
                                        break;
                                    case 2:
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 1 - марка                             |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 2 - рік випуску                       |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 3 - колір                             |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 4 - характеристики                    |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 5 - технічний стан                    |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 6 - ціна                              |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.println("\t\t| 7 - назад                             |");
                                        System.out.println("\t\t+---------------------------------------+");
                                        System.out.print("\t\t->");
                                        first:
                                        while(true) {
                                            switch (scanner.nextByte()) {
                                                case 1:
                                                    scanner.nextLine();
                                                    System.out.print("\t\tВведіть нову назву бренду: ");
                                                    autoshow.get(id).setBrand(scanner.nextLine());
                                                    System.out.println("\t\tЗмінено!");
                                                    System.out.print("\t\t->");
                                                    break;
                                                case 2:
                                                    scanner.nextLine();
                                                    System.out.print("\t\tВведіть новий рік випуску: ");
                                                    autoshow.get(id).setYearOfRelease(scanner.nextInt());
                                                    System.out.println("\t\tЗмінено!");
                                                    System.out.print("\t\t->");
                                                    break;
                                                case 3:
                                                    scanner.nextLine();
                                                    System.out.print("\t\tВведіть новий колір: ");
                                                    autoshow.get(id).setColor(scanner.nextLine());
                                                    System.out.println("\t\tЗмінено!");
                                                    System.out.print("\t\t->");
                                                    break;
                                                case 4:
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    System.out.println("\t\t| 1 - змінити максимальну швидкість      |");
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    System.out.println("\t\t| 2 - змінити розгін                     |");
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    System.out.println("\t\t| 3 - змінити витрату палива у місті     |");
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    System.out.println("\t\t| 4 - змінити витрату палива поза містом |");
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    System.out.println("\t\t| 5 - змінити привід                     |");
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    System.out.println("\t\t| 6 - назад                              |");
                                                    System.out.println("\t\t+----------------------------------------+");
                                                    boolean exit3 = false;
                                                    while (!exit3)
                                                    {
                                                        System.out.print("\t\t->");
                                                        switch (scanner.nextInt())
                                                        {
                                                            case 1:
                                                                System.out.print("\t\tВведіть нову максимальну швидкість: ");
                                                                autoshow.get(id).getCharacters().setMaxSpeed(scanner.nextInt());
                                                                break;
                                                            case 2:
                                                                System.out.print("\t\tВведіть новий час розгону: ");
                                                                autoshow.get(id).getCharacters().setDispersal(scanner.nextDouble());
                                                                break;
                                                            case 3:
                                                                System.out.print("\t\tВведіть нову витрату палива у місті: ");
                                                                autoshow.get(id).getCharacters().setFuelConIn(scanner.nextDouble());
                                                                break;
                                                            case 4:
                                                                System.out.print("\t\tВведіть нову витрату палива поза містом: ");
                                                                autoshow.get(id).getCharacters().setFuelConOut(scanner.nextDouble());
                                                                break;
                                                            case 5:
                                                                System.out.print("\t\tВиберіть новий привід(1 - передній/2 - задній/3 - повний): ");
                                                                if (scanner.nextInt() > 3 || scanner.nextInt() < 1)
                                                                    System.out.println("\t\tНекорректний ввід!");
                                                                else {
                                                                    int t = scanner.nextInt();
                                                                    autoshow.get(id).getCharacters().setTransmission(t);
                                                                }
                                                                break;
                                                            case 6:
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 1 - марка                             |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 2 - рік випуску                       |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 3 - колір                             |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 4 - характеристики                    |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 5 - технічний стан                    |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 6 - ціна                              |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.println("\t| 7 - назад                             |");
                                                                System.out.println("\t+---------------------------------------+");
                                                                System.out.print("\t->");
                                                                exit3 = true;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    System.out.print("\t\tВведіть новий стан: ");
                                                    autoshow.get(id).setCondition(scanner.nextLine());
                                                    System.out.println("\t\tЗмінено!");
                                                    System.out.print("\t\t->");
                                                    break;
                                                case 6:
                                                    System.out.print("\t\tВведіть нову ціну: ");
                                                    autoshow.get(id).setPrice(scanner.nextLong());
                                                    System.out.println("\t\tЗмінено!");
                                                    System.out.print("\t\t->");
                                                    break;
                                                case 7:
                                                    break first;
                                            }
                                        }
                                        break;
                                    case 3:
                                        exit = true;
                                        break;
                                }
                            }
                        }
                        break;
                    case 5:
                        System.out.println("+---------------------------------------+");
                        System.out.println("| 1 - бінарний файл | 2 - XML           |");
                        System.out.println("+---------------------------------------+");
                        String fileName, path;
                        switch (scanner.nextByte())
                        {
                            case 1:
                                scanner.nextLine();
                                System.out.print("Введіть назву файлу: ");
                                fileName = scanner.nextLine();
                                path = Choice.setDirectory(scanner) + "\\" + fileName;
                                ObjectOutputStream OOS;
                                try
                                {
                                    OOS = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
                                    OOS.writeObject(autoshow.size());
                                    for(Car car: autoshow)
                                    {
                                        OOS.writeObject(car);
                                    }
                                    OOS.flush();
                                    OOS.close();
                                    System.out.println("База даних записана!");
                                }
                                catch (NullPointerException | IOException e)
                                {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.print("Введіть назву файлу: ");
                                fileName = scanner.nextLine()+".xml";
                                path = Choice.setDirectory(scanner) + "\\" + fileName;
                                XMLEncoder encoder;
                                try
                                {
                                    encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
                                    encoder.writeObject(autoshow.size());
                                    for(Car car: autoshow)
                                    {
                                        encoder.writeObject(car);
                                    }
                                    encoder.close();
                                    System.out.println("База даних записана!");
                                }
                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                break;
                            default:
                                System.out.println("Помилка! Виберіть заново пункт запису!");
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("Вкажіть розташування файлу:");
                        scanner.nextLine();
                        String location = Choice.getDirectory(scanner);
                        int n;
                        if(location.contains(".xml"))
                        {
                            XMLDecoder decoder;
                            try
                            {
                                decoder = new XMLDecoder(new FileInputStream(location));
                                n = (int) decoder.readObject();
                                for(int j = 0; j < n; j++)
                                {
                                    autoshow.add((Car)decoder.readObject());
                                }
                                decoder.close();
                                System.out.println("База даних записана!");
                            }
                            catch (FileNotFoundException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            ObjectInputStream OIS;
                            try
                            {
                                OIS = new ObjectInputStream(new FileInputStream(location));
                                n = (int) OIS.readObject();
                                for(int j = 0; j < n; j++)
                                {
                                    autoshow.add((Car)OIS.readObject());
                                }
                                System.out.println("База даних записана!");
                            }
                            catch (FileNotFoundException e)
                            {
                                e.printStackTrace();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            catch (ClassNotFoundException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 7:
                        System.out.println("До зустрічі!");
                        System.exit(0);
                        break;
            }
        }
    }
}
