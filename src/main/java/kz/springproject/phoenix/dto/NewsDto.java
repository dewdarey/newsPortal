package kz.springproject.phoenix.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime publishedDate;

}
