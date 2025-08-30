package com.example.PersonalBlog.Repository;

import com.example.PersonalBlog.DTO.ArticleDateDTO;
import com.example.PersonalBlog.Model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntriesRepository extends JpaRepository<Entry, Long> {

    @Query("SELECT new com.example.PersonalBlog.DTO.ArticleDateDTO(e.article, e.createdAt) FROM Entry e")
    List<ArticleDateDTO> findArticlesAndDates();
}
