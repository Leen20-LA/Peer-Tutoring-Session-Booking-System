package ptbs;

import java.util.Scanner;

public class PeerTutoringSystem {

    private SinglyLinkedList<Tutor> tutors;
    private LLQueue<Booking> bookings;

    private String name;
    private Scanner input;

    public PeerTutoringSystem(String name) {
        this.name = name;
        input = new Scanner(System.in);
        tutors = new SinglyLinkedList<Tutor>();
        bookings = new LLQueue<Booking>();
    }

    public void menu() {
        System.out.print("\n"
                + "1.  Register New Tutor\n"
                + "2.  Book Tutoring Session\n"
                + "3.  Display All Tutors\n"
                + "4.  Display Booking Queue\n"
                + "5.  Search Tutor by ID\n"
                + "6.  Find Tutors by Subject\n"
                + "7.  Display Available Tutors\n"
                + "8.  Process Next Booking\n"
                + "9.  Display Next Booking\n"
                + "10. Count Bookings by Tutor\n"
                + "11. Remove Tutor\n"
                + "12. Count Tutors by Subject\n"
                + "13. Search Tutor by Name\n"
                + "14. Count Available Tutors\n"
                + "15. Count Bookings by Subject\n"
                + "16. Display Bookings by Student\n"
                + "17. Find Booking by Student\n"
                + "18. Exit\n"
                + ">> ");
    }

    // 1. Register New Tutor
    public void registerTutor() {
        input.nextLine();
        System.out.println("--- Register New Tutor ---");

        System.out.print("Enter Tutor Name: ");
        String tutorName = input.nextLine();

        System.out.print("Enter Subject: ");
        String subject = input.nextLine();

        System.out.print("Enter Email: ");
        String email = input.nextLine();

        System.out.print("Enter Hourly Rate (SR): ");
        double rate = input.nextDouble();

        Tutor tutor = new Tutor(tutorName, subject, email, rate);
        tutors.addLast(tutor);

        System.out.println("Tutor registered successfully!");
        tutor.display();
    }

    // 2. Book Tutoring Session
    public void bookSession() {

        input.nextLine();
        System.out.println("\n--- Book Tutoring Session ---");

        if (tutors.isEmpty()) {
            System.out.println("No tutors available!");
            return;
        }

        displayAvailableTutors();

        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();

        System.out.print("Enter Student Email: ");
        String studentEmail = input.nextLine();

        System.out.print("Enter Tutor ID: ");
        int tutorId = input.nextInt();
        input.nextLine();

        Tutor tutor = tutors.searchTutorById(tutorId);
        if (tutor == null) {
            System.out.println("Error: Tutor not found!");
            return;
        }

        if (!tutor.isAvailable()) {
            System.out.println("Error: Tutor is currently busy!");
            return;
        }

        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        String date = input.nextLine();

        System.out.print("Enter Booking Time (HH:MM): ");
        String time = input.nextLine();

        Booking booking = new Booking(studentName, studentEmail, tutor, date, time);
        bookings.enqueue(booking);

        System.out.println("");
        System.out.println("Booking created successfully!");
        booking.display();
        System.out.println("----------------------------------");
    }

    // 3. Display All Tutors
    public void displayTutors() {
        System.out.println("");
        System.out.println("========== ALL TUTORS ==========");
        if (tutors.isEmpty()) {
            System.out.println("No tutors registered yet.");
        } else {
            tutors.printTutors();
        }
        System.out.println("=================================");
    }

    // 4. Display Booking Queue
    public void displayBookingQueue() {
        System.out.println("");
        System.out.println("========== BOOKING QUEUE ==========");
        if (bookings.isEmpty()) {
            System.out.println("No bookings in the queue.");
        } else {
            bookings.Display();
        }
        System.out.println("====================================");
    }

    // 5. Search Tutor by ID
    public void searchTutor() {

        System.out.print("Enter Tutor ID: ");
        int id = input.nextInt();

        Tutor tutor = tutors.searchTutorById(id);
        if (tutor == null) {
            System.out.println("Tutor not found!");
            return;
        }

        System.out.println("");
        System.out.println("--- Tutor Found ---");
        tutor.display();
    }

    // 6. Find Tutors by Subject
    public void findTutorsBySubject() {

      
        System.out.println("");
        System.out.print("Enter Subject: ");
        String subject = input.next();

        tutors.findTutorsBySubject(subject);
    }

