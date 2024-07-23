package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.entity.Showtime;

import java.util.List;

public interface IShowTimeService {

    List<Showtime> findShowTimeByMovieId(Long movieId);
}
