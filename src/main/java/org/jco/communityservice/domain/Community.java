package org.jco.communityservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Community
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ComId;
    String title;
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
}
