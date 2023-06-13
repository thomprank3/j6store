package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.store.entity.Status;

@Repository
public interface StatusDao extends JpaRepository<Status, Long>{

}
