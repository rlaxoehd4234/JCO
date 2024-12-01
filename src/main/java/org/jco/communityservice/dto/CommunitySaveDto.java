package org.jco.communityservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jco.communityservice.domain.Category;
import org.jco.communityservice.domain.Community;

import java.util.List;

public record CommunitySaveDto(
        @NotBlank( message = "The Community title must be defined")
        @Size( min = 15, message = "Please more typing a 15 text" ) String title
        , @NotBlank(message = "The Community content must be defined")
        @Size( min = 50, message = "Please more typing a 50 text" ) String content
        , String imageRoot
        , List<Category> categories) {

    // dto -> Entity 로 변환하는 정적 팩토리입니다.
    public static CommunitySaveDto fromEntity(Community community){
        return new CommunitySaveDto(community.getTitle(),
                community.getContent(), community.getImageRoot(), community.getCategories());
    }

    // Entity -> dto 로 변환하는 정적 팩토리 입니다.
    public static Community toEntity(CommunitySaveDto dto){
        return new Community(dto.title, dto.content, dto.imageRoot, dto.categories);
    }
}
