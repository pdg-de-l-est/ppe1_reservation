package pdg.res.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Location {
	
	@ManyToOne
	private City city;
	
	@OneToMany
	private List<Product> products;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String gps;
	private String address1;
	private String address2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Location [address1=" + address1 + "]";
	}
	
	
	
}
