package com.ra.project_module5_reactjs.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Genre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 50)
    private String name; //varchar 50
    @Column(name = "status")
    private Boolean status;
}
