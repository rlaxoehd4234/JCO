package org.jco.communityservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.xml.transform.Source;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int comId;
    @Column(length = 100)
    String title;
    @Column(length = 1000)
    String content;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "community_category", joinColumns = @JoinColumn(name = "com_id"))
    List<Category> categories;

    Long likeCount;
    Long unlikeCount;
    @CreatedDate
    Date enrollTime;
    @LastModifiedDate
    Date updateTime;
    //        int deleteYn
    Long view;
    String writer;
    String imageRoot;

    public Community(String content, String title){
        this.content = content;
        this.title = title;
    }

    public Community(String title, String content, String imageRoot, List<Category> categories) {
        this.title = title;
        this.content = content;
        this.imageRoot = imageRoot;
        this.categories = categories;
    }

    public Community(String title, String content, Long likeCount, Long unlikeCount, String writer, String imageRoot) {
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
        this.unlikeCount = unlikeCount;
        this.writer = writer;
        this.imageRoot = imageRoot;
        this.view = 0L; // 기본 값 설정
    }

    public Community(String title, String content, Long likeCount, Long unlikeCount, String writer, String imageRoot, List<Category> categories) {
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
        this.unlikeCount = unlikeCount;
        this.writer = writer;
        this.imageRoot = imageRoot;
        this.categories = categories;
    }

    // PrePersist 를 활용해 likeCount, UnlikeCount 의 default 값을 설정해줍니다.
    @PrePersist
    public void setDefaultValues(){
        if(likeCount == null){
            likeCount = 0L;
        }
        if(unlikeCount == null){
            unlikeCount = 0L;
        }
    }
}
