
package org.example.rungroop.services;

import org.example.rungroop.dto.ClubDto;
import org.example.rungroop.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto club);

    ClubDto findClubById(Long clubId);

    void updateClub(ClubDto club);
}