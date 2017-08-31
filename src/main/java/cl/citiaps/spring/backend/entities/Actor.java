package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name="actor")
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="actor_id", unique=true, nullable=false)
	private int actorId;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	@OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FilmActor> filmActor;
	
	//private Set<Film> films;

	public Actor() {
	}

	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<FilmActor> getFilmActor() {
		return filmActor;
	}

	public void setFilmActor(Set<FilmActor> filmActor) {
		this.filmActor = filmActor;
	}
	
	/*
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"), inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
    public Set<Film> getFilms() {
        return films;
    }

    public void setPublishers(Set<Film> films) {
        this.films = films;
    }
    */

}