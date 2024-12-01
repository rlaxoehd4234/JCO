package org.jco.communityservice.domain.repository;

import org.jco.communityservice.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findAll();
    Optional<Community> findByComId(Long id);
    Community save(Community community);
    Community deleteByComId(Long id);
}
