package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AikidoTracker {
    private List<TrainingSession> sessions = new ArrayList<>();

    public void addSession(LocalDate date, int duration) {
        sessions.add(new TrainingSession(date, duration));
    }

    public List<TrainingSession> getSessions() {
        return sessions;
    }

    public int getTotalPracticeTime() {
        int totalPracticeTime = 0;
        for (TrainingSession session : sessions) {
            totalPracticeTime += session.getDuration();
        }
        return totalPracticeTime;
    }

    public boolean checkGraduationEligibility() {
        if (sessions.isEmpty()) { //if not yet started
            return false;
        }

        if (sessions.size() >= 100) { //if already completed 100 sessions
            return true;
        }

        //else check if 6 months have passed since the first session
        LocalDate firstSessionDate = sessions.getFirst().getDate();
        LocalDate sixMonthsAfterFirstSession = firstSessionDate.plus(6, ChronoUnit.MONTHS);
        return LocalDate.now().isAfter(sixMonthsAfterFirstSession);
    }

    public static void main(String[] args) {
        AikidoTracker tracker = new AikidoTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Aikido Practice Tracker =====");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter duration (minutes): ");
                    int duration = scanner.nextInt();
                    tracker.addSession(date, duration);
                    System.out.println("Session added.");
                    break;
                case 2:
                    System.out.println("Total Practice Time: " + tracker.getTotalPracticeTime() + " minutes");
                    break;
                case 3:
                    if (tracker.checkGraduationEligibility()) {
                        System.out.println("You are eligible for Kyu graduation.");
                    } else {
                        System.out.println("You are not eligible for Kyu graduation.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}