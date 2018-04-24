package cl.citiaps.spring.backend.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.entities.FilmActor;

public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {
	
	Film findByfilmId(int film_id);
	Film getByfilmId(int film_id);
	List<Film> findAllByfilmId(List<Integer> id);

}