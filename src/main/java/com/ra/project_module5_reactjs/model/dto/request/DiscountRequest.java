package com.ra.project_module5_reactjs.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DiscountRequest {
    private String code;
    private String description;
    private Double discountPercentage;
    private MultipartFile imageUrl;
    private Boolean isUsed;
    private String validFrom;
    private String validTo;
}
