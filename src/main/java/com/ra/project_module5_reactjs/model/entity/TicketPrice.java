package com.ra.project_module5_reactjs.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket_price")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TicketPrice
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "standard_price")
    private Integer standardPrice;
    @Column(name = "sweetbox_price")
    private Integer sweetboxPrice;
    @Column(name = "vip_price")
    private Integer vipPrice;
    @Column(name = "time_period")
    private String timePeriod; //Dùng để in ra bảng thông tin giá vé
    @Column(name = "weekend_rate")
    private Integer weekendRate;
}
