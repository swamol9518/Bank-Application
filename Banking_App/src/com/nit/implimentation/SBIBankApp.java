package com.nit.implimentation;
import com.nit.exception.InsufficientBalException;
import com.nit.exception.InvalidAmountException;
import com.nit.exception.InvalidPasswordException;
import com.nit.requirement.BankingServices;
public class SBIBankApp implements BankingServices 
{
	private double amount;
	
	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	
	@Override
	public void deposite(int amount) throws InvalidAmountException 
	{
		if(amount<=0) 
		{
			 throw new InvalidAmountException("Sorry! this amount will not be deposited enter valid amount");
		}
		else 
		{ 
			this.amount+=amount;
		}
	}

	@Override
	public void withdraw(int amount) throws InvalidAmountException, InsufficientBalException 
	{
		
		if(amount<=0) 
		{
			 throw new InvalidAmountException("Sorry! You can't withdraw this amount enter valid amount");
		}
		else if(amount>this.amount)
		{
			throw new InsufficientBalException("Insufficient Balance in your account");
		}
		else 
		{ 
			this.amount-=amount;
		}
	}
	
	@Override
	public boolean login(String pwd,String user) throws InvalidPasswordException
	{
		if(pwd.equals("khairnar")&&user.equals("kunal"))
		{
			return true;
		}
		else
		{
			throw new InvalidPasswordException("Invalid Password or Username");
		}
	}

	@Override
	public void balance() 
	{
		System.out.println("Current Balance is :"+this.amount);
	}

	@Override
	public void loan(double amount) throws InvalidAmountException
	{
		if(amount<=0) 
		{
			 throw new InvalidAmountException("Please enter valid amount for the loan");
		}
		else 
		{ 
			this.amount+=amount;  
		}
	}

	@Override
	public boolean securityPin(int pin) throws InvalidPasswordException
	{
		if(pin==1234)
		{
			return true;
		}
		else
		{
			throw new InvalidPasswordException("Invalid Pin");
		}
	}
}