package trackerRisulatiWebApp.model;


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
	private String immagine;
	private String nome;
	private int heroPower;
	private String heroDescrizione;

	public Eroe() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHeroPower() {
		return heroPower;
	}

	public void setHeroPower(int heroPower) {
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
		return "Eroe [id=" + id + ", immagine=" + immagine + ", nome=" + nome + ", heroPower=" + heroPower
				+ ", heroDescrizione=" + heroDescrizione + "]";
	}

	
	

}
