package org.gregory.standart;

import org.gregory.contrary.Element;

public class Stack<T> {

    private Element top;
    private int size;

    public Stack()
    {
        size = 0;
        top = null;
    }

    public int size()
    {
        int count = 0;
        Element element = top;
        while (element != null) {
            count++;
            element = element.getNext();
        }
        return count;
    }

    public T pop()
    {
        if (getTop() == null) {
            return null;
        }

        Element topElement = getTop();
        top = getTop().getNext();
        decreaseSize();
        return (T) topElement.getValue();
    }

    public void push(T val)
    {
        Element<T> newElement = new Element<T>(val, getTop());
        setTop(newElement);
        augmentSize();
    }

    public T peek()
    {
        if (getTop() == null) {
            return null;
        }

        return (T) getTop().getValue(); // если стек пустой
    }

    public Element getTop() {
        return top;
    }

    public void setTop(Element top) {
        this.top = top;
    }

    public void augmentSize() {
        size++;
    }

    public void decreaseSize() {
        size--;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stack<?> that = (Stack<?>) o;

        if (size != that.size) return false;

        Element elementThis = this.getTop();
        Element elementThat = that.getTop();

        while (elementThat != null && elementThis != null) {
            if (!elementThat.getValue().equals(elementThis.getValue())) {
                return false;
            }
            elementThat = elementThat.getNext();
            elementThis = elementThis.getNext();
        }

        return true;
    }
}
