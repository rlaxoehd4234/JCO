package org.jco.communityservice;

import org.jco.communityservice.domain.Community;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CommunityJsonTests {

    @Autowired
    private JacksonTester<Community> json;

    @Test
    void testSerialize() throws Exception {
        var community = new Community("content", "title");
        var jsonContent = json.write(community);
        assertThat(jsonContent).extractingJsonPathStringValue("@.content").isEqualTo("content");
        assertThat(jsonContent).extractingJsonPathStringValue("@.title").isEqualTo("title");
    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
                    "title": "title",
                    "content": "content"
                }
                """;
        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(new Community("content", "title"));
    }
}
