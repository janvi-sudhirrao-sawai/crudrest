package com.janvi.crudrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janvi.crudrest.entities.Account;
import com.janvi.crudrest.repositories.AccountRepository;

@Service
public class AccountServices {
	
	@Autowired
	private AccountRepository accRepo;
	
	public List<Account> getAllAccounts()
	{
		List<Account> acclist=accRepo.findAll();
		return acclist;
	}
	
	public Account getAccount(int accno)
	{
		return accRepo.findByAccno(accno);
	}
	
	public List<Account> getAllOfType(String acctype)
	{
		return accRepo.findByAcctype(acctype);
	}

	public Account openAccount(Account obj)
	{
		return accRepo.save(obj);
	}
	
	public String deposit(int accno,float amount)
	{
		Account obj=accRepo.findByAccno(accno);
		System.out.println(obj.getBalance());
		
		obj.setBalance(obj.getBalance()+amount);
		System.out.println(obj.getBalance());
		accRepo.save(obj);
		return "success";
	}
	
	public String deleteAcc(int accno)
	{
		Account obj=accRepo.findByAccno(accno);
		String status="";
		System.out.println(obj);
		if(obj!=null)
		{
			accRepo.delete(obj);
			status="success";
		}
		else
		{
			status="failed";
		}
			
		return status;
	}
}
