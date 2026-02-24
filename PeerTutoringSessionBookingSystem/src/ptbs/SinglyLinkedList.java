package ptbs;

public class SinglyLinkedList<E> {

    //---------------------------- Nested Class Node ----------------------------------
    static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
//---------------------------------------------------------------------------
    Node<E> head;
    Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        Node<E> newest = new Node<E>(e, null);
        newest.setNext(head);
        head = newest;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<E>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public E removeLast() {

        if (size == 0) {
            return null;
        } else {
            E data = tail.getElement();
            if (size == 1) {
                head = tail = null;
            } else {
                Node temp1 = head;
                Node temp2 = null;
                while (temp1.getNext() != null) {
                    temp2 = temp1;
                    temp1 = temp1.getNext();
                }
                temp2.setNext(null);
                tail = temp2;
            }
            size--;
            return data;
        }
    }

    public void printTutors() {
        Node<E> current = head;

        while (current != null) {
            ((Tutor) current.getElement()).display();
            System.out.println("");
            current = current.getNext();
        }
    }

    public void printList() {
        Node<E> current = head;

        while (current != null) {
            System.out.println(current.element);
            System.out.println("");
            current = current.getNext();
        }
    }

    public E remove(E item) {
        if (head == null || item == null) {
            return null;
        }

        if (head.element.equals(item)) {
            E data = head.getElement();
            head = head.next;

            if (head == null) {
                tail = null;
            }
            size--;
            return data;
        }

        Node<E> current = head;
        while (current.next != null && !current.next.element.equals(item)) {
            current = current.next;
        }

        if (current.next == null) {
            return null;
        }

        E data = current.next.getElement();
        current.next = current.next.next;

        if (current.next == null) {
            tail = current;
        }
        size--;
        return data;
    }



    //  Search tutor by ID
    public Tutor searchTutorById(int tutorId) {
        Node<E> current = head;

        while (current != null) {
            Tutor tutor = (Tutor) current.element;
            if (tutor.getTutorId() == tutorId) {
                return tutor;
            }
            current = current.getNext();
        }
        return null;
    }

    //  Find tutors by subject
    public void findTutorsBySubject(String subject) {
        Node<E> current = head;
        boolean found = false;

        System.out.println("---- Tutors teaching: " + subject + " ----");
        while (current != null) {
            Tutor tutor = (Tutor) current.element;
            if (tutor.getSubject().equalsIgnoreCase(subject)) {
                tutor.display();
                System.out.println("");
                found = true;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("No tutors found teaching: " + subject);
        }
    }

    // Display available tutors only
    public void displayAvailableTutors() {
        Node<E> current = head;
        boolean found = false;

        System.out.println("---- Available Tutors ----");
        while (current != null) {
            Tutor tutor = (Tutor) current.element;
            if (tutor.isAvailable()) {
                tutor.display();
                System.out.println("");
                found = true;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("No tutors available at the moment.");
        }
    }

    // Count tutors by subject
    public int countTutorsBySubject(String subject) {
        Node<E> current = head;
        int count = 0;

        while (current != null) {
            Tutor tutor = (Tutor) current.element;
            if (tutor.getSubject().equals(subject)) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }

    //  Search tutor by name
    public Tutor searchTutorByName(String name) {
        Node<E> current = head;

        while (current != null) {
            Tutor tutor = (Tutor) current.element;
            if (tutor.getTutorName().equals(name)) {
                return tutor;
            }
            current = current.getNext();
        }
        return null;
    }

    // Count available tutors
    public int countAvailableTutors() {
        Node<E> current = head;
        int count = 0;

        while (current != null) {
            Tutor tutor = (Tutor) current.element;
            if (tutor.isAvailable()) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }

}