package com.example.UniversityEventManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_Id")
    private Integer eventId;
    private String eventName;

    @Column(name = "location_of_event")
    private String locationOfEvent;
    private String date;
    private String startTime;
    private String endTime;
}
