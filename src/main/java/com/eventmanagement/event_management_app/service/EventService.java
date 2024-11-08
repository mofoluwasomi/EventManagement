package com.eventmanagement.event_management_app.service;

import com.eventmanagement.event_management_app.repository.EventsRepository;
import com.eventmanagement.event_management_app.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventsRepository eventsRepository;

    public Events createEvent(Events events){
        Optional<Events> existingEvent= Optional.ofNullable(eventsRepository.findByEventName(events.getEventName()));
        if(existingEvent.isPresent()){
            throw new IllegalArgumentException("Event with name "+ events.getEventName()+"already exists ");
        }
        return eventsRepository.save(events);
    }
    public Events updateEvent(String eventId , Events updatedEvent){
       Events existingEvent = eventsRepository.findByEventId(eventId);
        if (existingEvent == null) {
            throw new IllegalArgumentException("Event not found");
        }
       if(updatedEvent.getEventName()!=null){
           existingEvent.setEventName(updatedEvent.getEventName());

       }
        if(updatedEvent.getEventStartDate()!=null){
            existingEvent.setEventStartDate(updatedEvent.getEventStartDate());

        }
        if(updatedEvent.getEventEndDate()!=null){
            existingEvent.setEventEndDate(updatedEvent.getEventEndDate());

        }
        if(updatedEvent.getEventLocation()!=null){
            existingEvent.setEventLocation(updatedEvent.getEventLocation());

        }
        if(updatedEvent.getEventDescription()!=null){
            existingEvent.setEventDescription(updatedEvent.getEventDescription());

        }
        if(updatedEvent.getMaxAttendees() != 0){
            existingEvent.setMaxAttendees(updatedEvent.getMaxAttendees());

        }
        return eventsRepository.save(existingEvent);

    }
    public void deleteEvent(String id){
        Events existingEvent = eventsRepository.findByEventId(id);
        if(existingEvent== null){
            throw  new IllegalArgumentException("Event not found");
        }
        eventsRepository.delete(existingEvent);
    }
    public Events getEvent(String id){
        Events existingEvent = eventsRepository.findByEventId(id);
        if(existingEvent==null){
            throw new IllegalArgumentException("Event not found");

        }
        return existingEvent;
    }



}
