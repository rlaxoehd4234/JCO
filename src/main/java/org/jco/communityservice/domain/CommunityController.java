package org.jco.communityservice.domain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Integer> save(@Valid @RequestBody Community community) {
        return ResponseEntity.status(201).body(communityService.save(community));
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
