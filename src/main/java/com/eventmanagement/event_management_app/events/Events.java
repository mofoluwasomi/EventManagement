package com.eventmanagement.event_management_app.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document(collection = "Events")
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    @Id
    private  String eventId;
    private String eventName;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
    private String eventLocation;
    private String eventDescription;
    private int maxAttendees;



}
