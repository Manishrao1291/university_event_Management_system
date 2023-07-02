package com.geeks.university.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    private int eventId;

    private String eventName;

    private String locationOfEvent;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
