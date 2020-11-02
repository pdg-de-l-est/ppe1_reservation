package pdg.res.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import io.github.jeemv.springboot.vuejs.VueJS;
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
	
	@RequestMapping("/prodadd")
	public String ajout(ModelMap model) {
		return "newProduct";
	}
	
<<<<<<< HEAD
	@RequestMapping("/testMap")
	public String testMap(ModelMap model) {
		return "testMap";
=======
	@RequestMapping("/prod")
	public String liste(ModelMap model) {
		List<Product> prod=prodrepo.findAll();
		model.put("products", prod);
		return "listProduct";
	}
	
	@RequestMapping("/product/{id}")
	public String info(ModelMap model,@PathVariable int id) {
		Optional<Product> prod=prodrepo.findById(id);
		if(prod.isPresent()) {
			model.put("product", prod);
			return "productById";
		}
		return "Produit non trouvé";
>>>>>>> c18ef1520802b22631bc6089c5c9c852dc489736
	}
}
