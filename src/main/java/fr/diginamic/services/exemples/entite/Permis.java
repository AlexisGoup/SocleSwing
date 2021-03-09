package fr.diginamic.services.exemples.entite;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Permis {
	private String numero;
	private Type type;
	private LocalDate dateObtention;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public LocalDate getDateObtention() {
		return dateObtention;
	}
	public void setDateObtention(LocalDate dateObtention) {
		this.dateObtention = dateObtention;
	}
}
