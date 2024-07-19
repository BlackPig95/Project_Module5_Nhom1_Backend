package com.ra.project_module5_reactjs.model.dto.response;

import com.ra.project_module5_reactjs.constant.UserAdviceEnum;
import com.ra.project_module5_reactjs.model.entity.Country;
import com.ra.project_module5_reactjs.model.entity.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovieInfoResponse
{
    private Long id;
    private String description; //varchar500
    private String director; //varchar50
    private String actors; //varchar500
    private UserAdviceEnum userAdvice;
    private Integer duration;
    private String posterUrl;
    private Date releaseDate;
    private String title; //varchar100
    private String trailerLink;
    private Boolean status; //Mặc định là true, khi xóa mềm thì đổi thành false
    private String countryName;
    private Set<String> genres;
}
