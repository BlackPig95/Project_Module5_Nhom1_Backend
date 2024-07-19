package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}
