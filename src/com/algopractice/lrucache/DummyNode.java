package com.algopractice.lrucache;

public class DummyNode<T> implements LinkedListNode<T> {

    private DoublyLinkedList<T> list;
    public DummyNode(DoublyLinkedList<T> list) {
        this.list = list;
    }


    @Override
    public boolean hasElement() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getElement() throws NullPointerException {
        throw new NullPointerException();
    }

    @Override
    public void detach() {
        return ;
    }

    @Override
    public DoublyLinkedList<T> getListReferences() {
        return list;
    }

    @Override
    public LinkedListNode<T> setPrev(LinkedListNode<T> next) {
        return next;
    }

    @Override
    public LinkedListNode<T> setNext(LinkedListNode<T> next) {
        return null;
    }

    @Override
    public LinkedListNode<T> getPrev() {
        return null;
    }

    @Override
    public LinkedListNode<T> getNext() {
        return null;
    }

    @Override
    public LinkedListNode<T> search(T value) {
        return null;
    }
}
