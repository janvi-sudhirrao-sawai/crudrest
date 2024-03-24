package com.janvi.crudrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janvi.crudrest.entities.Account;
import com.janvi.crudrest.services.AccountServices;

@RestController
@RequestMapping("/bank")
public class AccountController {
	
	@Autowired
	private AccountServices accServ;
	
	@GetMapping("/account/all")
	public List<Account> getAllAcc()
	{
		return accServ.getAllAccounts();
	}
	
	@GetMapping("/account/search/{accno}")
	public Account getAccInfo(@PathVariable int accno)
	{
		return accServ.getAccount(accno);
	}
	
	@GetMapping("/account/search/type/{acctype}")
	public List<Account> getOnType(@PathVariable String acctype)
	{
		return accServ.getAllOfType(acctype);
	}
	
	@PostMapping("/account/add")
	public Account addAccount(@RequestBody Account acc)
	{
		return accServ.openAccount(acc);
	}
	
	@PutMapping("/account/deposit")
	public String depositAmount(@RequestParam int accno,@RequestParam float amount)
	{
		String stat=accServ.deposit(accno, amount);
		return stat;
	}
	
	@DeleteMapping("/account/close")
	public String closeAccount(@RequestParam int accno)
	{
		return accServ.deleteAcc(accno);
	}
	

}
