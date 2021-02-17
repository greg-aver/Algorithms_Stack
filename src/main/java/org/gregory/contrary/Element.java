package org.gregory.contrary;

public class Element<T> {
    private T value;
    private Element next;
    private Element prev;

    public Element(T value, Element<T> next) {
        this.next = next;
        this.value = value;
    }

    public Element(T value) {
        this.next = null;
        this.prev = null;
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

    public Element getPrev() {
        return prev;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }
}
