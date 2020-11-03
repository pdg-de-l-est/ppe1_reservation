package pdg.res.controllers;

import java.util.List;

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
public class GererController {

	@Autowired
	private VueJS vue;

	@ModelAttribute(name = "vue")
	private VueJS getVue() {
		return this.vue;
	}
	
	@Autowired
	private ProductRepository pRepo;
	
	private String url="http://127.0.0.1:8080/";
	
	@RequestMapping("/gerer")
	public String index(ModelMap model) {
	List<Product> prod=pRepo.findAll();
	model.put("product", prod);
	
	
	return "gestion";
	
	
	}
	
	
}
