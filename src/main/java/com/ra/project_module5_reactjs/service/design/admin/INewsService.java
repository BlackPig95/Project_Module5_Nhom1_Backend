package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.request.NewsRequest;
import com.ra.project_module5_reactjs.model.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface INewsService {
    Page<News> findAllNews(Pageable pageable);
    News findById(Long findId) throws CustomException;
    News addNews(NewsRequest newsRequest) throws ParseException;
    News updateNews(NewsRequest newsRequest, Long updateId) throws CustomException, ParseException;
    void deleteByIdNews(Long deleteId) throws CustomException;
}
