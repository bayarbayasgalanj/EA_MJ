package cs544.bank.dao;

import java.util.Collection;

import org.springframework.stereotype.Service;

import cs544.bank.domain.Account;

@Service
public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
