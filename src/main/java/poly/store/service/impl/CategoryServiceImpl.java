package poly.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.store.dao.CategoryDao;
import poly.store.entity.Category;
import poly.store.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao dao;

	@Override
	public List<Category> findAll() {
		
		return dao.findAll();
	}
	@Override
	public Category findById(Integer id) {
		return dao.findById(id).get();
	}
	@Override
	public Category create(Category category) {
		return dao.save(category);
	}
	@Override
	public Category update(Category category) {
		return dao.save(category);

	
	}
	@Override
	public void deleteById(Integer id) {
		 dao.deleteById(id);		
	}
	

	
}
