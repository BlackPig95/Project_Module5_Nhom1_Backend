package com.ra.project_module5_reactjs.model.entity;

import com.ra.project_module5_reactjs.constant.SeatTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Seat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @Column(name = "number")
    private Integer number;
    @Column(name = "seat_row", length = 5)
    private String seatRow;//Varchar 5  A3 B1 B2 B3
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SeatTypeEnum type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
}
