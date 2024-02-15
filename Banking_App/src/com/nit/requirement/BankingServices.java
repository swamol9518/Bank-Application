package com.nit.requirement;
import com.nit.exception.InsufficientBalException;
import com.nit.exception.InvalidAmountException;
import com.nit.exception.InvalidPasswordException;
public interface BankingServices 
{
	public void deposite(int amount) throws InvalidAmountException;
	public void withdraw(int amount) throws InvalidAmountException, InsufficientBalException;
	public void balance();
	public void loan(double amount) throws InvalidAmountException;
	public boolean securityPin(int pin)throws InvalidPasswordException;
	public boolean login(String pwd,String user) throws InvalidPasswordException;
}