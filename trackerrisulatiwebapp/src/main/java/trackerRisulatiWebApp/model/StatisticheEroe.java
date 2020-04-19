package trackerRisulatiWebApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class StatisticheEroe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	List<Eroe> listaEroe;
	@OneToMany
	List<Comp> listaComp;
	@OneToOne
	private Utente utente;
	@OneToMany
	List<Partita> listaPartita;
	private int partiteGiocate;
	private double top4;
	private int vittoria;
	private double compTop4;
	public StatisticheEroe () {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Eroe> getListaEroe() {
		return listaEroe;
	}
	public void setListaEroe(List<Eroe> listaEroe) {
		this.listaEroe = listaEroe;
	}
	public List<Comp> getListaComp() {
		return listaComp;
	}
	public void setListaComp(List<Comp> listaComp) {
		this.listaComp = listaComp;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public List<Partita> getListaPartita() {
		return listaPartita;
	}
	public void setListaPartita(List<Partita> listaPartita) {
		this.listaPartita = listaPartita;
	}
	public int getPartiteGiocate() {
		return partiteGiocate;
	}
	public void setPartiteGiocate(int partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}
	public double getTop4() {
		return top4;
	}
	public void setTop4(double top4) {
		this.top4 = top4;
	}
	public int getVittoria() {
		return vittoria;
	}
	public void setVittoria(int vittoria) {
		this.vittoria = vittoria;
	}
	public double getCompTop4() {
		return compTop4;
	}
	public void setCompTop4(double compTop4) {
		this.compTop4 = compTop4;
	}
	
}
