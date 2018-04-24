package cl.citiaps.spring.backend.rest;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.entities.FilmActor;
import cl.citiaps.spring.backend.entities.FilmActorPK;
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.repository.ActorsOnly;
import cl.citiaps.spring.backend.repository.FilmActorRepository;
import cl.citiaps.spring.backend.repository.FilmRepository;
import cl.citiaps.spring.backend.repository.FilmsOnly;

@CrossOrigin
@RestController  
@RequestMapping("/")
public class FilmActorService {
	
	@Autowired
	private FilmActorRepository filmactorRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ActorRepository actorRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<FilmActor> getAllFilmActors() {
		return filmactorRepository.findAll();
	}
	
	//@RequestMapping(value = "/{actor_id}", method = RequestMethod.GET)
	//@ResponseBody
	//public  Iterable<FilmActor> findAllWithActorId(@PathVariable("actor_id") Sort actor_id) {
		//return filmactorRepository.findAll(actor_id);
	//}
	
	/*@RequestMapping(value = "/actors/{id}/films", method = RequestMethod.GET)
	@ResponseBody
	public  Iterable<Film> findFilmsByActor(@PathVariable("id") Integer id) {
	    List<FilmsOnly> listaIds = filmactorRepository.findByactorId(id);
	    List<Film> listaRetorno = new ArrayList<>();
	    Iterable<Film> films = filmRepository.findAll();
	    //for (FilmActor item : listaIds) {
	    //	System.out.println("juaaaa " + filmRepository.getByfilmId(1));
	    //	listaRetorno.add(filmRepository.getByfilmId(item.getFilmId()));
	    //	System.out.println("dsadsadadd" + item);
	    //}
	    //for (FilmActor item : listaIds) {
	    	//listaint.add(item.getFilmId());
	    	//System.out.println("dsadsadadd" + listaint);
	    //}
    	System.out.println("fuera primer for ");
	    /*for (Integer i : listaint) {
	    	System.out.println("dentro segundo for " + i.intValue());
	    	System.out.println("uguu onegai " + i);
	    	f = filmRepository.findByfilmId(i.intValue());
	    	System.out.println("oWo onegai " + i);

	    	listaRetorno.add(filmRepository.findByfilmId(i));
	    	
	    }
    	System.out.println("TERMINO FOR" + listaint);
	    */
	//    return films;
//	}
	


	@RequestMapping(value = "/films/{Film}/actors", method = RequestMethod.GET)
	@ResponseBody
	public  List<FilmActor> findActorsByFilm(@PathVariable("Film") Film Film) {
		return filmactorRepository.findByFilm(Film);
	}
	
	@RequestMapping(value = "/actors/{Actor}/films", method = RequestMethod.GET)
	@ResponseBody
	public  Collection<FilmsOnly> findFilmByActor(@PathVariable("Actor") Actor Actor) {
		return filmactorRepository.findByActor(Actor);
	}
	
	@RequestMapping(value = "/filmsbynotactor/{Actor}", method = RequestMethod.GET)
	@ResponseBody
	public  Collection<FilmsOnly> findFilmByNotActor(@PathVariable("Actor") Actor Actor) {
		return filmactorRepository.findDistinctByActorNotIn(Actor);
	}
	
	//@RequestMapping(value = "/prueba/{filmId}", method = RequestMethod.GET)
	//@ResponseBody
	//public Collection<ActorsOnly> filmxactor(@PathVariable("filmId") int filmId) {
	//	return filmactorRepository.getAllByfilmId(filmId);
//}
	
	//@RequestMapping(method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	//@ResponseBody
	//public FilmActor create(@RequestBody FilmActor resource) {
	  //   return filmactorRepository.save(resource);
	//}
	
