package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.model.entity.Movie;
import com.ra.project_module5_reactjs.repository.IMovieRepo;
import com.ra.project_module5_reactjs.service.design.admin.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements IMovieService
{
    private final IMovieRepo movieRepo;

    @Override
    public Page<Movie> findAll(Pageable pageable)
    {
        return movieRepo.findAll(pageable);
    }
}
