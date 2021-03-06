package pdg.res.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.JsArray;
import pdg.res.models.Product;
import pdg.res.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private VueJS vue;
	
	@Autowired
	private ProductRepository prodrepo;
	
	@ModelAttribute(name = "vue")
    private VueJS getVue() {
        return this.vue;
    }
	
	@PostMapping("/new/product")
	public RedirectView addProduct(@RequestParam String title,@RequestParam String type,@RequestParam String description,@RequestParam int price) {
		if(title!=null) {
			Product prod=new Product();
			prod.setTitle(title);
			prod.setType(type);
			prod.setDescription(description);
			prod.setPrice(price);
			prodrepo.saveAndFlush(prod);
			
		}
		return new RedirectView("/prodadd");
	}
	
	@RequestMapping("/home")
	public String home(ModelMap model) {
		return "home";
	}
	
	@RequestMapping("/prodadd")
	public String ajout(ModelMap model) {
		return "newProduct";
	}
	
	@RequestMapping("/prod")
	public String liste(ModelMap model) {
		List<Product> prod=prodrepo.findAll();
		model.put("products", prod);
		return "listProduct";
	}
	
	@RequestMapping("/product/{id}")
	public String info(ModelMap model,@PathVariable int id) {
		Optional<Product> prod=prodrepo.findById(id);
		model.put("product", prod.get());
		return "productById";
	}
	
	@RequestMapping("/reserch")
	public String recherche(ModelMap model) {
		vue.addDataRaw("items","['Breaks','Monospaces','Citadines','Coupés','Cabriolets','Pickups','Crossovers','Utilitaires',]");
		return "reserchProduct";
	}
	
	@RequestMapping("/product/reserch")
	public String rechercheProd(ModelMap model, @RequestParam String type) {
		List<Product> prod=prodrepo.findByType(type);
		model.put("products", prod);
		return "listProduct";
	}
	
	@RequestMapping("/gestion")
	public String gerer(ModelMap model) {
		List<Product> prod=prodrepo.findAll();
		model.put("products", prod);
		return "gestion";
	}
	
	@DeleteMapping("/deleteProduct")
	public RedirectView delProduct(@RequestParam String title) {
		if(title!=null) {		
			Optional<Product> p=prodrepo.findByTitle(title);
			prodrepo.delete(p.get());;
			prodrepo.flush();
		}
		return new RedirectView("/gestion");
	}
	
	@PutMapping("/updateProduct")
	public RedirectView updateProd(@RequestParam int id,@RequestParam String title,@RequestParam String type,@RequestParam String description,@RequestParam int price) {
		
		Optional<Product> promesseDeProduct = prodrepo.findById(id);
		if( promesseDeProduct.isPresent()) {
			
			promesseDeProduct.get().setTitle(title);
			promesseDeProduct.get().setType(type);
			promesseDeProduct.get().setDescription(description);
			promesseDeProduct.get().setPrice(price);
			prodrepo.saveAndFlush(promesseDeProduct.get());
		}
		return new RedirectView("gestion");
	}
}
