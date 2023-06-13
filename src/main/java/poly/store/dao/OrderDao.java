package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.store.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);

//	@Query("select top(10) o.username, count(o.username) as N'sodon' from Orders o group by o.username order by count(o.username) DESC")
//	List<Order> findTop10NguoiMuaNhieuNhat();
//	
//	select top(10) username, count(status) from Orders where Status=3 group by username order by username DESC
}
