package org.jco.communityservice.domain.dto;

import jakarta.validation.constraints.NotBlank;
import org.jco.communityservice.domain.Community;

public record CommunitySaveDto(
        @NotBlank( message = "The Community title must be defined") String title
        , @NotBlank(message = "The Community content must be defined") String content
        , String imageRoot) {

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
