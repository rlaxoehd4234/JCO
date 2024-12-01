package org.jco.communityservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jco.communityservice.domain.Community;
import org.jco.communityservice.dto.CommunitySaveDto;
import org.jco.communityservice.exception.CommunityNotFoundException;
import org.jco.communityservice.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityService {
    private final CommunityRepository communityRepository;

    public List<Community> getCommunities() {
        return communityRepository.findAll();
    }

    public Community findById(Long id){
        return communityRepository.findByComId(id).orElseThrow(CommunityNotFoundException::new);
    }
    public int save(CommunitySaveDto communitySaveDto) {
        return communityRepository.save(CommunitySaveDto.toEntity(communitySaveDto)).getComId();
    }

    public Community delete(Long communityId) {
        communityRepository.findByComId(communityId).orElseThrow(CommunityNotFoundException::new);
        return communityRepository.deleteByComId(communityId);
    }

}
