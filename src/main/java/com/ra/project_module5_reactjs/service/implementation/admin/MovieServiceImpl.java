package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.config.FileService;
import com.ra.project_module5_reactjs.constant.UserAdviceEnum;
import com.ra.project_module5_reactjs.model.dto.request.MovieRequest;
import com.ra.project_module5_reactjs.model.entity.Country;
import com.ra.project_module5_reactjs.model.entity.Genre;
import com.ra.project_module5_reactjs.model.entity.Movie;
import com.ra.project_module5_reactjs.repository.*;
import com.ra.project_module5_reactjs.service.design.admin.IMovieService;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements IMovieService
{
    private final IMovieRepo movieRepo;
    //    private final FileService fileService;
    private final ICountryRepo countryRepo;
    private final IGenreRepo genreRepo;
    private final IShowtimeRepo showtimeRepo;
    private final IReviewRepository reviewRepo;
    private final FileService fileService;

    @Override
    public Page<Movie> findAll(Pageable pageable)
    {
        return movieRepo.findAll(pageable);
    }

    @Override
    public Movie addMovie(MovieRequest movieRequest) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Movie movie = Movie.builder()
                .description(movieRequest.getDescription())
                .director(movieRequest.getDirector())
                .actors(movieRequest.getActors())
                .userAdvice(UserAdviceEnum.valueOf(movieRequest.getUserAdvice()))
                .duration(movieRequest.getDuration())
                .posterUrl(fileService.uploadFileToServer(movieRequest.getPosterUrl()))
                .releaseDate(sdf.parse(movieRequest.getReleaseDate()))
                .title(movieRequest.getTitle())
                .trailerLink(movieRequest.getTrailerLink())
                .status(true)//Mặc định khi thêm mới là true
                .country(countryRepo.findByName(movieRequest.getCountryName()))
                .genres(movieRequest.getGenres().stream().map(genreRepo::findByName).collect(Collectors.toSet()))
                .build();
        return movieRepo.save(movie);
    }

    @Override
    public Movie editMovie(MovieRequest movieRequest) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Movie movie = Movie.builder()
                .id(movieRequest.getId())
                .description(movieRequest.getDescription())
                .director(movieRequest.getDirector())
                .actors(movieRequest.getActors())
                .userAdvice(UserAdviceEnum.valueOf(movieRequest.getUserAdvice()))
                .duration(movieRequest.getDuration())
                .posterUrl(fileService.uploadFileToServer(movieRequest.getPosterUrl()))
                .releaseDate(sdf.parse(movieRequest.getReleaseDate()))
                .title(movieRequest.getTitle())
                .trailerLink(movieRequest.getTrailerLink())
                .status(movieRequest.getStatus())//Mặc định khi thêm mới là true
                .country(countryRepo.findByName(movieRequest.getCountryName()))
                .genres(movieRequest.getGenres().stream().map(genreRepo::findByName).collect(Collectors.toSet()))
                .build();
        return movieRepo.save(movie);
    }

    @Override
    @Transactional
    public String deleteMovie(Long id)
    {
//        List<Genre> listGenere = genreRepo.findGenreByMovieId(id);
//        System.out.println(listGenere);
        Movie movieToBeDeleted = movieRepo.findById(id).orElseThrow(() -> new RuntimeException("Phim không tồn tại"));
        if (showtimeRepo.existsByMovie_Id(id) || reviewRepo.existsByMovieId(id))
        {
            movieToBeDeleted.setStatus(false);
            return "Phim đã được chuyển trạng thái về không hoạt động";
        } else
        {
            movieRepo.delete(movieToBeDeleted);
            return "Phim đã được xóa";
        }
    }

    @Override
    public Movie findById(Long id)
    {
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Movie> findAllByName(String title, Pageable pageable)
    {
        if (title == null)
        {
            title = "";
        }
        if (title.isEmpty())
        {
            return movieRepo.findAll(pageable);
        }
        return movieRepo.findAllByTitleContaining(title, pageable);
    }

    @Override
    public List<Movie> getAllMovies()
    {
        return movieRepo.findAll();
    }

    @Override
    public List<Movie> findHotMovies()
    {
//        return movieRepo.findAll();
        return movieRepo.findHotMovies();
    }

    @Override
    public List<Movie> searchClientMovies(String searchValue, String searchOption)
    {
        if (searchOption.equals("genres"))
        {
            return movieRepo.findAllByGenre(Long.parseLong(searchValue));
        }
        if (searchOption.equals("userAdvice"))
        {
            UserAdviceEnum userAdviceEnum = UserAdviceEnum.valueOf(searchValue);
            return movieRepo.findAllByUserAdvice(userAdviceEnum);
        }
        if (searchOption.equals(("country")))
        {
            Country country = countryRepo.findByName(searchValue);
            return movieRepo.findAllByCountry(country);
        }
        return movieRepo.findAllByTitleContaining(searchValue);
    }
}
