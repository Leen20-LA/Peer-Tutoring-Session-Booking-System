package ptbs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PeerTutoringSystem pts = new PeerTutoringSystem("Peer Tutoring & Session Booking System");

        pts.fillData();

        int option = 0;
        do {
            try {

                pts.menu();
                System.out.print("Enter your choice: ");
                option = input.nextInt();

                switch (option) {

                    case 1:
                        pts.registerTutor();
                        System.out.println("");
                        break;

                    case 2:
                        pts.bookSession();
                        System.out.println("");
                        break;

                    case 3:
                        pts.displayTutors();
                        System.out.println("");
                        break;

                    case 4:
                        pts.displayBookingQueue();
                        System.out.println("");
                        break;

                    case 5:
                        pts.searchTutor();
                        System.out.println("");
                        break;

                    case 6:
                        pts.findTutorsBySubject();
                        System.out.println("");
                        break;

                    case 7:
                        pts.displayAvailableTutors();
                        System.out.println("");
                        break;

                    case 8:
                        pts.processNextBooking();
                        System.out.println("");
                        break;

                    case 9:
                        pts.displayNextBooking();
                        System.out.println("");
                        break;

                    case 10:
                        pts.countBookingsByTutor();
                        System.out.println("");
                        break;

                    case 11:
                        pts.removeTutor();
                        System.out.println("");
                        break;

                    case 12:
                        pts.countTutorsBySubject();
                        System.out.println("");
                        break;

                    case 13:
                        pts.searchTutorByName();
                        System.out.println("");
                        break;

                    case 14:
                        pts.countAvailableTutors();
                        System.out.println("");
                        break;

                    case 15:
                        pts.countBookingsBySubject();
                        System.out.println("");
                        break;

                    case 16:
                        pts.displayBookingsByStudent();
                        System.out.println("");
                        break;

                    case 17:
                        pts.findBookingByStudent();
                        System.out.println("");
                        break;

                    case 18:
                        System.out.println("Thank you for using Peer Tutoring System!");
                        System.out.println("");
                        break;

                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
                input.next();
            }
        } while (option != 18);

    }
}
