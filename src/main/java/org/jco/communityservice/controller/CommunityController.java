package org.jco.communityservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jco.communityservice.domain.Community;
import org.jco.communityservice.dto.CommunitySaveDto;
import org.jco.communityservice.service.CommunityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("community")
public class CommunityController {
    private final CommunityService communityService;

    @GetMapping("/find/{communityId}")
    public ResponseEntity<Community> getCommunity(@PathVariable Long communityId) {
        return ResponseEntity.ok(communityService.findById(communityId));
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@Valid @RequestBody CommunitySaveDto communitySaveDto) {
        return ResponseEntity.status(201).body(communityService.save(communitySaveDto));
    }

    @DeleteMapping("/{communityId}")
    public ResponseEntity<Community> delete(@PathVariable Long communityId) {
        return ResponseEntity.status(204).body(communityService.delete(communityId));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Community>> getAll() {
        return ResponseEntity.ok(communityService.getCommunities());
    }
}
