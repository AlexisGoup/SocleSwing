package fr.diginamic.services.exemples.entite;

public enum Type {
	A("moto"), B("voiture"), C("Camion");
	
	private String type;

	Type(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
