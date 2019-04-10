package com.company;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedList<T> implements Serializable, Iterable<T>
{
    private Node first = new Node();
    private Node current;
    private Node previous = new Node();

    public LinkedList(){}

    public void add(T object)
    {
        current = first;
        while(current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(new Node());
        current.getNext().setData(object);
    }

    public boolean remove(int index)
    {
        current = first;
        if(size() != 0 && index >= 0)
        {
            for (int i = -1; i < index-1; i++)
            {
                if (current.getNext() == null)
                {
                    return false;
                }
                else
                {
                    current = current.getNext();
                }
            }
            if (current.getNext() == null)
            {
                return false;
            }
            else if (current.getNext().getNext() == null)
            {
                current.setNext(null);
                return true;
            }
            else
            {
                current.setNext(current.getNext().getNext());
                return true;
            }
        }
        else return false;
    }

    public void clear()
    {
        first = new Node();
    }

    public T[] toArray()
    {
        T[] arr = (T[]) new Object[size()];
        for(int i = 0; i < size(); i++)
        {
            arr[i] = get(i);
        }
        return arr;
    }

    public String toString()
    {
        if(size() == 0)
        {
            return "[ - ]";
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < size() - 1; i++)
        {
            buffer.append(get(i).toString()).append("\n");
        }
        buffer.append(get(size() - 1)).append("]");
        return new String(buffer);
    }

    public int size()
    {
        Node last = first;
        int count = 0;
        while(last.getNext() != null)
        {
            count++;
            last = last.getNext();
        }
        return count;
    }

    public T get(int id)
    {
        current = first;
        for(int i = -1; i < id; i++)
        {
            if(current.getNext() == null)
            {
                return  null;
            }
            else
            {
                current = current.getNext();
            }
        }
        return (T) current.getData();
    }

    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            int counter;
            {
                counter = 0;
            }
            @Override
            public boolean hasNext()
            {
                return counter < size();
            }
            @Override
            public T next()
            {
                return get(counter++);
            }
        };
    }
}