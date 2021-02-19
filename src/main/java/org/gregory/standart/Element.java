package org.gregory.standart;

public class Element<T> {
    private T value;
    private Element next;

    public Element(T value, Element next) {
        this.next = next;
        this.value = value;
    }

    public Element(T value) {
        this.next = null;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
