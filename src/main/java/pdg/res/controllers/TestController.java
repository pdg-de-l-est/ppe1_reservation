package pdg.res.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pdg.res.models.Reservation;
import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
public class TestController {
	
	@Autowired
	private VueJS vue;

        @ModelAttribute(name = "vue")
        private VueJS getVue() {
            return this.vue;
        }
	
        @RequestMapping("/reser")
    	public String test(ModelMap model) throws Exception {
    		String startDate="23/08/2002-07:30";
    		String endDate="05/09/2002-18:00";
    		Date fStartDate=new SimpleDateFormat("dd/MM/yyyy-hh:mm").parse(startDate);
    		Date fEndDate=new SimpleDateFormat("dd/MM/yyyy-hh:mm").parse(endDate);
    		Reservation res=new Reservation(100,fStartDate,fEndDate);
    		model.addAttribute("reservation",res);
    		return "reservTest";
    	}
}
