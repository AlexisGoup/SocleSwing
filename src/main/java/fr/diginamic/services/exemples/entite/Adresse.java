package fr.diginamic.services.exemples.entite;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	private int numeroDeRue;
	private long libelleRue;
	private String ville;
	private int numeroTelephone;
	private String email;
	
	public int getNumeroDeRue() {
		return numeroDeRue;
	}
	public void setNumeroDeRue(int numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}
	public long getLibelleRue() {
		return libelleRue;
	}
	public void setLibelleRue(long libelleRue) {
		this.libelleRue = libelleRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(int numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
