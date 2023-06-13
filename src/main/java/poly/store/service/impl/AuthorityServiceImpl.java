package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDao;
import poly.store.dao.AuthorityDao;
import poly.store.entity.Account;
import poly.store.entity.Authority;
import poly.store.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDao authorityDAO;
	
	@Autowired
	AccountDao accountDAO;

	@Override
	public List<Authority> findAuthoritiesOfAdministrator() {
		List<Account> accounts = accountDAO.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return authorityDAO.save(auth);
	}

	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}
}
