package org.krish.assignment7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	private String accNo;
	private String name;
	private double balance;
	
	
	public Account(){
		
	}
	
	public Account(String accNo,String name,double balance){
		this.accNo=accNo;
		this.name=name;
		this.balance=balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
}
