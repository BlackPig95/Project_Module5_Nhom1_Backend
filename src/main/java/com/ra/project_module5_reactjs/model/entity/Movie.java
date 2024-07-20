package com.ra.project_module5_reactjs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ra.project_module5_reactjs.constant.UserAdviceEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description", length = 500)
    private String description; //varchar500
    @Column(name = "director", length = 50)
    private String director; //varchar50
    @Column(name = "actors", length = 500)
    private String actors; //varchar500
    @Column(name = "user_advice")
    @Enumerated(EnumType.STRING)
    private UserAdviceEnum userAdvice;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "poster_url")
    private String posterUrl;
    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    @Column(name = "title", length = 100)
    private String title; //varchar100
    @Column(name = "trailer_link")
    private String trailerLink;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
}
