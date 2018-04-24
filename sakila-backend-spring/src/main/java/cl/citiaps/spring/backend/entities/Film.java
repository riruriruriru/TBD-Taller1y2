package cl.citiaps.spring.backend.entities;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.entities.FilmActor;
import java.io.Serializable;
import javax.persistence.*;


import java.sql.Date;
import java.sql.Timestamp;



@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;
	
	@Column(name="title", nullable=false, length=45)
	private String title;

	@Column(name="description", nullable=false, length=255, columnDefinition = "TEXT")
	private String description;
	
	@Column(name="language_id", nullable=true)
	private long language_id;
	
	@Column(name="original_language_id", nullable=true)
	private String original_language_id;
	
	@Column(name="release_year", nullable=false)
	private Date release_year;
	
	@Column(name="rental_duration", nullable=false)
	private long rental_duration;

	@Column(name="rental_rate", nullable=false)
	private long rental_rate;
	
	@Column(name="length", nullable=false)
	private long length;
	
	@Column(name="replacement_cost", nullable=false)
	private long replacement_cost;
	
	@Column(name="rating", nullable=false)
	private String rating;
	
	
	@Column(name="special_features", nullable=false, length=45)
	private String special_features;
	
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	public Film() {
	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getLanguageId() {
		return this.language_id;
	}

	public void setLanguageId(int language_id) {
		this.language_id = language_id;
	}

	public String getOriginalLanguageId() {
		return this.original_language_id;
	}

	public void setOriginalLanguageId(String original_language_id) {
		this.original_language_id = original_language_id;
	}
	
	public Date getReleaseYear() {
		return this.release_year;
	}

	public void setReleaseYear(Date release_year) {
		this.release_year = release_year;
	}
	
	public long getRentalDuration() {
		return this.rental_duration;
	}
	public void setRentalDuration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	
	public void setRentalRate(int rental_rate) {
		this.rental_rate = rental_rate;
	}
	
	public long getRentalRate() {
		return this.rental_rate;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public long getLength() {
		return this.length;
	}
	
	public void setReplacementCost(int replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	
	public long getReplacementCost() {
		return this.replacement_cost;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public void setSpecialFeatures(String special_features) {
		this.special_features = special_features;
	}
	
	public String getSpecialFeatures() {
		return this.special_features;
	}

	
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
