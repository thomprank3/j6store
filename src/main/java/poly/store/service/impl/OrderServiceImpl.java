package poly.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import poly.store.dao.OrderDao;
import poly.store.dao.OrderDetailDao;
import poly.store.entity.Order;
import poly.store.entity.OrderDetail;
import poly.store.entity.Product;
import poly.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDao orderDAO;
	
	@Autowired
	OrderDetailDao orderDetailDAO;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orderDAO.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		orderDetailDAO.saveAll(details);
		
		return order;
	}

	@Override
	public Order findById(Long id) {
		return orderDAO.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return orderDAO.findByUsername(username);
	}

	@Override
	public Order update(Order order) {
		return orderDAO.save(order);
	}

	@Override
	public void delete(Long id) {
		orderDAO.deleteById(id);
	}

	@Override
	public List<Order> findAll() {
		return orderDAO.findAll();
	}
}
