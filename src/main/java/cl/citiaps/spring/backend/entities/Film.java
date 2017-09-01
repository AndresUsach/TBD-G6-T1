package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT a FROM Film a")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	//AGREGADO
	@ManyToMany(cascade = {CascadeType.ALL})
	@JsonIgnore
	private Set<Actor> actors=new HashSet<Actor>();
	
	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
	//FIN AGREGADO
	 
	

	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="title", nullable=false, length=255)
	private String title;

	@Column(name="description", nullable=true)
	private String description;

	@Column(name="release_year", nullable=true)
	private int releaseYear;
	/*
	@Column(name="language_id", nullable=false)
	private int languageId;
	*/
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    private Language language;
	/*
	@Column(name="original_language_id", nullable=true)
	private int originalLanguageId;
	*/
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguageId;
	
	@Column(name="rental_duration", nullable=false)
	private int rentalDuration;
	
	@Column(name="rental_rate", nullable=false)
	private float rentalRate;
	
	@Column(name="length", nullable=true)
	private int lenght;
	
	@Column(name="replacement_cost", nullable=false)
	private float replacementCost;
	
	@Column(name="rating", nullable=true)
	private String rating;
	
	@Column(name="special_features", nullable=true)
	private String specialFeatures;
	
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	public Film() {
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}



	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}



	public Language getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(Language originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public float getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public float getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(float replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
