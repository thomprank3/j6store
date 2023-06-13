package poly.store.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Order;
import poly.store.entity.Product;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

	Order update(Order order);

	void delete(Long id);

	List<Order> findAll();

}
