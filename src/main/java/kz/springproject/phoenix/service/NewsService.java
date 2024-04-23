package kz.springproject.phoenix.service;

import kz.springproject.phoenix.dto.NewsDto;
import kz.springproject.phoenix.mapper.NewsMapper;
import kz.springproject.phoenix.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public List<NewsDto> getAllNews() {
        return newsMapper.toDtoList(newsRepository.findAll());
    }

    public NewsDto getNewsById(Long id) {
        return newsMapper.toDto(newsRepository.findById(id).orElse(null));
    }

    public NewsDto addNews(NewsDto news) {
        return newsMapper.toDto(newsRepository.save(newsMapper.toEntity(news)));
    }

    public NewsDto updateNews(NewsDto news) {
        return newsMapper.toDto(newsRepository.save(newsMapper.toEntity(news)));
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

}
