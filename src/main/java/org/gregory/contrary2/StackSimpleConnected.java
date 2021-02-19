package org.gregory.contrary2;

import org.gregory.standart.Element;

public class StackSimpleConnected<T> {

    private Element end;
    private int size;
    private Class clazz;

    public StackSimpleConnected(Class clazz) {
        size = 0;
        end = null;
        this.clazz = clazz;
    }

    public int size() {
        if (getEnd() == null) {
            return 0;
        }
        int count = 1;
        Element element = getEnd().getNext();
        while (element != getEnd()) {
            count++;
            element = element.getNext();
        }
        return count;
    }

    public T pop() {
        if (getEnd() == null) {
            return null;
        }
        Element topElement = null;
        if (getSize() != 1) {
            topElement = getEnd().getNext();
            getEnd().setNext(getEnd().getNext().getNext());
        } else {
            topElement = getEnd();
            setEnd(null);
        }
        decreaseSize();
        return (T) topElement.getValue();
    }

    public void push(T val) {

        if (val.getClass() != getClazz()) {
            throw new ClassCastException("Classes don't match");
        }

        if (getEnd() == null) {
            Element newElement = new Element<T>(val);
            newElement.setNext(newElement);
            setEnd(newElement);
            augmentSize();
            return;
        }
        Element newElement = new Element<T>(val, getEnd().getNext());
        getEnd().setNext(newElement);
        setEnd(newElement);
        augmentSize();
    }

    public T peek() {
        if (getEnd() == null) {
            return null;
        }
        return (T) getEnd().getNext().getValue();
    }

    public Element getEnd() {
        return end;
    }

    public void setEnd(Element end) {
        this.end = end;
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

    public Class getClazz() {
        return clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StackSimpleConnected that = (StackSimpleConnected) o;

        if (size != that.size
        || getClazz() != that.getClazz()) return false;

        Element elementThis = this.getEnd();
        Element elementThat = that.getEnd();

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