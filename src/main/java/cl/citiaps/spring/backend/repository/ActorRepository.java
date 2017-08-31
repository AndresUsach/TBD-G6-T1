package cl.citiaps.spring.backend.repository;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.Film;

public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
	

}
