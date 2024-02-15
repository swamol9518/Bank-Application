package com.nit.user;
import java.util.Scanner;
public class BankUser 
{
	public static void main(String[] args)  
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Entre SBI for SBI BANK Services");
			System.out.println("Enter HDFC for HDFC BANK Services");
			System.out.println("enter the choice : ");
			String choice=sc.nextLine();
			if(choice.equalsIgnoreCase("SBI")) 
			{
				new SBIBanking().SBILogin(new BankUser());
			}
			else if(choice.equalsIgnoreCase("HDFC")) 
			{
				new HDFCBanking().HDFCLogin(new BankUser());
			}
			else 
			{
				 System.out.println("Sorry ! Chose SBI or HDFC bank only..");
			}		
		}
	}
}