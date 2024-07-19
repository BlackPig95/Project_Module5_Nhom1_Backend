package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepo extends JpaRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long>
{
    @Override
    Page<Movie> findAll(Pageable pageable);

    Page<Movie> findAllByTitleContaining(String title, Pageable pageable);
//    @Query("select m from Movie m join m.genres g where ")
//    List<Movie> findMovieWithGenre(Long id);
}