    // 7. Display Available Tutors
    public void displayAvailableTutors() {
        tutors.displayAvailableTutors();
    }

    // 8. Process Next Booking
    public void processNextBooking() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings to process.");
            return;
        }

        System.out.println("--- Processing Next Booking ---");
        Booking booking = bookings.dequeue();

        System.out.println("Booking processed:");
        booking.display();
        System.out.println("Session confirmed!");
        System.out.println("------------------------------------");
    }

    // 9. Display Next Booking
    public void displayNextBooking() {
        bookings.displayNextBooking();
    }

    // 10. Count Bookings by Tutor
    public void countBookingsByTutor() {
        System.out.print("Enter Tutor ID: ");
        int tutorId = input.nextInt();

        int count = bookings.countBookingsByTutor(tutorId);
        System.out.println("Number of bookings for Tutor ID " + tutorId + ": " + count);
    }

    // 11. Remove Tutor
    public void removeTutor() {
        System.out.print("Enter Tutor ID: ");
        int id = input.nextInt();

        Tutor tutor = tutors.searchTutorById(id);
        if (tutor == null) {
            System.out.println("Tutor not found!");
            return;
        }

        tutors.remove(tutor);
        System.out.println("Tutor removed successfully!");
        System.out.println("Removed: " + tutor.getTutorName());
    }

    // 12. Count Tutors by Subject
    public void countTutorsBySubject() {
        input.nextLine();
        System.out.print("Enter Subject: ");
        String subject = input.nextLine();

        int count = tutors.countTutorsBySubject(subject);
        System.out.println("Number of tutors teaching " + subject + ": " + count);
    }

    // 13. Search Tutor by Name
    public void searchTutorByName() {
        System.out.println("");
        System.out.print("Enter Tutor Name: ");
        String name = input.nextLine();

        Tutor tutor = tutors.searchTutorByName(name);
        if (tutor == null) {
            System.out.println("Tutor not found!");
            return;
        }

        System.out.println("");
        System.out.println("--- Tutor Found ---");
        tutor.display();
    }

    // 14. Count Available Tutors
    public void countAvailableTutors() {
        int count = tutors.countAvailableTutors();
        System.out.println("");
        System.out.println("Number of available tutors: " + count);
    }

    // 15. Count Bookings by Subject
    public void countBookingsBySubject() {
        input.nextLine();
        System.out.print("Enter Subject: ");
        String subject = input.nextLine();

        int count = bookings.countBookingsBySubject(subject);
        System.out.println("Number of bookings for " + subject + ": " + count);
    }

    // 16. Display Bookings by Student
    public void displayBookingsByStudent() {
        input.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();

        bookings.displayBookingsByStudent(studentName);
    }

    // 17. Find Booking by Student
    public void findBookingByStudent() {
        input.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();

        Booking booking = bookings.findBookingByStudent(studentName);
        if (booking == null) {
            System.out.println("Booking not found!");
            return;
        }

        System.out.println("--- Booking Found ---");
        booking.display();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fillData() {

        Tutor t1 = new Tutor("Ahmed Ali", "Mathematics", "ahmed@university.edu", 50.0);
        Tutor t2 = new Tutor("Fatima Hassan", "Physics", "fatima@university.edu", 60.0);
        Tutor t3 = new Tutor("Mohammed Salem", "Computer Science", "mohammed@university.edu", 70.0);
        Tutor t4 = new Tutor("Sara Abdullah", "Chemistry", "sara@university.edu", 55.0);
        Tutor t5 = new Tutor("Omar Khalid", "Mathematics", "omar@university.edu", 50.0);

        tutors.addLast(t1);
        tutors.addLast(t2);
        tutors.addLast(t3);
        tutors.addLast(t4);
        tutors.addLast(t5);

        Booking b1 = new Booking("Layla Ibrahim", "layla@student.edu", t1, "2025-11-10", "10:00");
        Booking b2 = new Booking("Youssef Mansour", "youssef@student.edu", t3, "2025-11-11", "14:00");
        Booking b3 = new Booking("Noor Faisal", "noor@student.edu", t2, "2025-11-12", "16:00");

        bookings.enqueue(b1);
        bookings.enqueue(b2);
        bookings.enqueue(b3);

    }
}
