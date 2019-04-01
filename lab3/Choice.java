package com.company;

import java.io.File;
import java.util.Scanner;

class Choice
{
    static String setDirectory(Scanner scanner)
    {
        String directory = "F:\\";
        String choice;
        while(true)
        {
            System.out.println("+---------------------+");
            File dir = new File(directory);
            if(dir.isDirectory())
            {
                for(File i: dir.listFiles())
                {
                    System.out.println(i.getName());
                }
            }
            else
            {
                System.out.println("Директорія не існує, виберіть ще раз!");
            }
            System.out.println("Виберіть директорію. Якщо це потрібна директорія введіть '/end'!\n Щоб повернутися назад введіть '/back!'");
            choice = scanner.nextLine();
            if(choice.equals("/end"))
            {
                return directory;
            }
            else if(choice.equals("/back"))
            {
                directory = dir.getParent();
            }
            else
            {
                directory += "\\" + choice;
            }
        }
    }

    static String getDirectory(Scanner scanner)
    {
        String directory = "F:\\";
        String choice;
        while(true)
        {
            File dir = new File(directory);
            if(dir.isDirectory())
            {
                for(File i: dir.listFiles())
                {
                    if(i.isDirectory() || i.getName().contains(".xml"))
                    {
                        System.out.println(i.getName());
                    }
                }
            }
            else if(dir.getName().contains(".xml") || dir.isFile())
            {
                return directory;
            }
            else
            {
                System.out.println("Дерикторія не існує!");
            }
            System.out.println("Виберіть директорію, а в ній файл. Щоб повернутися назад введіть '/back'!");
            choice = scanner.nextLine();
            if(choice.equals("/back"))
            {
                directory = dir.getParent();
            }
            else
            {
                directory += "\\" + choice;
            }
        }
    }
}
