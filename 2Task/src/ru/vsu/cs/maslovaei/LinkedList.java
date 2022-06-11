package ru.vsu.cs.maslovaei;

public class LinkedList<E> {

    private LinkedListNode head = null;
    private LinkedListNode tail = null;
    private int size = 0;

    private class LinkedListNode {
        public E value;
        public LinkedListNode next;
        public LinkedListNode previous;

        public LinkedListNode(E value, LinkedListNode next, LinkedListNode previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public LinkedListNode(E value) {
            this(value, null, null);
        }
    }

    private void checkEmptyError() throws Exception {
        if (size == 0) {
            throw new IllegalStateException("Empty list");
        }
    }

    public void addFirst(E value) {
        head = new LinkedListNode(value, head, null);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E value) {
        if (size == 0) {
            head = tail = new LinkedListNode(value);
        } else {
            tail.next = new LinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    public void add(E value) {
    }

    public void addNext(E value, int index) throws Exception {
        checkEmptyError();

        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else {
            LinkedListNode actualNode = getNode(index);
            LinkedListNode newNode = new LinkedListNode (value);

            if (actualNode.next != null) {
                newNode.next = actualNode.next;
                newNode.next.previous = newNode;
            }

            actualNode.next = newNode;
            newNode.previous = actualNode;

            if (actualNode == tail) {
                tail = newNode;
            }

            size++;
        }
    }

    private LinkedListNode getNode(int index) {
        LinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws Exception {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public void removeLast() throws Exception {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) throws Exception {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            LinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) throws Exception {
        checkEmptyError();
        return getNode(index).value;
    }

    public E getFirst() throws Exception {
        checkEmptyError();
        return head.value;
    }

    public E getLast() throws Exception {
        checkEmptyError();
        return tail.value;
    }
}
