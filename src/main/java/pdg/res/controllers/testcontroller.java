package pdg.res.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;

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
		return "index";
	}
}
