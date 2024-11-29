package org.jco.communityservice.domain.dto;

import org.jco.communityservice.domain.Community;

public record CommunitySaveDto(String title, String content, String imageRoot) {

    // dto -> Entity 로 변환하는 정적 팩토리입니다.
    public static CommunitySaveDto fromEntity(Community community){
        return new CommunitySaveDto(community.getTitle(),
                community.getContent(), community.getImageRoot());
    }

    // Entity -> dto 로 변환하는 정적 팩토리 입니다.
    public static Community toEntity(CommunitySaveDto dto){
        return new Community(dto.title, dto.content, dto.imageRoot);
    }
}
