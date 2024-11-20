package org.jco.communityservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findAll();
    Optional<Community> findByComId(Long id);
    Community save(Community community);
    Community deleteByComId(Long id);
}
