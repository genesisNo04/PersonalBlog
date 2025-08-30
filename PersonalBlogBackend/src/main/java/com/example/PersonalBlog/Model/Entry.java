package com.example.PersonalBlog.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="article_title")
    private String article;

    @Column(name="article_content")
    private String articleContent;

    @JsonFormat(pattern = "MMMM dd, yyyy")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "MMMM dd, yyyy")
    private LocalDateTime modifiedAt;

    public Entry() {
    }

    public Entry(String article, String articleContent, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.article = article;
        this.articleContent = articleContent;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
