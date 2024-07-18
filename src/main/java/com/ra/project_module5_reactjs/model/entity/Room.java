package com.ra.project_module5_reactjs.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private Boolean status;
}
