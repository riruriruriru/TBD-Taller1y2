package cl.citiaps.spring.backend.repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.FilmActor;

public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
	
	  //Collection<FilmsOnly> findByactorId(int actor_id);
	  


}
