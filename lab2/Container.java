package com.company;

import java.io.*;
import java.util.Iterator;

public class Container implements Serializable,Iterable<String>
{
    private String[] arr;
    private int max_length, count = 0;
    private static final long serialVersionUID = 1L;

    int getMax_length()
    {
        return max_length;
    }
    int getCount()
    {
        return arr.length;
    }

    String get(int id)
    {
        if(id >= max_length)
            return null;
        else
            return arr[id];
    }

    int get(String string)
    {
        for(int i = 0; i < max_length; i++)
        {
            if(arr[i].equals(string))
                return i;
        }
        return -1;
    }

    Container(int length)
    {
        if(length > 0)
        {
            this.max_length = length;
            arr = new String[length];
        }
        else
            throw new ExceptionInInitializerError();
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
        {
            str.append(arr[i]).append(" ");
        }
        return str.toString();
    }

    void add(String string)
    {
        if(count != max_length)
        {
            if(string != null)
            {
                arr[count++] = string;
            }
            else
            {
                throw new ExceptionInInitializerError();
            }
        }
        else
        {
            throw new ExceptionInInitializerError();
        }
    }

    void clear()
    {
        for(int i = 0; i < count; i++)
        {
            arr[i] = null;
        }
        count = 0;
    }

    boolean remove(String string)
    {
        for (int i = 0; i < count; i++)
        {
            if (arr[i].equals(string))
            {
                arr[i] = null;
                for (int j = i; j < count; j++)
                {
                    arr[j] = arr[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    String[] toArray()
    {
        String[] buffer = new String[count];
        System.arraycopy(arr,0,buffer,0,count);
        return buffer;
    }

    int size()
    {
        return count;
    }

    boolean contains(String string)
    {
        for(int i = 0; i < count; i++)
        {
            if(arr[i].equals(string))
                return true;
        }
        return false;
    }

    boolean containsAll(Container container)
    {
        boolean flag = false;
        for(int i = 0; i < container.size(); i++)
        {
            for(int j = 0; j < count; j++)
            {
                if(container.arr[i].equals(arr[i]))
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        return true;
    }

    public Iterator<String> iterator()
    {
        return new MyIterator(this, count);
    }

    int compare(int id1, int id2)
    {
        String str1 = arr[id1].toLowerCase();
        String str2 = arr[id2].toLowerCase();

        if (str1.equals(str2))
        {
            return 0;
        }
        else if (str1.length() == str2.length())
        {
            for (int i = 0; i < str1.length(); i++)
                if (str1.charAt(i) != str2.charAt(i))
                    return str1.charAt(i) - str2.charAt(i);
        }
        else
        {
            return str1.length() - str2.length();
        }
        return 0;
    }

    void bubblesort()
    {
        for(int i = 0; i < count - 1; i++)
        {
            for(int j = i + 1; j < count; j++)
                if(compare(i,j) > 0)
                {
                    String buff = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buff;
                }
        }
    }

    boolean serialize(String fileName)
    {
        FileOutputStream FOS;
        try
        {
            FOS = new FileOutputStream("F://Programs//IntelliJ IDEA 2018.3.5//Projects//Lab2//"+fileName);
        }
        catch (FileNotFoundException e)
        {
            return false;
        }
        try
        {
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(this);
            OOS.flush();
            OOS.close();
            FOS.close();
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }

    boolean deserialize(String fileName)
    {
        FileInputStream FIS;
        try
        {
            FIS = new FileInputStream("F://Programs//IntelliJ IDEA 2018.3.5//Projects//Lab2//"+fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не знайдено!");
            return false;
        }
        try
        {
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            Container buffer = (Container) OIS.readObject();
            System.out.println(buffer.toString());
            if(buffer.arr.length > this.arr.length)
            {
                System.out.println("Розмір контейнера завеликий!");
                return false;
            }
            this.arr = buffer.arr;

            return true;
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Не знайдено");
            return false;
        }
    }
}
