package com.example.PersonalBlog.Controller;

import com.example.PersonalBlog.DTO.ArticleDateDTO;
import com.example.PersonalBlog.Model.Entry;
import com.example.PersonalBlog.Service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntriesService entriesService;

    @GetMapping("/all")
    public List<Entry> getAllEntry() {
        return entriesService.getAllEntries();
    }

    @GetMapping("/home")
    public List<ArticleDateDTO> getAllArticleAndDates() {
        return entriesService.findArticleAndDates();
    }

    @PostMapping("/save")
    public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry) {
        entry.setCreatedAt(LocalDateTime.now());
        entry.setModifiedAt(LocalDateTime.now());

        Entry saveEntry = entriesService.saveEntry(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveEntry);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable Long id, @RequestBody Entry updatedEntry) {
        Entry currentEntry = entriesService.getEntryById(id);

        if (currentEntry == null) {
            return ResponseEntity.notFound().build();
        }

        currentEntry.setModifiedAt(LocalDateTime.now());
        currentEntry.setArticle(updatedEntry.getArticle());
        currentEntry.setArticleContent(updatedEntry.getArticleContent());

        Entry saveEntry = entriesService.saveEntry(currentEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveEntry);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Entry> deleteEntry(@PathVariable Long id) {
        Entry currentEntry = entriesService.getEntryById(id);

        if (currentEntry == null) {
            return ResponseEntity.notFound().build();
        }

        entriesService.deleteEntry(id);
        return ResponseEntity.ok(currentEntry);
    }
}
