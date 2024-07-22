package com.ra.project_module5_reactjs.service.design.general;

import com.ra.project_module5_reactjs.model.entity.Genre;
import com.ra.project_module5_reactjs.repository.IGenreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements IGenreService
{
    private final IGenreRepo genreRepo;

    @Override
    public List<Genre> getAllGenres()
    {
        return genreRepo.findAll();
    }
}
