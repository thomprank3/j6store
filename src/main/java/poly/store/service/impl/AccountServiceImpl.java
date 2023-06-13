package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDao;
import poly.store.entity.Account;
import poly.store.entity.Product;
import poly.store.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDao accountDAO;

	@Override
	public Account findById(String username) {
		return accountDAO.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return accountDAO.getAdministrators();
	}

	@Override
	public void delete(String username) {
		accountDAO.deleteById(username);
		
	}

	@Override
	public Account create(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public Account update(Account account) {
		return accountDAO.save(account);
	}
}
