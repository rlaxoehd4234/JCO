package org.jco.communityservice;

import org.jco.communityservice.domain.Community;
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

        Community community = new Community("Content", "Title");

        webTestClient.post()
                .uri("/community/save")
                .bodyValue(community)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Integer.class)
                .value(actual -> assertThat(actual).isEqualTo(1));
    }

}
