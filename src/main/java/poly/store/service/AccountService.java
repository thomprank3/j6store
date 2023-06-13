package poly.store.service;

import java.util.List;

import poly.store.entity.Account;
import poly.store.entity.Product;

public interface AccountService {
	Account findById(String username);
	public List<Account> findAll();
	public List<Account> getAdministrators();
	void delete(String username);
	Account create(Account account);
	Account update(Account account);
}
