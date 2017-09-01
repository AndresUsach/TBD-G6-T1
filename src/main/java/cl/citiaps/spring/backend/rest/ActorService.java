package cl.citiaps.spring.backend.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.repository.FilmRepository;

@RestController  
@RequestMapping("/actors")
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;
	
	//AGREGADO
	@Autowired
	private FilmRepository filmRepository;
	

	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Actor> getAllUsers() {
		return actorRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Actor findOne(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id);
	}
	
	//METODO GET AGREGADO!
	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
	@ResponseBody
	public  Set<Film> findFilms(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id).getFilms();
	}	
	// FIN GET METODO AGERGADO!
	
	
	//METODO POST AGREGADO!
		@RequestMapping(value = "/{actorId}/films/{filmId}",method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED)
		@ResponseBody
		public Actor match(@PathVariable("actorId") Integer actorId,@PathVariable("filmId") Integer filmId) {
			Actor actor = actorRepository.findOne(actorId);
			Set<Film> films = actor.getFilms();
			films.add(filmRepository.findOne(filmId));
			actor.setFilms(films);
			return actorRepository.save(actor);
		}
	//FIN METODO POST AGREGADO!
	
		
		
	//METODO POST INICIAL!
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor create(@RequestBody Actor resource) {
	     return actorRepository.save(resource);
	}
	//FIN METODO POST INICIAL!
	 
}