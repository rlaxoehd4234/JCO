package org.jco.communityservice.domain;

import java.util.Optional;

public interface CommunityRepository {
    Iterable<Community> findAll();
    Optional<Community> findById(Long id);
    Community save(Community community);
    void delete(Community community);
}
