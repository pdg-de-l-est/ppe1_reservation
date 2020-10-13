package pdg.res.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Caracteristic {
	
	@OneToMany
	private List<Type> types;
	
	@ManyToMany
	private List<Product> products;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String label;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
