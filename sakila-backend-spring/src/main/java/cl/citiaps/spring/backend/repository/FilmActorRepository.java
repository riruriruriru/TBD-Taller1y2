package cl.citiaps.spring.backend.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.entities.FilmActor;

public interface FilmActorRepository extends PagingAndSortingRepository<FilmActor, Integer> {
	
		List<FilmActor> findByFilm(Film film_id);
		Collection<FilmsOnly> findByActor(Actor actor_id);
		Collection<FilmsOnly> findDistinctByActorNotIn(Actor actor_id);


}