package com.janvi.crudrest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janvi.crudrest.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByAccno(int accno);
	List<Account> findByAcctype(String acctype);
}
