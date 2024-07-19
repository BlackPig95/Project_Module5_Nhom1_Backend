package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.constant.RoleEnum;
import com.ra.project_module5_reactjs.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleEnum name);
}