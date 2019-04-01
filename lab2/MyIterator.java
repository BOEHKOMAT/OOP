package com.company;

import java.util.Iterator;

public class MyIterator implements Iterator
{
    Container container;
    int length;
    int current = 0;

    MyIterator(Container container, int length)
    {
        this.container = container;
        this.length = length;
    }

    public String next()
    {
        return container.get(current++);
    }

    public boolean hasNext()
    {
        return (current < length);
    }

    public void remove()
    {
        container.remove(container.get(--current));
    }
}
