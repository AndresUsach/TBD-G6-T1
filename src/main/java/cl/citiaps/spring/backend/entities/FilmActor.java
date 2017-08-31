package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="film_actor")
@NamedQuery(name="FilmActor.findAll", query="SELECT a FROM film_actor a")
public class FilmActor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "actor_id")
	private Actor actorId;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
	private Film filmId;
	
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	public FilmActor()
	{
		
	}

	

	public Actor getActorId() {
		return actorId;
	}



	public void setActorId(Actor actorId) {
		this.actorId = actorId;
	}

	public Film getFilmId() {
		return filmId;
	}

	public void setFilmId(Film filmId) {
		this.filmId = filmId;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

}
