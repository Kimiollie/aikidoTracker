package org.example;

import java.time.LocalDate;

public class TrainingSession {
    private LocalDate date;
    private int duration;

    public TrainingSession(LocalDate date, int duration) {
        this.date = date;
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}
