package com.ra.project_module5_reactjs.controller.general;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.design.admin.INewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class GeneralNewsController
{
    private final HttpStatus httpOk = HttpStatus.OK;
    private final INewsService newsService;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> getAllNews(@PageableDefault(page = 0, size = 8,
            sort = "id", direction = Sort.Direction.ASC) Pageable pageable)
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách tin tức")
                .data(newsService.findAllNews(pageable))
                .build();
    }

    @GetMapping("/{newsId}")
    public CustomResponseEntity<?> findById(@PathVariable Long newsId) throws CustomException
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Tin tức được tìm thấy")
                .data(newsService.findById(newsId))
                .build();
    }
}
