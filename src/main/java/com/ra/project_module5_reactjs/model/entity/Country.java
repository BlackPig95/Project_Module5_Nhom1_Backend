package com.ra.project_module5_reactjs.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 50)
    private String name; //Varchar 50
    @Column(name = "status")
    private Boolean status;
}
