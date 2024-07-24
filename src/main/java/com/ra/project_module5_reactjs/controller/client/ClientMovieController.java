package com.ra.project_module5_reactjs.controller.client;

import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.model.entity.Movie;
import com.ra.project_module5_reactjs.service.design.admin.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class ClientMovieController
{
    private final IMovieService movieService;
    private final HttpStatus httpOk = HttpStatus.OK;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllMovies()
    {
        List<Movie> movies = movieService.getAllMovies();
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các phim hiện có")
                .data(movies)
                .build();
    }

    @GetMapping("/hot")
    public CustomResponseEntity<?> findHotMovies()
    {
        List<Movie> movies = movieService.findHotMovies();
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách phim có lượt đặt vé nhiều")
                .data(movies)
                .build();
    }

    @GetMapping("/search")
    public CustomResponseEntity<?> searchMovies(
            @RequestParam(value = "searchValue", defaultValue = "") String searchValue,
            @RequestParam(value = "searchOption", defaultValue = "title") String searchOption)
    {
        List<Movie> movies = movieService.searchClientMovies(searchValue, searchOption);
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các phim được tìm thấy")
                .data(movies)
                .build();
    }

    @GetMapping("/all/{pageNumber}")
    public CustomResponseEntity<?> findMoviesPageable(@PageableDefault(page = 0, size = 10,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @PathVariable("pageNumber") String pageNumber
            , @RequestParam(value = "itemsPerPage") String itemsPerPage)
    {
        Pageable newPageable = pageable;
        int numberOfPage = Integer.parseInt(pageNumber);
        int numberOfItems = Integer.parseInt(itemsPerPage);
        newPageable = PageRequest.of(numberOfPage, numberOfItems, pageable.getSort());
        Page<Movie> movies = movieService.findAll(newPageable);
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách phim phân trang")
                .data(movies)
                .build();
    }
}
