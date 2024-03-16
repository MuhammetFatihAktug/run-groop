package org.example.rungroop.services;

import org.example.rungroop.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
