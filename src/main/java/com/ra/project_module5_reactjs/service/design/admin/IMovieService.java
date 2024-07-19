package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMovieService
{
    Page<Movie> findAll(Pageable pageable);
}
