# Peer Tutoring Session Booking System

## Description
A Java‑based console application that helps manage peer tutoring sessions. Students can book appointments with available tutors, while administrators can register tutors, view all tutors, and monitor the booking queue. The system uses **custom implementations** of a singly linked list to store tutors and a queue to handle booking requests, demonstrating fundamental data structures in action.

This project was developed as a team assignment for a university course (Data Structures / Object‑Oriented Programming).

## Technologies Used
- **Java**
- **Object‑Oriented Programming (OOP)**
- **Custom Data Structures** – SinglyLinkedList and LLQueue (generic implementations)
- **NetBeans IDE**

## Features
- **Tutor Management**  
  – Register new tutors with name, subject, email, and hourly rate.  
  – Display all registered tutors.  
  – Search for a tutor by ID, name, or subject.  
  – Remove a tutor from the system.  
  – Count tutors by subject or availability.

- **Booking Management**  
  – Book a tutoring session by selecting an available tutor and entering student details, date, and time.  
  – View the current booking queue (FIFO order).  
  – Process the next booking (dequeue) and confirm the session.  
  – Display the next waiting booking without removing it.

- **Search & Reporting**  
  – Find tutors by subject.  
  – Count bookings per tutor or per subject.  
  – Display all bookings made by a specific student.  
  – Search for a booking using a student’s name.

- **Data Structures**  
  – SinglyLinkedList<E> – stores tutors with methods like addLast, remove, and specialised search functions.  
  – LLQueue<E> – manages bookings as a queue with enqueue, dequeue, and methods to inspect/count bookings without altering the queue.

## My Contribution
  - **Designed and implemented the LLQueue class from scratch, including:**
    – Core queue operations (enqueue, dequeue, first, last).
    – Utility methods to traverse the queue without altering it (Display, findBookingById, countBookingsByTutor, countBookingsBySubject, displayBookingsByStudent, findBookingByStudent).
  - **Created the Booking class to model a booking with attributes like booking ID, student details, tutor info, subject, date, and time.**

## How to Run
1. **Clone or download** the repository.  
2. **Open the project** in NetBeans (File → Open Project… and select the `PeerTutoringSessionBookingSystem` folder).  
3. **Run the project** – click the Run button. The main class will start.  
4. **Follow the console menu** – use the numbered options to interact with the system.
