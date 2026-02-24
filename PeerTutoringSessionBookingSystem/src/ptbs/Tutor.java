package ptbs;

public class Tutor {
    private static int idCounter = 100;

    private int tutorId;
    private String tutorName;
    private String subject;
    private String email;
    private boolean available;
    private double hourlyRate;

    public Tutor(String tutorName, String subject, String email, double hourlyRate) {
        this.tutorId = ++idCounter;
        this.tutorName = tutorName;
        this.subject = subject;
        this.email = email;
        this.hourlyRate = hourlyRate;
        this.available = true; 
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

    public String getEmail() {
        return email;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void display() {
        System.out.println("Tutor ID: " + tutorId);
        System.out.println("Name: " + tutorName);
        System.out.println("Subject: " + subject);
        System.out.println("Email: " + email);
        System.out.println("Hourly Rate:  " + hourlyRate+" SR");
        System.out.println("Status: " + (available ? "Available" : "Busy"));
    }

    @Override
    public String toString() {
        return "Tutor ID: " + tutorId + " | Name: " + tutorName + " | Subject: " + subject +
               " | Email: " + email + " | Rate: SR " + hourlyRate +
               " | Status: " + (available ? "Available" : "Busy");
    }
}