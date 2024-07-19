package com.ra.project_module5_reactjs.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomResponseEntity<T>
{
    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private T data;
}
