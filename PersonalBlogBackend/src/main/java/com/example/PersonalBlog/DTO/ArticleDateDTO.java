package com.example.PersonalBlog.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ArticleDateDTO {

    private String article;
    private String date;

    public ArticleDateDTO(String article, LocalDateTime createdAt) {
        this.article = article;
        this.date = createdAt.format(DateTimeFormatter.ofPattern("MMMM dd,yyyy", Locale.ENGLISH));
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
