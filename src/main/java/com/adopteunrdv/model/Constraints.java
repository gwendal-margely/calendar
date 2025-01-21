package com.adopteunrdv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
public class Constraints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static ArrayList<Integer> enabledDays = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    public static int maxPerSlot = 30;
    public static long minutesBetweenSlots = 60;
    public static LocalTime start = LocalTime.of(11, 0);
    public static LocalTime end = LocalTime.of(18, 0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static ArrayList<Integer> getEnabledDays() {
        return enabledDays;
    }

    public static void setEnabledDays(ArrayList<Integer> enabledDays) {
        Constraints.enabledDays = enabledDays;
    }

    public static int getMaxPerSlot() {
        return maxPerSlot;
    }

    public static void setMaxPerSlot(int maxPerSlot) {
        Constraints.maxPerSlot = maxPerSlot;
    }

    public static long getMinutesBetweenSlots() {
        return minutesBetweenSlots;
    }

    public static void setMinutesBetweenSlots(long minutesBetweenSlots) {
        Constraints.minutesBetweenSlots = minutesBetweenSlots;
    }

    public static LocalTime getStart() {
        return start;
    }

    public static void setStart(LocalTime start) {
        Constraints.start = start;
    }

    public static LocalTime getEnd() {
        return end;
    }

    public static void setEnd(LocalTime end) {
        Constraints.end = end;
    }
}