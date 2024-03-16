package org.example.rungroop.services.impl;

import org.example.rungroop.dto.EventDto;
import org.example.rungroop.models.Club;
import org.example.rungroop.models.Event;
import org.example.rungroop.repository.ClubRepository;
import org.example.rungroop.repository.EventRepository;
import org.example.rungroop.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .club(eventDto.getClub())
                .id(eventDto.getId())
                .name(eventDto.getName())
                .type(eventDto.getType())
                .createdOn(eventDto.getCreatedOn())
                .endTime(eventDto.getEndTime())
                .updateOn(eventDto.getUpdateOn())
                .photoUrl(eventDto.getPhotoUrl())
                .build();
    }

    private EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .club(event.getClub())
                .id(event.getId())
                .name(event.getName())
                .type(event.getType())
                .createdOn(event.getCreatedOn())
                .endTime(event.getEndTime())
                .updateOn(event.getUpdateOn())
                .photoUrl(event.getPhotoUrl())
                .build();
    }


}
