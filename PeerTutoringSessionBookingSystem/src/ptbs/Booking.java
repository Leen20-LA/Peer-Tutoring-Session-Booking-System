package ptbs;

public class Booking {
    private static int idCounter = 500;

    private int bookingId;
    private String studentName;
    private String studentEmail;
    private int tutorId;
    private String tutorName;
    private String subject;
    private String bookingDate;
    private String bookingTime;

    public Booking(String studentName, String studentEmail, Tutor tutor, String bookingDate, String bookingTime) {
        this.bookingId = ++idCounter;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.tutorId = tutor.getTutorId();
        this.tutorName = tutor.getTutorName();
        this.subject = tutor.getSubject();
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public int getTutorId() {
        return tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public String getSubject() {
        return subject;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void display() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Student: " + studentName);
        System.out.println("Email: " + studentEmail);
        System.out.println("Tutor: " + tutorName + " (ID: " + tutorId + ")");
        System.out.println("Subject: " + subject);
        System.out.println("Date: " + bookingDate);
        System.out.println("Time: " + bookingTime);
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " | Student: " + studentName +
               " | Tutor: " + tutorName + " | Subject: " + subject +
               " | Date: " + bookingDate + " | Time: " + bookingTime;
    }
}