package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingSessionTest {

    @Test
    void testTrainingSessionCreation() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        int duration = 60;
        TrainingSession session = new TrainingSession(date, duration);

        assertEquals(date, session.getDate());
        assertEquals(duration, session.getDuration());
    }

    @Test
    void testGetDate() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        TrainingSession session = new TrainingSession(date, 60);

        assertEquals(date, session.getDate());
    }

    @Test
    void testGetDuration() {
        int duration = 60;
        TrainingSession session = new TrainingSession(LocalDate.of(2025, 1, 1), duration);

        assertEquals(duration, session.getDuration());
    }
}