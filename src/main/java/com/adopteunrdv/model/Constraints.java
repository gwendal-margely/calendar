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

    // Getters and Setters
}