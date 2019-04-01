package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Car> autoshow = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(true)
        {

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
                    autoshow.add(i,bufferCar);
                    System.out.println("Машину "+bufferCar.getBrand()+" добавлено до бази даних під індексом "+(i+1)+".");
                    System.out.print("Бажаєте добавити детальну інформацію про машину зараз?(1 - так/2 - ні): ");
                    switch (scanner.nextInt())
                    {
                        case 1:
                            System.out.println("Почнімо заповнення даних:");
                            System.out.print("Рік випуску: ");
                            autoshow.get(i).setYearOfRelease(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Колір: ");
                            autoshow.get(i).setColor(scanner.nextLine());
                            System.out.print("Характеристики:\n");
                            System.out.print(" - максимальна швидкість: ");
                            autoshow.get(i).getCharacters().setMaxSpeed(scanner.nextInt());
                            System.out.print(" - розгін: ");
                            autoshow.get(i).getCharacters().setDispersal(scanner.nextDouble());
                            System.out.print(" - витрата палива у місті: ");
                            autoshow.get(i).getCharacters().setFuelConIn(scanner.nextDouble());
                            System.out.print(" - витрата палива поза містом: ");
                            autoshow.get(i).getCharacters().setFuelConOut(scanner.nextDouble());
                            System.out.print(" - привід :");
                            autoshow.get(i).getCharacters().setTransmission(scanner.nextInt());
                            System.out.print("Ціна: ");
                            autoshow.get(i).setPrice(scanner.nextLong());
                            break;
                        case 2:
                            System.out.println("Тоді заповніть інформацію пізніше через особисте меню машини!");
                            break;
                        default:
                            System.out.println("Некорректний ввід. Процес заповнення не відбувся, заповніть особисте меню машини");
                            break;
                    }
                    i++;
                    break;
                case 2:
                    System.out.print("Вкажіть індекс машини,яку потрібно продати: ");
                    int deleteID = scanner.nextInt() - 1;
                    if(deleteID < 0 || deleteID > autoshow.size())
                        System.out.println("Такого індексу не існує! Попробуйте ще раз.");
                    else
                        autoshow.remove(deleteID);
                    break;
                case 3:
                    int count = 1;
                    for(Car car: autoshow)
                        System.out.println(count+++". "+car.getBrand());
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
                    scanner.nextLine();
                    System.out.print("Введіть назву файлу: ");
                    StringBuilder fileName = new StringBuilder(scanner.nextLine()).append(".xml");
                    System.out.println("Виберіть директорію:");
                    String directory = Choice.setDirectory(scanner)+"\\"+fileName;
                    try
                    {
                        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(directory)));
                        encoder.writeObject(autoshow);
                        encoder.close();
                        System.out.println("База даних записана!");
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("Помилка!");
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Вкажіть розташування файлу:");
                    scanner.nextLine();
                    String location = Choice.getDirectory(scanner);
                    try
                    {
                        XMLDecoder decoder = new XMLDecoder(new FileInputStream(location));
                        autoshow = (ArrayList<Car>) decoder.readObject();
                        decoder.close();
                        System.out.println("База даних завантажена!");
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("Помилка!");
                        e.printStackTrace();
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
