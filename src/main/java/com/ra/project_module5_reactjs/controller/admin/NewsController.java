package com.ra.project_module5_reactjs.controller.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.NewsRequest;
import com.ra.project_module5_reactjs.model.entity.News;
import com.ra.project_module5_reactjs.service.design.admin.INewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/admin/news-management")
@RequiredArgsConstructor
public class NewsController {
    private final INewsService newsService;

    @GetMapping
    public ResponseEntity<Page<News>> findAll(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "ASC") String sortDirection
    ) {
        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.fromString(sortDirection), sortField)
        );
        return ResponseEntity.ok().body(newsService.findAllNews(sortedPageable));
    }


    @GetMapping("/{newsId}")
    public ResponseEntity<?> findById(@PathVariable Long newsId) throws CustomException {
        return ResponseEntity.ok().body(newsService.findById(newsId));
    }

    @PostMapping
    public ResponseEntity<?> addNews(@ModelAttribute NewsRequest newsRequest) throws ParseException {
        return ResponseEntity.created(URI.create("/api/v1/admin/news-management")).body(newsService.addNews(newsRequest));
    }

    @PutMapping("/{newsId}")
    public ResponseEntity<?> updateNews(@PathVariable Long newsId, @Valid @ModelAttribute NewsRequest newsRequest) throws CustomException, ParseException {
        return ResponseEntity.ok(newsService.updateNews(newsRequest, newsId));
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<?> deleteNews(@PathVariable Long newsId) throws CustomException {
        newsService.deleteByIdNews(newsId);
        return ResponseEntity.ok().body("Delete successfully");
    }
}
