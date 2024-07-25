package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.constant.UserAdviceEnum;
import com.ra.project_module5_reactjs.model.entity.Country;
import com.ra.project_module5_reactjs.model.entity.Genre;
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
//    @Query("select m.genres from Movie m where m.id = :movieId")
//    List<Genre> findGenresByMovieId(Long movieId);

    //    @Query(nativeQuery = true, value = "select m.*" +
//            "from movie m" +
//            "         join showtime s on m.id = s.movie_id" +
//            "         join booking b on s.id = b.showtime_id" +
//            "where month(b.booking_date) = month(curdate())" +
//            "  and year(b.booking_date) = year(curdate())" +
//            "group by m.id" +
//            "order by count(m.id) desc ")
    @Query("select m from Movie m join Showtime s on m.id = s.movie.id " +
            "join Booking b on b.showtime.id = s.id " +
            "where month(b.bookingDate) = month (current_date) " +
            "and year(b.bookingDate) = year (current_date)" +
            "group by m.id order by count(m.id) desc limit 5")
    List<Movie> findHotMovies();

    List<Movie> findAllByTitleContaining(String title);

    @Query("select m from Movie m join m.genres g where g.id = :genreId")
    List<Movie> findAllByGenre(Long genreId);

    List<Movie> findAllByUserAdvice(UserAdviceEnum userAdvice);

    List<Movie> findAllByCountry(Country country);
}
