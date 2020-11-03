package pdg.res.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	
	@RequestMapping("/testMap")
	public String testMap(ModelMap model) {
		return "testMap";
	}
	
	@RequestMapping("/testMap2")
	public String testMap2(ModelMap model) {
		return "testMap2";
	}
}