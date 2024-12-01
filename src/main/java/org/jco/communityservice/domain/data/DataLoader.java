package org.jco.communityservice.domain.data;


import net.datafaker.Faker;
import org.jco.communityservice.domain.Community;
import org.jco.communityservice.domain.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CommunityRepository communityRepository; // JPA 리포지토리

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        List<Community> communities = new ArrayList<>();

        // 100만 건의 더미 데이터 생성
        for (int i = 0; i < 1000000; i++) {
            String title = faker.lorem().sentence();
            String content = faker.lorem().paragraph();
            Long likeCount = (long) faker.number().numberBetween(0, 1000);
            Long unlikeCount = (long) faker.number().numberBetween(0, 500);
            String writer = faker.name().fullName();
            String imageRoot = faker.name().prefix();

            // 생성자 사용
            Community community = new Community(title, content, likeCount, unlikeCount, writer, imageRoot);
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
    }
}