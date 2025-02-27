package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AikidoTrackerTest {
    private AikidoTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new AikidoTracker();
    }

    @Test
    void testAddSession() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        tracker.addSession(date, 60);
        assertNotNull(tracker.getSessions());
    }

    @Test
    void testGetTotalPracticeTime() {
        tracker.addSession(LocalDate.of(2025, 1, 1), 60);
        tracker.addSession(LocalDate.of(2025, 1, 2), 30);
        assertEquals(90, tracker.getTotalPracticeTime());
    }

    @Test
    void testCheckGraduationEligibility_NoSessions() {
        assertFalse(tracker.checkGraduationEligibility());
    }

    @Test
    void testCheckGraduationEligibility_100Sessions() {
        for (int i = 0; i < 100; i++) {
            tracker.addSession(LocalDate.of(2025, 1, 1), 60);
        }
        assertTrue(tracker.checkGraduationEligibility());
    }

    @Test
    void testCheckGraduationEligibility_SixMonthsAfterFirstSession() {
        tracker.addSession(LocalDate.now().minusMonths(7), 60);
        assertTrue(tracker.checkGraduationEligibility());
    }

    @Test
    void testCheckGraduationEligibility_BeforeSixMonths() {
        tracker.addSession(LocalDate.now().minusMonths(5), 60);
        assertFalse(tracker.checkGraduationEligibility());
    }
}