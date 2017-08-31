package cl.citiaps.spring.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Language;

public interface LanguageRepository extends PagingAndSortingRepository<Language, Integer> {
	

}
