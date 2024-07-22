package com.ra.project_module5_reactjs.controller.general;

import com.ra.project_module5_reactjs.constant.UserAdviceEnum;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/useradvices")
public class UserAdviceController
{
    private final HttpStatus httpOk = HttpStatus.OK;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllGenres()
    {
        List<String> enumList = Arrays.stream(UserAdviceEnum.values()).map(Enum::toString).toList();
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các thể loại phim hiện có")
                .data(enumList)
                .build();
    }
}
