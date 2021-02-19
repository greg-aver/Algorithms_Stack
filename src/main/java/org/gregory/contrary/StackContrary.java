package org.gregory.contrary;

public class StackContrary<T> {

    private ElementDummy elementDummy;
    private int size;
    private Class clazz;

    public StackContrary(Class clazz) {
        size = 0;
        elementDummy = new ElementDummy();
        this.clazz = clazz;
    }

    public int size() {
        int count = 0;
        Element element = getElementDummy().getNext();
        while (element != getElementDummy()) {
            count++;
            element = element.getNext();
        }
        return count;
    }

    public T pop() {
        if (getSize() == 0) {
            return null;
        }

        Element topElement = getElementDummy().getNext();
        getElementDummy().getNext().getNext().setPrev(getElementDummy());
        getElementDummy().setNext(getElementDummy().getNext().getNext());
        decreaseSize();

        return (T) topElement.getValue();
    }

    public void push(T val) {
        if (val.getClass() != getClazz()) {
            throw new ClassCastException("Classes don't match");
        }
        Element<T> newElement = new Element<T>(val);
        getElementDummy().getPrev().setNext(newElement);
        newElement.setNext(getElementDummy());
        newElement.setPrev(getElementDummy().getPrev());
        getElementDummy().setPrev(newElement);
        augmentSize();
    }

    public T peek() {
        if (getSize() == 0) {
            return null;
        }
        return (T) getElementDummy().getNext().getValue();
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

        StackContrary that = (StackContrary) o;

        Element nodeThis = this.getElementDummy().getNext();
        Element nodeThat = that.getElementDummy().getNext();

        if (that.getSize() != this.getSize()) {
            return false;
        }

        while (nodeThat != that.getElementDummy() && nodeThis != this.getElementDummy()) {
            if (!nodeThat.getValue().equals(nodeThis.getValue())) {
                return false;
            }
            nodeThat = nodeThat.getNext();
            nodeThis = nodeThis.getNext();
        }

        nodeThat = that.getElementDummy().getPrev();
        nodeThis = this.getElementDummy().getPrev();

        while (nodeThat != that.getElementDummy() && nodeThis != this.getElementDummy()) {
            if (!nodeThat.getValue().equals(nodeThis.getValue())) {
                return false;
            }
            nodeThat = nodeThat.getPrev();
            nodeThis = nodeThis.getPrev();
        }
        return true;
    }

    public ElementDummy getElementDummy() {
        return elementDummy;
    }

}
