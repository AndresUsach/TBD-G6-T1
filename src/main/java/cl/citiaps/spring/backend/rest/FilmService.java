package cl.citiaps.spring.backend.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/films")
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	//AGREGADO
	@Autowired
	private ActorRepository actorRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Film findOne(@PathVariable("id") Integer id) {
		return filmRepository.findOne(id);
	}
	//METODO AGREGADO
	@RequestMapping(value = "/{id}/actors", method = RequestMethod.GET)
	@ResponseBody
	public Set<Actor> findActors(@PathVariable("id") Integer id) {
		return filmRepository.findOne(id).getActors();
	}
	//FIN METODO AGREGADO
	
	//METODO POST AGREGADO!
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Film create(@RequestBody Film resource) {
	     return filmRepository.save(resource);
	}
	//FIN METODO POST AGREGADO!
	
	/*
	//METODO POST AGREGADO!
			@RequestMapping(value = "/{filmId}/actors/{actorId}",method = RequestMethod.POST)
			@ResponseStatus(HttpStatus.CREATED)
			@ResponseBody
			public Film match(@PathVariable("filmId") Integer filmId,@PathVariable("actorId") Integer actorId) {
				Film film = filmRepository.findOne(filmId);
				Set<Actor> actors = film.getActors();
				actors.add(actorRepository.findOne(actorId));
				film.setActors(actors);
				return filmRepository.save(film);
			}
		//FIN METODO POST AGREGADO!
	*/
	
	@RequestMapping(value = "/{filmId}/actors/{actorId}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<Set<Actor>> match(@PathVariable("filmId") Integer filmId,@PathVariable("actorId") Integer actorId) {
		
		Actor actor = actorRepository.findOne(actorId);
		Film film = filmRepository.findOne(filmId);
		if (actor == null || film == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			
			Set<Film> films = actor.getFilms();
			films.add(film);
			actor.setFilms(films);
			actorRepository.save(actor);
			return new ResponseEntity<Set<Actor>>(filmRepository.findOne(filmId).getActors(), HttpStatus.OK);
		}
		
	}
	
	
	
		 

}
