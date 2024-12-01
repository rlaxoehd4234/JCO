package org.jco.communityservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.xml.transform.Source;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int comId;
    String title;
    String content;
    //TODO : Embeded 를 이용하여 카테고리 추가 예정
    Long likeCount;
    Long unlikeCount;
    @CreatedDate
    Date enrollTime;
    @LastModifiedDate
    Date updateTime;
    //        int deleteYn
    //TODO : softDelete 관련 필드 추가 예정
    Long view;
    String writer;
    String imageRoot;

    public Community(String content, String title){
        this.content = content;
        this.title = title;
    }

    public Community(String title, String content, String imageRoot) {
        this.title = title;
        this.content = content;
        this.imageRoot = imageRoot;
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
