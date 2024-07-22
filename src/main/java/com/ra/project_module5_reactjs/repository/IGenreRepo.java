package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IGenreRepo extends JpaRepository<Genre, Long>
{
    Genre findByName(String name);

//    @Query("select m from Movie m join m.genres mg join Genre g on g.id = mg.id " +
//            "where m.id = :movieId")
//    List<Genre> findGenreByMovieId(Long movieId);
}
