package org.example.rungroop.services;

import org.example.rungroop.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllEvents();

    EventDto findByEventId(Long eventID);

    void updateEvent(EventDto event);

    void deleteEvent(Long eventId);
}
