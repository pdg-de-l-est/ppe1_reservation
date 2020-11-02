package pdg.res.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return new RedirectView("/prod");
	}
	
	@RequestMapping("/prod")
	public String index(ModelMap model) {
		return "newProduct";
	}
	
	@RequestMapping("/testMap")
	public String testMap(ModelMap model) {
		return "testMap";
	}
}
