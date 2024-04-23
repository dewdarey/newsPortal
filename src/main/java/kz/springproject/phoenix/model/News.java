package kz.springproject.phoenix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_news")
@Data
public class News extends AbstractEntity {

    private String title;
    private String content;

}
