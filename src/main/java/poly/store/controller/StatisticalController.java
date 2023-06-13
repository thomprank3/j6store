package poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticalController {
	@RequestMapping("/statistical")
	public String statistical() {
		return "statistical/view";
	}
}	
