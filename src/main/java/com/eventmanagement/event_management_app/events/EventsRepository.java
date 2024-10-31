package com.eventmanagement.event_management_app.events;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends MongoRepository<Events,String> {
         Events findByEventName(String eventName);
         Events findByEventId(String eventId);
}
