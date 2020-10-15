package pdg.res.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Type {
	
	@ManyToOne
	private Caracteristic caracteristic;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String libelle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Caracteristic getCaracteristic() {
		return caracteristic;
	}

	public void setCaracteristic(Caracteristic caracteristic) {
		this.caracteristic = caracteristic;
	}
	
	
	
}
