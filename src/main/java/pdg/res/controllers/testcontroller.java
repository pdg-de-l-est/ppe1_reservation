package pdg.res.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;

@Controller
public class testcontroller {
	
	@Autowired
	private VueJS vue;

        @ModelAttribute(name = "vue")
        private VueJS getVue() {
            return this.vue;
        }
	
	@RequestMapping("/test")
	public String index() {
		return "newProduct";
	}
	
	@RequestMapping("/test")
	public String index(ModelMap model) {
		vue.addData("dialog", false);
		vue.addData("isNew", false);
		vue.addDataRaw("Product", "{}");
		vue.addDataRaw("Products", "[]");
		vue.addMethod("addProduct", "let self=this;" + Http.post("Product", "self.Product", "self.Products.push(response.data);self.dialog=false;self.showMsg('success','Organisation '+self.orga.name+' ajoutée !');", "self.showMsg('error',response);"));
		return "index";
	}
}

