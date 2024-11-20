package org.jco.communityservice.domain;

import java.util.Date;

public record Community(
        Long ComId,
        String title,
        String content,
        //category 추가 예정 -> jpa 의존성 추가 후
        Long likeCount,
        Long unlikeCount,
        Date enrollTime,
        Date updateTime,
//        int deleteYn
        Long view,
        String writer,
        String image_root
)
{}
