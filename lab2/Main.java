package com.company;

import java.util.Iterator;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Container example = null;
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.println(" _________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("| 1 - створити контейнер      | 2 - заповнити контейнер   | 3 - очистити контейнер    | 4 - відобразити контейнер | 5 - меню контейнера       | 6 - вихід                 |");
            System.out.println(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            switch (in.nextByte())
            {
                case 1:
                    System.out.print("Введіть довжину контейнера: ");
                    example = new Container(in.nextInt());
                    System.out.println("Створено.");
                    break;
                case 2:
                    if(example != null)
                    {
                        System.out.println("Введіть рядки. Напишіть '/end',щоб зупинитись.");
                        String buffer = in.nextLine();
                        while(!buffer.equals("/end"))
                        {
                            if (buffer.length() <= 0)
                            {
                                System.out.println("Введіть не пусту стрічку. Попробуйте ще раз!");
                            }
                            else
                            {
                                example.add(buffer);
                            }
                            buffer = in.nextLine();
                        }

                    }
                    else
                    {
                        System.out.println("Контейнер не створений!");
                    }
                    break;
                case 3:
                    if(example != null)
                    {
                        example.clear();
                        System.out.println("Контейнер зачищено");
                    }
                    else
                    {
                        System.out.println("Контейнер не створено");
                    }
                    break;
                case 4:
                    if(example == null)
                    {
                        System.out.println("Контейнер не створено.");
                    }
                    else if(example.getCount() == 0)
                    {
                        System.out.println("Контейнер пустий.");
                    }
                    else
                    {
                        System.out.println(example.toString());
                    }
                    break;
                case 5:
                    if(example != null)
                    {
                        loop:
                        while (true)
                        {
                            System.out.println("    _______________________________________________________________________________________________");
                            System.out.println("   | 1 - додати елемент                            | 8 - зчитати з файлу(десеріалізація)           |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            System.out.println("   | 2 - видалити елемент                          | 9 - отримати рядокпо індексу                  |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            System.out.println("   | 3 - конвертувати у масив і перебрати елементи | 10 - отримати індекс елементу                 |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            System.out.println("   | 4 - кількість елементів                       | 11 - сортувати                                |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            System.out.println("   | 5 - максимальний розмір                       | 12 - ітерування контейнеру(for each)          |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            System.out.println("   | 6 - перевірка на наявність рядка              | 13 - ітерування контейнеру(while)             |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            System.out.println("   | 7 - записати у файл(серіалізація)             | 14 - назад                                    |");
                            System.out.println("   |_______________________________________________|_______________________________________________|");
                            switch (in.nextByte())
                            {
                                case 1:
                                    in.nextLine();
                                    System.out.print("Введіть рядок: ");
                                    example.add(in.nextLine());
                                    System.out.println("Рядок додано!");
                                    break;
                                case 2:
                                    in.nextLine();
                                    System.out.print("Введіть рядок для видалення: ");
                                    if(example.remove(in.nextLine()))
                                    {
                                        System.out.println("Рядок видалено!");
                                    }
                                    else
                                    {
                                        System.out.println("Рядок не знайдено!");
                                    }
                                    break;
                                case 3:
                                    String[] buffer = example.toArray();
                                    for(String i: buffer)
                                    {
                                        System.out.print(i+", ");
                                    }
                                    System.out.println("\n");
                                    break;
                                case 4:
                                    System.out.print("Кількість елементів: "+example.getCount()+"\n");
                                    break;
                                case 5:
                                    System.out.print("Максимальний розмір: "+example.getMax_length()+"\n");
                                    break;
                                case 6:
                                    in.nextLine();
                                    System.out.print("Введіть рядок, який потрібно знайти: ");
                                    if(example.contains(in.nextLine()))
                                    {
                                        System.out.println("Рядок знайдено!");
                                    }
                                    else
                                    {
                                        System.out.println("Рядок не знайдено!");
                                    }
                                    break;
                                case 7:
                                    in.nextLine();
                                    System.out.print("Введіть назву файлу, щоб створити і заповнити його: ");
                                    if(example.serialize(in.nextLine()))
                                    {
                                        System.out.println("Файл створенно і заповнено");
                                    }
                                    else
                                    {
                                        System.out.println("Файл не створенно!");
                                    }
                                    break;
                                case 8:
                                    in.nextLine();
                                    System.out.print("Введіть назву зчитуваного файлу: ");
                                    if(example.deserialize(in.nextLine()))
                                    {
                                        System.out.println("Дані файлу зчитані");
                                    }
                                    else
                                    {
                                        System.out.println("Помилка зчитування!");
                                    }
                                    break;
                                case 9:
                                    System.out.print("Введіть індекс: ");
                                    String buffer2 = example.get(in.nextInt());
                                    if(buffer2 != null)
                                    {
                                        System.out.println("Ваш рядок: "+buffer2);
                                    }
                                    break;
                                case 10:
                                    in.nextLine();
                                    System.out.print("Введіть слово щоб отримати його індекс: ");
                                    buffer2 = in.nextLine();
                                    if(example.contains(buffer2))
                                    {
                                        System.out.println("Ваш індекс: "+example.get(buffer2));
                                    }
                                    else
                                    {
                                        System.out.println("Немає такого рядка.");
                                    }
                                    break;
                                case 11:
                                    example.bubblesort();
                                    System.out.println("Сортування завершенно");
                                    break;
                                case 12:
                                    for(String i: example.toArray())
                                    {
                                        System.out.print(i+", ");
                                    }
                                    System.out.println(" ");
                                    break;
                                case 13:
                                    Iterator<String> iterator = example.iterator();
                                    while(iterator.hasNext())
                                    {
                                        System.out.print(iterator.next()+",");
                                    }
                                    System.out.println(" ");
                                    break;
                                case 14:
                                    break loop;
                                default:
                                    System.out.println("Немає такого пункту меню.");
                                    break;
                            }
                        }
                    }
                    else System.out.println("Контейнер не створено");
                    break;
                case 6:
                    System.out.println("До зустрічі.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Немає такого пункту меню");
                    break;
            }
        }
    }
}
