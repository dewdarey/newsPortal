package kz.springproject.phoenix.mapper;

import kz.springproject.phoenix.dto.NewsDto;
import kz.springproject.phoenix.model.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    @Mapping(source = "created", target = "publishedDate")
    NewsDto toDto(News news);

    @Mapping(source = "publishedDate", target = "created")
    News toEntity(NewsDto newsDto);

    List<NewsDto> toDtoList(List<News> newsList);

    List<News> toEntityList(List<NewsDto> newsList);

}