	//@RequestMapping(value = "/actors/{actor}/films/{film}", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	//public FilmActor addFilmToActor(@PathVariable("actor") Actor actor, @PathVariable("film") Film film) {
	public FilmActor addFilmToActor(@RequestBody FilmActor resource) {
		//FilmActorPK pk = new FilmActorPK();
		 //pk.setActorId(actor.getActorId());
		 //pk.setFilmId(film.getFilmId());
		 //System.out.println("pk: " + pk);
		//FilmActor fa = new FilmActor();
		//fa.setId(pk); 
		//fa.setFilm(film);
		 //fa.setActor(actor);
		 //System.out.println("Datos: " + fa);
		System.out.println("Datos: " + resource.getFilm());
		System.out.println("Datos: " + resource.getActor());
		System.out.println("Datos: " + resource.getActor().getActorId());
		System.out.println("Datos: " + resource.getActor().getFirstName());
		System.out.println("Datos: " + resource.getFilm().getFilmId());
		System.out.println("Datos: " + resource.getFilm().getTitle());
		FilmActorPK pk = new FilmActorPK();
		 pk.setActorId(resource.getActor().getActorId());
		 pk.setFilmId(resource.getFilm().getFilmId());
		 System.out.println("pk: " + pk);
		 resource.setId(pk);
		System.out.println("pk: " + resource.getId());
		System.out.println("pk: " + resource.getId().getActorId());
		System.out.println("pk: " + resource.getId().getFilmId());
		System.out.println("Datos: " + resource);
		return filmactorRepository.save(resource);
	}
		@RequestMapping(value = "/actors/{actor}/films/{film}", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseStatus(HttpStatus.CREATED)
		@ResponseBody
		public FilmActor addFilmToActor2(@PathVariable("actor") int actor, @PathVariable("film") int film) {
			//FilmActorPK pk = new FilmActorPK();
			 //pk.setActorId(actor.getActorId());
			 //pk.setFilmId(film.getFilmId());
			 //System.out.println("pk: " + pk);
			//FilmActor fa = new FilmActor();
			//fa.setId(pk); 
			//fa.setFilm(film);
			 //fa.setActor(actor);
			 //System.out.println("Datos: " + fa);
			System.out.println("U.U: "+ actor + ": " + film);
			Actor a = new Actor();
			Film f = new Film();
			a = actorRepository.findOne(actor);
			System.out.println("Datos: " + a);
			f = filmRepository.findOne(film);
			if(a == null || f == null) {
				
				return null;
				
			}
			System.out.println("Datos: " + f);
			FilmActor resource = new FilmActor();
			resource.setActor(a);
			resource.setFilm(f);
			System.out.println("Datos: " + resource.getFilm());
			System.out.println("Datos: " + resource.getActor());
			System.out.println("Datos: " + resource.getActor().getActorId());
			System.out.println("Datos: " + resource.getActor().getFirstName());
			System.out.println("Datos: " + resource.getFilm().getFilmId());
			System.out.println("Datos: " + resource.getFilm().getTitle());
			FilmActorPK pk = new FilmActorPK();
			 pk.setActorId(resource.getActor().getActorId());
			 pk.setFilmId(resource.getFilm().getFilmId());
			 System.out.println("pk: " + pk);
			 resource.setId(pk);
			System.out.println("pk: " + resource.getId());
			System.out.println("pk: " + resource.getId().getActorId());
			System.out.println("pk: " + resource.getId().getFilmId());
			System.out.println("Datos: " + resource);
			return filmactorRepository.save(resource);
		}

		@RequestMapping(value = "/films/{film}/actors/{actor}", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseStatus(HttpStatus.CREATED)
		@ResponseBody
		public FilmActor addActorToFilm2(@PathVariable("actor") int actor, @PathVariable("film") int film) {
			//FilmActorPK pk = new FilmActorPK();
			 //pk.setActorId(actor.getActorId());
			 //pk.setFilmId(film.getFilmId());
			 //System.out.println("pk: " + pk);
			//FilmActor fa = new FilmActor();
			//fa.setId(pk); 
			//fa.setFilm(film);
			 //fa.setActor(actor);
			 //System.out.println("Datos: " + fa);
			System.out.println("U.U: "+ actor + ": " + film);
			Actor a = new Actor();
			Film f = new Film();
			a = actorRepository.findOne(actor);
			System.out.println("Datos: " + a);
			f = filmRepository.findOne(film);
			if(a == null || f == null) {
				
				return null;
				
			}
			System.out.println("Datos: " + f);
			FilmActor resource = new FilmActor();
			resource.setActor(a);
			resource.setFilm(f);
			System.out.println("Datos: " + resource.getFilm());
			System.out.println("Datos: " + resource.getActor());
			System.out.println("Datos: " + resource.getActor().getActorId());
			System.out.println("Datos: " + resource.getActor().getFirstName());
			System.out.println("Datos: " + resource.getFilm().getFilmId());
			System.out.println("Datos: " + resource.getFilm().getTitle());
			FilmActorPK pk = new FilmActorPK();
			 pk.setActorId(resource.getActor().getActorId());
			 pk.setFilmId(resource.getFilm().getFilmId());
			 System.out.println("pk: " + pk);
			 resource.setId(pk);
			System.out.println("pk: " + resource.getId());
			System.out.println("pk: " + resource.getId().getActorId());
			System.out.println("pk: " + resource.getId().getFilmId());
			System.out.println("Datos: " + resource);
			return filmactorRepository.save(resource);
		}

}