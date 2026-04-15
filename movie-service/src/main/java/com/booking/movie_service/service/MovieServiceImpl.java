package com.booking.movie_service.service;

import com.booking.movie_service.entity.Movie;
import com.booking.movie_service.repository.MovieRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> fetchMovieList() {
		return (List<Movie>) movieRepository.findAll();
	}

	@Override
	public Movie updateMovie(Movie movie, Long movieId) {

		Movie movieDB = movieRepository.findById(movieId).get();

		if (Objects.nonNull(movie.getMovieName()) && !"".equalsIgnoreCase(movie.getMovieName())) {
			movieDB.setMovieName(movie.getMovieName());
		}

		if (Objects.nonNull(movie.getDuration()) && !"".equalsIgnoreCase(movie.getDuration())){
			movieDB.setDuration(movie.getDuration());
		}

		return movieRepository.save(movieDB);
	}

	@Override
	public void deleteMovieById(Long movieId) {
		movieRepository.deleteById(movieId);
	}
}