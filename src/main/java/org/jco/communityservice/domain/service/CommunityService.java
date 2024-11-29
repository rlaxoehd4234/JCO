package org.jco.communityservice.domain.service;

import lombok.RequiredArgsConstructor;
import org.jco.communityservice.domain.Community;
import org.jco.communityservice.domain.dto.CommunitySaveDto;
import org.jco.communityservice.domain.exception.CommunityNotFoundException;
import org.jco.communityservice.domain.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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
