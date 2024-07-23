package com.ra.project_module5_reactjs.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketPriceRequest {
    private Integer standardPrice;
    private Integer sweetboxPrice;
    private Integer vipPrice;
    private String timePeriod;
    private Integer weekendRate;
}