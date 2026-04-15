package com.booking.movie_service.controller;

import com.booking.movie_service.entity.Movie;
import com.booking.movie_service.service.MovieService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/movies")
	public Movie saveMovie(@Valid @RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/movies")
	public List<Movie> fetchMovieList() {
		return movieService.fetchMovieList();
	}

	@PutMapping("/movies/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable("id") Long movieId) {
		return movieService.updateMovie(movie, movieId);
	}

	@DeleteMapping("/movies/{id}")
	public String deleteMovieById(@PathVariable("id") Long movieId) {
		movieService.deleteMovieById(movieId);
		return "Deleted Successfully";
	}
}