package poly.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.entity.Category;
import poly.store.entity.Product;
import poly.store.service.CategoryService;
import poly.store.service.ProductService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/category/list")
	public String list(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("items", list);

		return "category/list";
	}
	
	
}
