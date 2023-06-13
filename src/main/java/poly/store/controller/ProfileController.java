package poly.store.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.service.AccountService;

@Controller
public class ProfileController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/profile/edit")
	public String editProfile(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("account", accountService.findById(username));
		return "security/profile";
	}
}
