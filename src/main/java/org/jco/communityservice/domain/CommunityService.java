package org.jco.communityservice.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public int save(Community community) {
        return communityRepository.save(community).comId;
    }

    public Community delete(Long communityId) {
        communityRepository.findByComId(communityId).orElseThrow(CommunityNotFoundException::new);
        return communityRepository.deleteByComId(communityId);
    }

}
