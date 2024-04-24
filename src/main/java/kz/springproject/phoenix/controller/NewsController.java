package kz.springproject.phoenix.controller;

import kz.springproject.phoenix.dto.NewsDto;
import kz.springproject.phoenix.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public List<NewsDto> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping(value = "{id}")
    public NewsDto getNewsById(@PathVariable(name = "id") Long id) {
        return newsService.getNewsById(id);
    }

    @PostMapping
    public NewsDto createNews(@RequestBody NewsDto news) {
        return newsService.addNews(news);
    }

    @PutMapping
    public NewsDto updateNews(@RequestBody NewsDto news) {
        return newsService.updateNews(news);
    }

    @DeleteMapping(value = "{id}")
    public void deleteNews(@PathVariable(name = "id") Long id) {
        newsService.deleteNews(id);
    }

}
