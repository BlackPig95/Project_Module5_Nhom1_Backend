package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.model.entity.Showtime;
import com.ra.project_module5_reactjs.repository.IShowtimeRepo;
import com.ra.project_module5_reactjs.service.design.admin.IShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements IShowTimeService {
    private  final IShowtimeRepo repo;
    @Override
    public List<Showtime> findShowTimeByMovieId(Long movieId) {

        return repo.findShowtimeByMovieId(movieId);
    }
}
