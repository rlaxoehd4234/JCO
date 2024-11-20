package org.jco.communityservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findAll();
    Optional<Community> findByComId(Long id);
    Long save(Community community);
    void delete(Community community);
    void updateByComId(Long id, Community community);
}
