package trackerRisulatiWebApp.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Eroe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Lob
	@Column(columnDefinition = "LONGBLOB NOT NULL")
	private byte[] immagine;
	private String nome;
	private String heroPower;
	private String heroDescrizione;

	public Eroe() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHeroPower() {
		return heroPower;
	}

	public void setHeroPower(String heroPower) {
		this.heroPower = heroPower;
	}

	public String getHeroDescrizione() {
		return heroDescrizione;
	}

	public void setHeroDescrizione(String heroDescrizione) {
		this.heroDescrizione = heroDescrizione;
	}

	@Override
	public String toString() {
		return "Eroe [id=" + id + ", immagine=" + Arrays.toString(immagine) + ", nome=" + nome + ", heroPower="
				+ heroPower + ", heroDescrizione=" + heroDescrizione + "]";
	}

	

}
