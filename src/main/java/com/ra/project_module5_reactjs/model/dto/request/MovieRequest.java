package com.ra.project_module5_reactjs.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ra.project_module5_reactjs.constant.UserAdviceEnum;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovieRequest
{
    private Long id;
    private String description;
    private String director;
    private String actors;
    private String userAdvice;
    private Integer duration;
    private MultipartFile posterUrl;
    private String releaseDate;
    private String title;
    private String trailerLink;
    private Boolean status; //Mặc định là true, khi xóa mềm thì đổi thành false
    private String countryName;
    private Set<String> genres;
}
