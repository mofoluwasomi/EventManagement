package com.eventmanagement.event_management_app.controller;

import com.eventmanagement.event_management_app.model.Events;
import com.eventmanagement.event_management_app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<String> createEvent( @RequestBody Events events){
        try {
            eventService.createEvent(events);
            return new ResponseEntity<>("Event has been created successfully", HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
    @PutMapping("/update/{eventId}")
    public ResponseEntity<Events> updateEvent(@PathVariable String eventId , @RequestBody Events updateEvents){
        Events event = eventService.updateEvent(eventId,updateEvents);
        return ResponseEntity.ok(event);
    }
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("API is working");
    }
    @DeleteMapping("/{eventId}")
    public  ResponseEntity<String> deleteEvent(@PathVariable  String eventId){
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event has been deleted");
    }
    @PostMapping("/{eventId}")
    public ResponseEntity<Events> getEvent(@PathVariable String eventId){
        Events event = eventService.getEvent(eventId);
        return  ResponseEntity.ok(event);
    }



}
