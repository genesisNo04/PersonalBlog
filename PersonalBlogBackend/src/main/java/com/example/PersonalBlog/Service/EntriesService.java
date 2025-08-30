package com.example.PersonalBlog.Service;

import com.example.PersonalBlog.DTO.ArticleDateDTO;
import com.example.PersonalBlog.Model.Entry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntriesService {

    List<Entry> getAllEntries();

    Entry getEntryById(Long id);

    void deleteEntry(Long id);

    Entry saveEntry(Entry entry);

    Entry updateEntry(Entry entry);

    List<ArticleDateDTO> findArticleAndDates();
}
