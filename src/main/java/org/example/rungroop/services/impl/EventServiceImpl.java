package org.example.rungroop.services.impl;

import org.example.rungroop.dto.EventDto;
import org.example.rungroop.mapper.EventMapper;
import org.example.rungroop.models.Club;
import org.example.rungroop.models.Event;
import org.example.rungroop.repository.ClubRepository;
import org.example.rungroop.repository.EventRepository;
import org.example.rungroop.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.rungroop.mapper.EventMapper.mapToEvent;
import static org.example.rungroop.mapper.EventMapper.mapToEventDto;

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

    @Override
    public List<EventDto> findAllEvents() {
        return eventRepository.findAll().stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventID) {
        return mapToEventDto(eventRepository.findById(eventID).get());
    }


}
