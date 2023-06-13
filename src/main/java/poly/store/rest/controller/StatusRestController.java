package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Category;
import poly.store.entity.Product;
import poly.store.entity.Status;
import poly.store.service.CategoryService;
import poly.store.service.ProductService;
import poly.store.service.StatusService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/statuses")
public class StatusRestController {
	@Autowired
	StatusService statusService;
	
	@GetMapping()
	public List<Status> getAll() {
		return statusService.findAll();
	}
	
}
