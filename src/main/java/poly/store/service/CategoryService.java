package poly.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.store.entity.Category;

public interface CategoryService {


	List<Category> findAll();

	Category findById(Integer id);

	Category create(Category category);

	Category update(Category category);

	void deleteById(Integer id);
}
