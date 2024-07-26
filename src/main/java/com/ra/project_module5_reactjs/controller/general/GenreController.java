package com.ra.project_module5_reactjs.controller.general;

import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.design.general.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController
{
    private final HttpStatus httpOk = HttpStatus.OK;
    private final IGenreService genreService;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllGenres()
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các thể loại phim hiện có")
                .data(genreService.getAllGenres())
                .build();
    }

}
