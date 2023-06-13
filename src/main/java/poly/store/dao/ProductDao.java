package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.store.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(Integer cid);
	
	@Query("SELECT p FROM Product p WHERE (p.discount > 0)")
	List<Product> findByDiscount();

	@Query("SELECT p FROM Product p WHERE (p.price>0 AND p.price<=50)")
	List<Product> findByPrice0to50();
	
	@Query("SELECT p FROM Product p WHERE (p.price>50 AND p.price<=100)")
	List<Product> findByPrice50to100();
	
	@Query("SELECT p FROM Product p WHERE (p.price>100 AND p.price<=500)")
	List<Product> findByPrice100to500();
	
	@Query("SELECT p FROM Product p WHERE (p.price>500)")
	List<Product> findByPriceBiggerThan500();
	
	@Query("SELECT p FROM Product p WHERE p.createDate >= (GETDATE() - 30)")
	List<Product> findByCreateDate();
	// lay top10 sp ban dc so luong nhieu nhat
//	List<Product> findTop10ByOrderBySoLuongSpBanDcDesc();
}
