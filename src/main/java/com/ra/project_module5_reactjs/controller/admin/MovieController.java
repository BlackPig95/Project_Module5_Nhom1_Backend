package com.ra.project_module5_reactjs.controller.admin;

import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.model.entity.Movie;
import com.ra.project_module5_reactjs.service.design.admin.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/movies")
public class MovieController
{
    private final IMovieService movieService;
    private final HttpStatus httpOk = HttpStatus.OK;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllMovies(@PageableDefault(page = 0, size = 2,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable)
    {
        Page<Movie> movies = movieService.findAll(pageable);
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các phim hiện có")
                .data(movies)
                .build();
    }
}
