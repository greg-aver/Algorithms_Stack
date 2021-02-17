package org.gregory.contrary;

public class ElementDummy extends Element {

    public ElementDummy() {
        super(0);
        this.setNext(this);
        this.setPrev(this);
    }
}
