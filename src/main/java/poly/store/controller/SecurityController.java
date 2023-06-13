package poly.store.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import poly.store.entity.Account;
import poly.store.service.AccountService;

@Controller
public class SecurityController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui long dang nhap!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Dang nhap thanh cong!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thong tin dang nhap!");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Khong co quyen truy xuat!");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Ban da dang xuat!");
		return "security/login";
	}
	
	@RequestMapping("/security/change-password")
	public String changePasswordForm(Model model) {
		model.addAttribute("message", "Ban da dang xuat!");
		return "security/login";
	}
	
	
//	@RequestMapping("/security/register")
//	public String create(@RequestBody Account account, Model model) {
//		accountService.create(account);
//		model.addAttribute("message", "Đăng ký thành công");
//		return "security/login";
//	}
}
