package pdg.res.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
public class GererController {

	@Autowired
	private VueJS vue;
	
	private String url="http://127.0.0.1:8080/";
	
	
	
	
}
