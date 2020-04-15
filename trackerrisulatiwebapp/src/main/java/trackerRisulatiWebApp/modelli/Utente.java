package trackerRisulatiWebApp.modelli;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long id;	
private String mail;
private String password;
private String tipo;
@Column(columnDefinition = "boolean default false")
private boolean active;
@OneToMany
List<Partita> listaPartita;



public Utente() {

}
public List<Partita> getListaPartita() {
	return listaPartita;
}

public void setListaPartita(List<Partita> listaPartita) {
	this.listaPartita = listaPartita;
}
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}

}
