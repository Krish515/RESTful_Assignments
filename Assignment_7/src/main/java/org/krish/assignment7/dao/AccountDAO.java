package org.krish.assignment7.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.krish.assignment7.model.*;

public class AccountDAO {
	
	private static final Map<String, Account> accMap= new HashMap<String,Account>();
	
	static {
		initAcc();
	}
	private static void initAcc(){
		Account a1 = new Account("A101","Stark",25000.50);
		Account a2 = new Account("A102","Peter",45000.70);
		Account a3 = new Account("A103","Hugh",15000.50);
		
		accMap.put(a1.getAccNo(), a1);
		accMap.put(a2.getAccNo(), a2);
		accMap.put(a3.getAccNo(), a3);
	}
	public static List<Account> getAllAccount(){
		Collection<Account> c = accMap.values();
		List<Account> list = new ArrayList<Account>();
		list.addAll(c);
		return list;	
	}
	public static Account getBalance(String accNo) {
        return accMap.get(accNo);
    }
	public static Account updateBalance(Account acc) {
        accMap.put(acc.getAccNo(), acc);
        return acc;
    }
	List<Account> list;
	public static Account deposit(String accNo, double deposit) {
		// TODO Auto-generated method stub
		double balance =accMap.get(accNo).getBalance();
		accMap.get(accNo).setBalance(balance+deposit);
		return accMap.get(accNo);
	}
	public static Account withdraw(String accNo, double withdraw) {
		// TODO Auto-generated method stub
		double balance =accMap.get(accNo).getBalance();
		accMap.get(accNo).setBalance(balance-withdraw);
		return accMap.get(accNo);
	}
}
