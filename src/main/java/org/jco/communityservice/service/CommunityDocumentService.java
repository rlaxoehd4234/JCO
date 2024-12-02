package org.jco.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.jco.communityservice.domain.CommunityDocument;
import org.jco.communityservice.repository.CommunityDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityDocumentService {
    private final CommunityDocumentRepository communityDocumentRepository;

    public List<CommunityDocument> findAll(String title) {
        return communityDocumentRepository.findByTitle(title);
    }
}
