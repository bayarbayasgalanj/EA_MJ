package cs544.bank.dao;


import java.util.Collection;
import java.util.Date;

import cs544.bank.domain.Account;
import cs544.bank.domain.AccountEntry;
import cs544.bank.domain.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JPAAccountDAO implements IAccountDAO{
    
    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }
    public void updateAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        for (AccountEntry entry : account.getEntryList()) {
            System.out.println("entry==========="+entry);
			em.persist(entry);
		}
        em.merge(account);
    }
    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.find(Account.class, accountnumber);
    }
    public Collection<Account> getAccounts(){
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);
        return query.getResultList();
    }
}
