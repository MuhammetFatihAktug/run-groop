package org.example.rungroop.mapper;

import org.example.rungroop.dto.ClubDto;
import org.example.rungroop.models.Club;

import java.util.stream.Collectors;

import static org.example.rungroop.mapper.EventMapper.mapToEventDto;

public class ClubMapper {

    public static Club mapToClub(ClubDto club) {
        return Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }

    public static ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map(EventMapper::mapToEventDto).collect(Collectors.toList()))
                .build();

    }
}
