package kz.springproject.phoenix.controller;

import kz.springproject.phoenix.model.News;
import kz.springproject.phoenix.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping(value = "{id}")
    public News getNewsById(@PathVariable(name = "id") Long id) {
        return newsService.getNewsById(id);
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.addNews(news);
    }

    @PutMapping
    public News updateNews(@RequestBody News news) {
        return newsService.updateNews(news);
    }

    @DeleteMapping(value = "{id}")
    public void deleteNews(@PathVariable(name = "id") Long id) {
        newsService.deleteNews(id);
    }

}
