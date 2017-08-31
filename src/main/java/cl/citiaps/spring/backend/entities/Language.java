package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT a FROM Language a")
public class Language implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="language_id", unique=true, nullable=false)
	private int languageId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	public Language(){
		
	}
	
	public int getLanguageId()
	{
		return this.languageId;
	}
	
	public void setLanguageId(int languageId)
	{
		this.languageId = languageId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	

}
