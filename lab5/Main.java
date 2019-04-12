package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
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
                System.out.println("| 7 - очистити базу даних               |");
                System.out.println("+---------------------------------------+");
                System.out.println("| 8 - вихід                             |");
                System.out.println("+---------------------------------------+");
                if(!auto) System.out.print("->");
                else System.out.println("\n");
                switch (scanner.nextByte())
                {
                    case 1:
                        scanner.nextLine();
                        System.out.print("Введіть назву бренду: ");
                        String string = scanner.nextLine();
                        Car bufferCar = new Car();
                        if(string.matches("\\w+"))
                        {
                            bufferCar.setBrand(string);
                            System.out.print("Бажаєте добавити детальну інформацію про машину зараз?(1 - так/2 - ні): ");
                            switch (scanner.nextInt())
                            {
                                case 1:
                                    System.out.println("Почнімо заповнення даних:");
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    scanner.nextLine();
                                    System.out.print("Рік випуску(4-цифрове число): ");
                                    String year = scanner.nextLine();
    /*рік*/                         while(!year.matches("\\d{4}"))
                                    {
                                        System.out.println("Неправильний формат! Ви використали нецифрові символи або недостатню кількість цифр!");
                                        year = scanner.nextLine();
                                    }
                                    bufferCar.setYearOfRelease(year);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print("Колір: ");
                                    String color = scanner.nextLine();
                                    while(!color.matches("\\w+"))
                                    {
    /*колір*/                           System.out.println("Неправильний формат, використовуйте лише букви!");
                                        color = scanner.nextLine();
                                    }
                                    bufferCar.setColor(color);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print("Характеристики:\n");
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print(" - максимальна швидкість: ");
                                    String speed = scanner.nextLine();
    /*швидкість*/                   while(!speed.matches("\\d+"))
                                    {
                                        System.out.println("Неправильний формат, використовуйте лише цифри!");
                                        speed = scanner.nextLine();
                                    }
                                    bufferCar.getCharacters().setMaxSpeed(speed);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print(" - розгін до 100 км/год: ");
                                    String dispersal = scanner.nextLine();
    /*розгін*/                      while(!dispersal.matches("\\d+\\.?\\d*"))
                                    {
                                        System.out.println("Неправильний формат, використовуйте цілі та дробові числа!");
                                        dispersal = scanner.nextLine();
                                    }
                                    bufferCar.getCharacters().setDispersal(dispersal);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print(" - витрата палива у місті: ");
                                    String fIN = scanner.nextLine();
    /*витрата у*/                   while(!fIN.matches("\\d+\\.?\\d*"))
                                    {
                                        System.out.println("Неправильний формат, використовуйте цілі та дробові числа!");
                                        fIN = scanner.nextLine();
                                    }
                                    bufferCar.getCharacters().setFuelConIn(fIN);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print(" - витрата палива поза містом: ");
                                    String fOUT = scanner.nextLine();
    /*витрата поза*/                while(!fOUT.matches("\\d+\\.?\\d*"))
                                    {
                                        System.out.println("Неправильний формат, використовуйте цілі та дробові числа!");
                                        fOUT = scanner.nextLine();
                                    }
                                    bufferCar.getCharacters().setFuelConOut(fOUT);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    System.out.print(" - привід(1 - передній/2 - задній/3 - повний):");
                                    int transmission = scanner.nextInt();
    /*привід*/                      while(transmission < 1 || transmission >3)
                                    {
                                        System.out.println("Неправильний формат!");
                                        transmission = scanner.nextByte();
                                    }
                                    bufferCar.getCharacters().setTransmission(transmission);
                                    ////////////////////////////////////////////////////////////////////////////////////
                                    scanner.nextLine();
                                    System.out.print("Ціна: ");
                                    String price = scanner.nextLine();
    /*ціна*/                        while(!price.matches("\\d+"))
                                    {
                                        System.out.println("Неправильний формат, використовуйте лише цифри!");
                                        price = scanner.nextLine();
                                    }
                                    bufferCar.setPrice(price);
                                    break;
                                case 2:
                                    System.out.println("Тоді заповніть інформацію пізніше через особисте меню машини!");
                                    break;
                                default:
                                    System.out.println("Некорректний ввід. Процес заповнення не відбувся, заповніть особисте меню машини");
                                    break;
                            }
                            autoshow.add(bufferCar);
                            System.out.println("Машину "+bufferCar.getBrand()+" добавлено до бази даних під індексом "+(i+1)+".");
                            i++;
                            break;
                        }
                        else
                        {
                            System.out.println("Неправильний формат!");
                        }
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
                        for (Car car1 : autoshow) {
                            System.out.println(count++ + ". " + car1.getBrand());
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
                                if(!auto) System.out.print("\t->");
                                else System.out.println("\n");
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
                                        if(!auto) System.out.print("\t\t->");
                                        else System.out.println("\n");
                                        first:
                                        while(true) {
                                            switch (scanner.nextByte()) {
                                                case 1:
                                                    scanner.nextLine();
                                                    System.out.print("\t\tВведіть нову назву бренду: ");
                                                    String newBrand = scanner.nextLine();
                                                    if (!newBrand.matches("\\w+"))
                                                    {
                                                        System.out.println("\t\tНеправильний формат, використовуйте лише букви! Виберіть пункт заново!");
                                                        break;
                                                    }
                                                    autoshow.get(id).setBrand(newBrand);
                                                    System.out.println("\t\tЗмінено!");
                                                    if(!auto) System.out.print("\t\t->");
                                                    else System.out.println("\n");
                                                    break;
                                                case 2:
                                                    scanner.nextLine();
                                                    System.out.print("\t\tВведіть новий рік випуску(4-цифрове число): ");
                                                    String newYear = scanner.nextLine();
                                                    if (!newYear.matches("\\d{4}"))
                                                    {
                                                        System.out.println("\t\tНеправильний формат! Ви використали нецифрові символи або недостатню кількість цифр! Виберіть пункт заново!");
                                                        break;
                                                    }
                                                    autoshow.get(id).setYearOfRelease(newYear);
                                                    System.out.println("\t\tЗмінено!");
                                                    if(!auto) System.out.print("\t\t->");
                                                    else System.out.println("\n");
                                                    break;
                                                case 3:
                                                    scanner.nextLine();
                                                    System.out.print("\t\tВведіть новий колір: ");
                                                    String newColor = scanner.nextLine();
                                                    if (!newColor.matches("\\w+"))
                                                    {
                                                        System.out.println("\t\tНеправильний формат, використовуйте лише букви! Виберіть пункт заново!");
                                                        break;
                                                    }
                                                    autoshow.get(id).setColor(newColor);
                                                    System.out.println("\t\tЗмінено!");
                                                    if(!auto) System.out.print("\t\t->");
                                                    else System.out.println("\n");
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
                                                        if(!auto) System.out.print("\t\t->");
                                                        else System.out.println("\n");
                                                        switch (scanner.nextInt())
                                                        {
                                                            case 1:
                                                                System.out.print("\t\tВведіть нову максимальну швидкість: ");
                                                                String newSpeed = scanner.nextLine();
                                                                if (!newSpeed.matches("\\d+"))
                                                                {
                                                                    System.out.println("\t\tНеправильний формат, використовуйте лише цифри! Виберіть пункт заново!");
                                                                    break;
                                                                }
                                                                autoshow.get(id).getCharacters().setMaxSpeed(newSpeed);
                                                                break;
                                                            case 2:
                                                                System.out.print("\t\tВведіть новий час розгону: ");
                                                                String newDispersal = scanner.nextLine();
                                                                if (!newDispersal.matches("\\d+\\.?\\d*"))
                                                                {
                                                                    System.out.println("\t\tНеправильний формат, використовуйте цілі та дробові числа! Виберіть пункт заново!");
                                                                    break;
                                                                }
                                                                autoshow.get(id).getCharacters().setDispersal(newDispersal);
                                                                break;
                                                            case 3:
                                                                System.out.print("\t\tВведіть нову витрату палива у місті: ");
                                                                String newFIN = scanner.nextLine();
                                                                if (!newFIN.matches("\\d+\\.?\\d*"))
                                                                {
                                                                    System.out.println("\t\tНеправильний формат, використовуйте цілі та дробові числа! Виберіть пункт заново!");
                                                                    break;
                                                                }
                                                                autoshow.get(id).getCharacters().setFuelConIn(newFIN);
                                                                break;
                                                            case 4:
                                                                System.out.print("\t\tВведіть нову витрату палива поза містом: ");
                                                                String newFOUT = scanner.nextLine();
                                                                if (!newFOUT.matches("\\d+\\.?\\d*"))
                                                                {
                                                                    System.out.println("\t\tНеправильний формат, використовуйте цілі та дробові числа! Виберіть пункт заново!");
                                                                    break;
                                                                }
                                                                autoshow.get(id).getCharacters().setFuelConOut(newFOUT);
                                                                break;
                                                            case 5:
                                                                System.out.print("\t\tВиберіть новий привід(1 - передній/2 - задній/3 - повний): ");
                                                                if (scanner.nextInt() > 3 || scanner.nextInt() < 1)
                                                                {
                                                                    System.out.println("\t\tНекорректний ввід! Виберіть пункт заново!");
                                                                    break;
                                                                }
                                                                else
                                                                {
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
                                                                exit3 = true;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    System.out.print("\t\tВведіть новий стан: ");
                                                    String newCondition = scanner.nextLine();
                                                    if (!newCondition.matches("\\w+"))
                                                    {
                                                        System.out.println("\t\tНеправильний формат! Виберіть пункт заново!");
                                                        break;
                                                    }
                                                    autoshow.get(id).setCondition(newCondition);
                                                    System.out.println("\t\tЗмінено!");
                                                    if(!auto) System.out.print("\t\t->");
                                                    else System.out.println("\n");
                                                    break;
                                                case 6:
                                                    System.out.print("\t\tВведіть нову ціну: ");
                                                    String newPrice = scanner.nextLine();
                                                    if (!newPrice.matches("\\d+"))
                                                    {
                                                        System.out.println("\t\tНеправильний формат! Виберіть пункт заново!");
                                                        break;
                                                    }
                                                    autoshow.get(id).setPrice(newPrice);
                                                    System.out.println("\t\tЗмінено!");
                                                    if(!auto) System.out.print("\t\t->");
                                                    else System.out.println("\n");
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
                                while (!fileName.matches("\\w+"))
                                {
                                    System.out.println("Неправильний формат!");
                                    fileName = scanner.nextLine();
                                }
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
                                System.out.print("Введіть назву файлу у форматі \"ім'я файлу.xml\": ");
                                fileName = scanner.nextLine();
                                while (!fileName.matches("\\w+\\.xml"))
                                {
                                    System.out.println("Неправильний формат!");
                                    fileName = scanner.nextLine();
                                }
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
                            catch (IOException | ClassNotFoundException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 7:
                        scanner.nextLine();
                        System.out.print("Введіть пароль: ");
                        if(scanner.nextLine().equals("delete"))
                        {
                            scanner.nextLine();
                            System.out.print("Ви дійсно хочете очистити базу даних?(y - так): ");
                            if(scanner.nextLine().equals("y"))
                            {
                                autoshow.clear();
                                System.out.println("База даних очищена!");
                                break;
                            }
                            else
                            {
                                System.out.println("Відміна дії...");
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("Невірний пароль!");
                            break;
                        }
                    case 8:
                        System.out.println("До зустрічі!");
                        System.exit(0);
                        break;
            }
        }
    }
}
