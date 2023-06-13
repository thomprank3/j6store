package poly.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.entity.Product;
import poly.store.service.CategoryService;
import poly.store.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/product/list")
	public String list(Model model,@RequestParam("cid") Optional<Integer> cid) {
		if(cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items", list);
			//lay ten title
			model.addAttribute("title_product", categoryService.findById(cid.get()).getName());
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
			model.addAttribute("title_product","ALL PRODUCTS");
		}
		
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		model.addAttribute("item", product);
		return "product/detail";
	}
	
	@RequestMapping("/product/list/zeroTofiftyDollar")
	public String filterZeroTofiftyDollar(Model model) {
		List<Product> list = productService.findByPrice0to50();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "Filter: 0-50$");
		return "product/list";
	}
	
	@RequestMapping("/product/list/fiftyToOneHundredDollar")
	public String filterfiftyToOneHundredDollar(Model model) {
		List<Product> list = productService.findByPrice50to100();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "Filter: 50-100$");
		return "product/list";
	}
	
	@RequestMapping("/product/list/OneHunderedToFiveHundredDollar")
	public String filterOneHunderedToFiveHundredDollar(Model model) {
		List<Product> list = productService.findByPrice100to500();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "Filter: 100-500$");
		return "product/list";
	}
	
	@RequestMapping("/product/list/biggerThanFiveHundredDollar")
	public String filterbiggerThanFiveHundredDollar(Model model) {
		List<Product> list = productService.findByPriceBiggerThan500();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "Filter: >500$");
		return "product/list";
	}
	
	@RequestMapping("product/list/sales")
	public String filterSales(Model model) {
		List<Product> list = productService.findByDiscount();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "Sales");
		return "product/sales";
	}
	
	@RequestMapping("product/list/bestSeller")
	public String filterBestSeller(Model model) {
		List<Product> list = productService.findByDiscount();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "Best Seller");
		return "product/sales";
	}
	
	@RequestMapping("product/list/new")
	public String filterNew(Model model) {
		List<Product> list = productService.findNewProductsIn1MonthAgo();
		model.addAttribute("items", list);
		model.addAttribute("title_product", "New Products");
		return "product/new";
	}
}
