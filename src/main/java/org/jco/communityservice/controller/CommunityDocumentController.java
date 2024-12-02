package org.jco.communityservice.controller;

import lombok.RequiredArgsConstructor;
import org.jco.communityservice.domain.CommunityDocument;
import org.jco.communityservice.service.CommunityDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("community_document")
@RequiredArgsConstructor
public class CommunityDocumentController {
    private final CommunityDocumentService communityDocumentService;
    @GetMapping("/search_title/{title}")
    public ResponseEntity<List<CommunityDocument>> findByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(communityDocumentService.findAll(title));
    }
}
