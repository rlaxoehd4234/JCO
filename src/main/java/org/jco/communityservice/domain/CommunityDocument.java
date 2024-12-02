package org.jco.communityservice.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "community_document")
@NoArgsConstructor
public class CommunityDocument {
    @Id
    private int id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String content;
    @Field(type = FieldType.Text)
    private String writer;;
    @Field(type = FieldType.Integer)
    private Long likeCount;
    @Field(type = FieldType.Integer)
    private Long unlikeCount;


    public CommunityDocument(int comId, String title, String content, String writer, Long likeCount, Long unlikeCount) {
        this.id = comId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.likeCount = likeCount;
        this.unlikeCount = unlikeCount;
    }
}
