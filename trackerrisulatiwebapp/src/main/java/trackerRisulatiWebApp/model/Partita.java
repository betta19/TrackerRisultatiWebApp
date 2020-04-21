package trackerRisulatiWebApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Partita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
private Eroe eroe;
	@OneToOne
private Comp comp;
private int posizioneFinale;
private String notePersonali;
private int rating;
private String nomeUtente;

public Partita() {
	
}

public String getNomeUtente() {
	return nomeUtente;
}

public void setNomeUtente(String nomeUtente) {
	this.nomeUtente = nomeUtente;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}



public Eroe getEroe() {
	return eroe;
}

public void setEroe(Eroe eroe) {
	this.eroe = eroe;
}

public Comp getComp() {
	return comp;
}

public void setComp(Comp comp) {
	this.comp = comp;
}

public int getPosizioneFinale() {
	return posizioneFinale;
}
public void setPosizioneFinale(int posizioneFinale) {
	this.posizioneFinale = posizioneFinale;
}
public String getNotePersonali() {
	return notePersonali;
}
public void setNotePersonali(String notePersonali) {
	this.notePersonali = notePersonali;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}

}
