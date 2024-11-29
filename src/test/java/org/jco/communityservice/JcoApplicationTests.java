package org.jco.communityservice;

import org.jco.communityservice.domain.Community;
import org.jco.communityservice.domain.dto.CommunitySaveDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

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

        CommunitySaveDto communitySaveDto = new CommunitySaveDto("title", "content", "testRoot");

        webTestClient.post()
                .uri("/community/save")
                .bodyValue(communitySaveDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Integer.class)
                .value(actual -> assertThat(actual).isEqualTo(1));
    }

}
