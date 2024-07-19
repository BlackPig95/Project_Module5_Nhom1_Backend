package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IGenreRepo extends JpaRepository<Genre, Long>
{
    Genre findByName(String name);
}
