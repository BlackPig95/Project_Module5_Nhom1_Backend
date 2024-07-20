package com.ra.project_module5_reactjs.controller.general;

import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import com.ra.project_module5_reactjs.service.design.general.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CountryController
{
    private final HttpStatus httpOk = HttpStatus.OK;
    private final ICountryService countryService;

    @GetMapping({"/", ""})
    public CustomResponseEntity<?> findAllCountries()
    {
        return CustomResponseEntity.builder()
                .statusCode(httpOk.value())
                .status(httpOk)
                .message("Danh sách các quốc gia hiện có")
                .data(countryService.getAllCountries())
                .build();
    }
}
