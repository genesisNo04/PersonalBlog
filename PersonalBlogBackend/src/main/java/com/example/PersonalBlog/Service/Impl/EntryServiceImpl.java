package com.example.PersonalBlog.Service.Impl;

import com.example.PersonalBlog.DTO.ArticleDateDTO;
import com.example.PersonalBlog.Model.Entry;
import com.example.PersonalBlog.Repository.EntriesRepository;
import com.example.PersonalBlog.Service.EntriesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntriesService {

    @Autowired
    EntriesRepository entriesRepository;

    @Override
    public List<Entry> getAllEntries() {
        return entriesRepository.findAll();
    }

    @Override
    public Entry getEntryById(Long id) {
        Entry entry = entriesRepository.findById(id).orElse(null);

        if (entry == null) {
            throw new EntityNotFoundException("No entry with id: " + id);
        }
        return entry;
    }

    @Override
    public void deleteEntry(Long id) {
        entriesRepository.deleteById(id);
    }

    @Override
    public Entry saveEntry(Entry entry) {
        return entriesRepository.save(entry);
    }

    @Override
    public Entry updateEntry(Entry entry) {
        return entriesRepository.save(entry);
    }

    @Override
    public List<ArticleDateDTO> findArticleAndDates() {
        return entriesRepository.findArticlesAndDates();
    }
}
