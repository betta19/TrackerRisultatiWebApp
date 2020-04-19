package trackerRisulatiWebApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long ratingIniziale;
	private long ratingAttuale;
	private long incrementoDelta;
	@OneToOne
	private Utente utente;

	public Rating () {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRatingIniziale() {
		return ratingIniziale;
	}

	public void setRatingIniziale(long ratingIniziale) {
		this.ratingIniziale = ratingIniziale;
	}

	public long getRatingAttuale() {
		return ratingAttuale;
	}

	public void setRatingAttuale(long ratingAttuale) {
		this.ratingAttuale = ratingAttuale;
	}

	public long getIncrementoDelta() {
		return incrementoDelta;
	}

	public void setIncrementoDelta(long incrementoDelta) {
		this.incrementoDelta = incrementoDelta;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", ratingIniziale=" + ratingIniziale + ", ratingAttuale=" + ratingAttuale
				+ ", incrementoDelta=" + incrementoDelta + ", utente=" + utente + "]";
	}
	
}
