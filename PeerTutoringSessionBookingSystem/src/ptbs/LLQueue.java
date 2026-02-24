package ptbs;

public class LLQueue<E> {

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
    protected Node<E> front;
    protected Node<E> rear;
    protected int size;

    public LLQueue() {
        front = null;
        rear = null;
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
        return front.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;
        } else {
            rear.setNext(newest);
        }
        rear = newest;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null;
        }
        return answer;
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int s = size();

        for (int i = 0; i < s; i++) {
            E ele = dequeue();
            System.out.println(ele);

            enqueue(ele);
        }

    }

    //  Find booking by ID
    public Booking findBookingById(int bookingId) {

        int s = size();
        Booking booking = null;
        for (int i = 0; i < s; i++) {
            Booking ele = (Booking) dequeue();
            if (ele.getBookingId() == bookingId) {
                booking = ele;
            }

            enqueue((E) ele);
        }
        return booking;

    }

    //  Count bookings by tutor ID
    public int countBookingsByTutor(int tutorId) {
        if (isEmpty()) {
            return 0;
        }

        int count = 0;
        int s = size();

        for (int i = 0; i < s; i++) {
            Booking booking = (Booking) dequeue();
            if (booking.getTutorId() == tutorId) {
                count++;
            }
            enqueue((E) booking);
        }

        return count;
    }

    //  Display next booking
    public void displayNextBooking() {
        if (isEmpty()) {
            System.out.println("No bookings in the queue.");
        } else {
            Booking booking = (Booking) first();
            System.out.println("The next booking to be processed:");
            booking.display();
        }
    }

    //  Count bookings by subject
    public int countBookingsBySubject(String subject) {
        if (isEmpty()) {
            return 0;
        }

        int count = 0;
        int s = size();

        for (int i = 0; i < s; i++) {
            Booking booking = (Booking) dequeue();
            if (booking.getSubject().equals(subject)) {
                count++;
            }
            enqueue((E) booking);
        }

        return count;
    }

    //  Display bookings by student name
    public void displayBookingsByStudent(String studentName) {
        if (isEmpty()) {
            System.out.println("No bookings in the queue.");
            return;
        }

        boolean found = false;
        int s = size();

        System.out.println("---- Bookings for Student: " + studentName + " ----");
        for (int i = 0; i < s; i++) {
            Booking booking = (Booking) dequeue();
            if (booking.getStudentName().equals(studentName)) {
                booking.display();
                System.out.println("");
                found = true;
            }
            enqueue((E) booking);
        }

        if (!found) {
            System.out.println("No bookings found for student: " + studentName);
        }
    }

    //  Find booking by student name
    public Booking findBookingByStudent(String studentName) {

        int s = size();
        Booking booking = null;
        for (int i = 0; i < s; i++) {
            Booking ele = (Booking) dequeue();
            if (ele.getStudentName().equals(studentName)) {
                booking = ele;
            }

            enqueue((E) ele);
        }
        return booking;

    }

}
