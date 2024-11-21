package org.jco.communityservice.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CommunityControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getCommunity() {
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



    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}