package org.jco.communityservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.transform.Source;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int comId;
    @NotBlank( message = "The Community title must be defined")
    String title;
    @NotBlank(message = "The Community content must be defined")
    String content;
    //category 추가 예정 -> jpa 의존성 추가 후
    Long likeCount;
    Long unlikeCount;
    Date enrollTime;
    Date updateTime;
    //        int deleteYn
    Long view;
    String writer;
    String image_root;
    public Community(String content, String title){
        this.content = content;
        this.title = title;
    }

}
