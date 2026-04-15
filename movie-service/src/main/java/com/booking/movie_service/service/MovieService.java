
package com.booking.movie_service.service;

import com.booking.movie_service.entity.Movie;

import java.util.List;

public interface MovieService {

	Movie saveMovie(Movie movie);

	List<Movie> fetchMovieList();

	Movie updateMovie(Movie movie, Long movieId);

	void deleteMovieById(Long movieId);
}