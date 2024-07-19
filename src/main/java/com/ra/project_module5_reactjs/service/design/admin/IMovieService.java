package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.dto.request.MovieRequest;
import com.ra.project_module5_reactjs.model.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface IMovieService
{
    Page<Movie> findAll(Pageable pageable);

    Movie addMovie(MovieRequest movieRequest) throws ParseException;

    void deleteMovie(Long id);

    Movie findById(Long id);

    Page<Movie> findAllByName(String title, Pageable pageable);
}
