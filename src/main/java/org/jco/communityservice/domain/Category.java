package org.jco.communityservice.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Category {
    private String name;
    private String tags;
    private Long viewCount;

    public Category(String name, String tags, Long viewCount) {
        this.name = name;
        this.tags = tags;
        this.viewCount = viewCount;
    }
}
