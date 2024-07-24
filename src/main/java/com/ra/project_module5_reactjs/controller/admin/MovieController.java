package com.ra.project_module5_reactjs.controller.admin;

import com.ra.project_module5_reactjs.model.dto.request.MovieRequest;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/movies")
public class MovieController
{
    private final IMovieService movieService;
    private final HttpStatus httpOk = HttpStatus.OK;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllMovies(@PageableDefault(page = 0, size = 10,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(name = "title", defaultValue = "") String title)
    {
        Page<Movie> movies = movieService.findAllByName(title, pageable);
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các phim hiện có")
                .data(movies)
                .build();
    }

    @PostMapping({"/", ""})
    public CustomResponseEntity<?> addMovie(@ModelAttribute MovieRequest movieRequest) throws ParseException
    {
        return CustomResponseEntity.builder()
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED)
                .message("Thêm phim thành công")
                .data(movieService.addMovie(movieRequest))
                .build();
    }

    @PutMapping({"/", ""})
    public CustomResponseEntity<?> editMovie(@ModelAttribute MovieRequest movieRequest) throws ParseException
    {
        return CustomResponseEntity.builder()
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED)
                .message("Cập nhật thành công")
                .data(movieService.editMovie(movieRequest))
                .build();
    }

    @DeleteMapping("/{id}")
    public CustomResponseEntity<?> deleteMovie(@PathVariable Long id)
    {
        return CustomResponseEntity.builder()
                .statusCode(HttpStatus.NO_CONTENT.value())
                .status(HttpStatus.NO_CONTENT)
                .message("Thực hiện yêu cầu xóa phim")
                .data(movieService.deleteMovie(id))
                .build();
    }

    @GetMapping("/{id}")
    public CustomResponseEntity<?> getMovieDetails(@PathVariable Long id)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Chi tiết phim")
                .data(movieService.findById(id))
                .build();
    }

    @GetMapping({"/name/{searchName}", "/name/"})
    public CustomResponseEntity<?> findByName(@PageableDefault(page = 0, size = 10,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @PathVariable(required = false) String searchName)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách phim tìm được")
                .data(movieService.findAllByName(searchName, pageable))
                .build();
    }
}
