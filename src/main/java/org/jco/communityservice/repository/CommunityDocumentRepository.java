package org.jco.communityservice.repository;

import org.jco.communityservice.domain.CommunityDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityDocumentRepository extends ElasticsearchRepository<CommunityDocument, String> {
    List<CommunityDocument> findByTitle(String title);
}
