package com.ra.project_module5_reactjs.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "showtime_seat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShowtimeSeat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @Column(name = "is_booked")
    private Boolean isBooked;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showtime_id", referencedColumnName = "id")
    private Showtime showtime;
}
