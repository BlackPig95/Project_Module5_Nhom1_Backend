package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.config.FileService;
import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.NewsRequest;
import com.ra.project_module5_reactjs.model.entity.News;
import com.ra.project_module5_reactjs.repository.INewsRepository;
import com.ra.project_module5_reactjs.service.design.admin.INewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements INewsService {
    private final INewsRepository newsRepo;
    private final FileService fileService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Page<News> findAllNews(Pageable pageable) {
        return newsRepo.findAll(pageable);
    }

    @Override
    public News findById(Long findId) throws CustomException {
        return newsRepo.findById(findId)
                .orElseThrow(() -> new CustomException("News not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public News addNews(NewsRequest newsRequest) throws ParseException {
        News news = toEntity(newsRequest);

        return newsRepo.save(news);
    }

    @Override
    public News updateNews(NewsRequest newsRequest, Long updateId) throws CustomException, ParseException {
        News newsUpdate = findById(updateId);
        newsUpdate.setContent(newsRequest.getContent());
        newsUpdate.setTitle(newsRequest.getTitle());
        newsUpdate.setImageUrl(newsRequest.getImageUrl() != null ? fileService.uploadFileToServer(newsRequest.getImageUrl()) : newsUpdate.getImageUrl());
        newsUpdate.setCreatedAt(sdf.parse(newsRequest.getCreatedAt()));
        newsUpdate.setUpdatedAt(sdf.parse(newsRequest.getUpdatedAt()));



        return newsRepo.save(newsUpdate);
    }

    @Override
    public void deleteByIdNews(Long deleteId) throws CustomException {
        if (newsRepo.existsById(deleteId)) {
            newsRepo.deleteById(deleteId);
        } else {
            throw new CustomException("News not found", HttpStatus.NOT_FOUND);
        }
    }

    private News toEntity(NewsRequest newsRequest) throws ParseException {
      return News.builder()
              .content(newsRequest.getContent())
              .title(newsRequest.getTitle())
              .imageUrl(fileService.uploadFileToServer(newsRequest.getImageUrl()))
              .createdAt(sdf.parse(newsRequest.getCreatedAt()))
              .updatedAt(sdf.parse(newsRequest.getUpdatedAt())).build();
    }




}
