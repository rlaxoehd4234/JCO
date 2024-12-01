package org.jco.communityservice;

import org.jco.communityservice.domain.Category;
import org.jco.communityservice.dto.CommunitySaveDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class JcoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void contextLoads() {
    }

    @Test
    void save() {

        // test 시 size validation 으로 인한 제목 15 이상, 본문 50자 이상 필수
        String title = "제목은 50자가 넘으면 안됩니다.";
        String content = "세부내용은 100자가 넘어야 합니다. 세부내용은 100자가 넘어야 합니다.세부내용은 100자가 넘어야 합니다.세부내용은 100자가 넘어야 합니다.세부내용은 100자가 넘어야 합니다.세부내용은 100자가 넘어야 합니다.세부내용은 100자가 넘어야 합니다.세부내용은 100자가 넘어야 합니다.";
        String imageRoot = "/asdfasdfasdfasdfasdfasdfasdfasdfasdf";
        List<Category> categories = new ArrayList<>();
        Category category = new Category("name","tags",0L);
        categories.add(category);

        CommunitySaveDto communitySaveDto =
                new CommunitySaveDto(
                        title
                        , content
                        , imageRoot
                        , categories);

        webTestClient.post()
                .uri("/community/save")
                .bodyValue(communitySaveDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Integer.class)
                .value(actual -> assertThat(actual).isEqualTo(10001));
    }

}
