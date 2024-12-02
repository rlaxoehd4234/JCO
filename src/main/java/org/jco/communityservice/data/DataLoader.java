package org.jco.communityservice.data;


import co.elastic.clients.elasticsearch.core.search.Collector;
import jakarta.persistence.EntityManager;
import net.datafaker.Faker;
import org.jco.communityservice.domain.Category;
import org.jco.communityservice.domain.Community;
import org.jco.communityservice.domain.CommunityDocument;
import org.jco.communityservice.repository.CommunityDocumentRepository;
import org.jco.communityservice.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CommunityRepository communityRepository; // JPA 리포지토리
    @Autowired
    private CommunityDocumentRepository communityDocumentRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();
        List<Community> communities = new ArrayList<>();

        // 100만 건의 더미 데이터 생성
        for (int i = 0; i < 10; i++) {
            String title = faker.lorem().sentence();
            String content = faker.lorem().paragraph();
            Long likeCount = (long) faker.number().numberBetween(0, 1000);
            Long unlikeCount = (long) faker.number().numberBetween(0, 500);
            String writer = faker.name().fullName();
            String imageRoot = faker.name().prefix();
            List<Category> categories = new ArrayList<>();
            Category category = new Category(faker.gender().types(), faker.name().fullName(), (long) faker.number().numberBetween(50, 100));
            categories.add(category);
            // 생성자 사용
            Community community = new Community(title, content, likeCount, unlikeCount, writer, imageRoot, categories);
            communities.add(community);

            // 1000개 단위로 배치 저장
            if (communities.size() >= 1000) {
                communityRepository.saveAll(communities);
                communities.clear(); // List 초기화
            }
        }

        // 남은 데이터 저장
        if (!communities.isEmpty()) {
            communityRepository.saveAll(communities);
        }

        List<CommunityDocument> communityDocuments = communityRepository.findAll().stream()
                .map(Community::toDocument).toList();
        communityDocumentRepository.saveAll(communityDocuments);
    }
}