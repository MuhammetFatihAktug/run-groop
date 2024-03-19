package org.example.rungroop.services.impl;

import org.example.rungroop.dto.ClubDto;
import org.example.rungroop.mapper.ClubMapper;
import org.example.rungroop.models.Club;
import org.example.rungroop.models.UserEntity;
import org.example.rungroop.repository.ClubRepository;
import org.example.rungroop.repository.UserRepository;
import org.example.rungroop.security.SecurityUtil;
import org.example.rungroop.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.rungroop.mapper.ClubMapper.mapToClub;
import static org.example.rungroop.mapper.ClubMapper.mapToClubDto;

@Service

public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;
    private final UserRepository userRepository;


    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository,
                           UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        UserEntity user = userRepository.findByUsername(SecurityUtil.getSessionUser());
        Club club1 = mapToClub(clubDto);
        club1.setCreatedBy(user);

        return clubRepository.save(club1);
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {

        UserEntity user = userRepository.findByUsername(SecurityUtil.getSessionUser());
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        clubRepository.save(club);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        return clubRepository.searchClubs(query).stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());
    }


}