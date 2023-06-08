package cs544;


import java.util.*;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountnumber;
	private String ber;
	// @OneToMany
	// private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	
	// @ManyToOne
	// private Customer customer;

	public Account() {
        // Default constructor
    }
	public Account (long accountnr, String b){
		this.accountnumber = accountnr;
        this.ber = b;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	// public double getBalance() {
	// 	double balance=0;
	// 	for (AccountEntry entry : entryList) {
	// 		balance+=entry.getAmount();
	// 	}
	// 	return balance;
	// }
	// public void deposit(double amount){
	// 	AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
	// 	entryList.add(entry);
	// }
	// public void withdraw(double amount){
	// 	AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
	// 	entryList.add(entry);	
	// }

	// private void addEntry(AccountEntry entry){
	// 	entryList.add(entry);
	// }

	// public void transferFunds(Account toAccount, double amount, String description){
	// 	AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
	// 	AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
	// 	entryList.add(fromEntry);	
	// 	toAccount.addEntry(toEntry);
	// }
	
	// public Customer getCustomer() {
	// 	return customer;
	// }
	// public void setCustomer(Customer customer) {
	// 	this.customer = customer;
	// }
	// public Collection<AccountEntry> getEntryList() {
	// 	return entryList;
	// }

}

