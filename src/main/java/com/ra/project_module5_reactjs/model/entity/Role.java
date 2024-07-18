package com.ra.project_module5_reactjs.model.entity;

import com.ra.project_module5_reactjs.constant.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
}
