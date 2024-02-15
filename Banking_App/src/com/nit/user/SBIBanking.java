package com.nit.user;

import java.util.Scanner;

import com.nit.exception.InsufficientBalException;
import com.nit.exception.InvalidAmountException;
import com.nit.exception.InvalidPasswordException;
import com.nit.implimentation.SBIBankApp;

public class SBIBanking 
{
	SBIBankApp user1=new SBIBankApp();
	Scanner sc=new Scanner(System.in);
	
	public void SBILogin(BankUser bank)
	{
		System.out.println("Enter your username :");
		String userName=sc.nextLine();
		System.out.println("Enter your password :");
		String password=sc.nextLine();
		try 
		{
			if(user1.login(password,userName))
			{
				SBI();
			}
		}
		catch (InvalidPasswordException e) 
		{
			System.out.println();
			System.err.println(e.getMessage());
		}
	}
	public void SBI()
	{
		System.out.println("Welcome to SBI....");
		int userValue=0;
		while(userValue!=5)
		{
			System.out.println();
			System.out.println();
			System.out.println("Press 1 for deposite ");
			System.out.println("Press 2 for withdraw");
			System.out.println("Press 3 for current balance");
			System.out.println("Press 4 for Loan");
			System.out.println("Press 5 for Logout");
			userValue=sc.nextInt();
			switch(userValue)
			{
				case 1:
					deposite();
					break;
				case 2:
					withdraw();
					break;
				case 3:
					user1.balance();
					break;
				case 4:
					loan();
					break;
				case 5:
					System.exit(0);
				default:
					 System.out.println("Enter Valid Choice");
                     break;
			}
		}
	}
	public void deposite()
	{
		System.out.println("Enter the amount you want to deposite");
		int damount=sc.nextInt();
		try
		{
			user1.deposite(damount);
			System.out.println("Transaction Success");
		} 
		catch (InvalidAmountException e) 
		{
			System.err.println(e.getMessage());
		}
	}
	public void withdraw()
	{
		System.out.println("Enter the amount you want to withdraw");
		 int wamount=sc.nextInt();
		 try 
		 {
			System.out.print("Enter security pin :");
			int pin=sc.nextInt();
				if(user1.securityPin(pin))
				{
					try 
					{
						user1.withdraw(wamount);
						System.out.println("Transaction Success");
					}
					catch (InvalidAmountException e)
					 {
						System.err.println(e.getMessage());
					 }
					catch(InsufficientBalException e)
					 {
						 System.err.println(e.getMessage());
					 }
				}
		 }
		 catch (InvalidPasswordException e)
		 {
			System.err.println(e.getMessage());
		 }
	}
	public void loan()
	{
		System.out.println("Which type of loan do you want ");
		System.out.println("Press 1 for Car loan ");
		System.out.println("Press 2 for Bike loan ");
		System.out.println("Press 3 for Home loan ");
		System.out.println("Press 4 for personal loan ");
		System.out.println("Press 5 for education loan");
		System.out.println("Press 0 for main menu ");
		int loanChoice=sc.nextInt();
		switch(loanChoice)
		{
			case 1:
				carLoan();
				break;
			case 2:
				bikeLoan();
				break;
			case 3:
				homeLoan();
				break;
			case 4:
				personalLoan();
				break;
			case 5:
				educationLoan();
				break;
			case 0:
				break;
		}
	}
	public void bikeLoan()
	{   
		
		System.out.println("Make sure your bike prize is more than 50000 rs and");
		System.out.println("you had bought that after the year 2015");
		System.out.println("You will get 60% of your bike prize as Loan with 2.5% Interest");
		System.out.println("Do you want to continue(yes/no)");
			sc.nextLine();
			String choice=sc.nextLine();
			if(choice.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter how many months do you want this loan");
				double months=sc.nextDouble();
				System.out.print("Enter the prize of your bike :");
				double bikePrize=sc.nextDouble();
				System.out.println();
				System.out.print("At Which year you bought the bike :");
				int bikeYear=sc.nextInt();
				if(bikePrize>50000 && bikeYear>2015)
				{
					double bikeloanAmount;
					bikeloanAmount=0.6*bikePrize;
					try 
					{
							user1.loan(bikeloanAmount);
							System.out.println(bikeloanAmount+" Bike Loan is creadited to your account");
							double interest=(bikeloanAmount*2.5)/100;
							bikeloanAmount=(interest*months)+bikeloanAmount;
							System.out.println("You have to pay "+bikeloanAmount+" rs");
					} 
					catch (InvalidAmountException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.err.println("You are not eligible");
				}
			}
			else if(choice.equalsIgnoreCase("no"))
			{
				return;
			}
			else
			{
				System.err.println("You entered wrong input");
				bikeLoan();
			}
		
	}
	public void carLoan()
	{
		System.out.println("Make sure your car prize is more than 200000 rs and");
		System.out.println("you had bought that after the year 2015");
		System.out.println("You will get 60% of your car prize as Loan with 2% Interest");
		System.out.println("Do you want to continue(yes/no)");
		
			sc.nextLine();
			String choice=sc.nextLine();
			if(choice.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter how many months do you want this loan");
				double months=sc.nextDouble();
				System.out.print("Enter the prize of your bike :");
				double carPrize=sc.nextDouble();
				System.out.println();
				System.out.print("At Which year you bought the bike :");
				int carYear=sc.nextInt();
				if(carPrize>50000 && carYear>2015)
				{
					double carloanAmount;
					carloanAmount=0.6*carPrize;
					try 
					{
							user1.loan(carloanAmount);
							System.out.println(carloanAmount+" rs car Loan is creadited to your account");
							double interest=(carloanAmount*2)/100;
							carloanAmount=(interest*months)+carloanAmount;
							System.out.println("You have to pay "+carloanAmount+" rs");
					} 
					catch (InvalidAmountException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.err.println("You are not eligible");
				}
			}
			else if(choice.equalsIgnoreCase("no"))
			{
				return;
			}
			else
			{
				System.err.println("You entered wrong input");
				carLoan();
			}
	}
	public void homeLoan()
	{
		System.out.println("Make sure your home documents are leagal");
		System.out.println("your home condition should be in better condition");
		System.out.println("You will get 70% of your house leagal prize as Loan with 1.5% Interest");
		System.out.println("Do you want to continue(yes/no)");
		
			sc.nextLine();
			String choice=sc.nextLine();
			if(choice.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter how many months do you want this loan ?");
				double months=sc.nextDouble();
				System.out.print("Enter the leagal prize of your house :");
				double homePrize=sc.nextDouble();
				if(homePrize<1)
				{
					double homeloanAmount;
					homeloanAmount=0.7*homePrize;
					try 
					{
							user1.loan(homeloanAmount);
							System.out.println(homeloanAmount+" rs home Loan is creadited to your account");
							double interest=(homeloanAmount*1.5)/100;
							homeloanAmount=(interest*months)+homeloanAmount;
							System.out.println("You have to pay "+homeloanAmount+" rs");
					} 
					catch (InvalidAmountException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.err.println("You are not eligible");
				}
			}
			else if(choice.equalsIgnoreCase("no"))
			{
				return;
			}
			else
			{
				System.err.println("You entered wrong input");
				homeLoan();
			}
	}
	public void personalLoan()
	{
			System.out.println("You can get this loan if you have job with monthly salary");
			System.out.println("Do you want to proceed");
			sc.nextLine();
			String confirmation=sc.nextLine();
			if(confirmation.equalsIgnoreCase("yes"))
			{
				System.out.print("Enter your age :");
				int age=sc.nextInt();
				if(age>18)
				{
					System.out.print("Enter your salary :");
					double salary=sc.nextDouble();
					if(salary<1)
					{
						double personalloanAmount=salary*12;
						System.out.println("You are eligible for "+personalloanAmount+" rs personal loan");
						System.out.println("You will have 2.5% interest for this loan");
						System.out.println("Do you want to proceed (yes/no)");
						sc.nextLine();
						String choice=sc.nextLine();
						if(choice.equalsIgnoreCase("yes"))
						{
							System.out.println("How many months do you want this loan");
							int months=sc.nextInt();
							try 
							{
								user1.loan(personalloanAmount);
								System.out.println(personalloanAmount+" rs Personal Loan is creadited to your account");
								double interest=(personalloanAmount*2.5)/100;
								personalloanAmount=(interest*months)+personalloanAmount;
								System.out.println("You have to pay "+personalloanAmount+" rs");
							} 
							catch (InvalidAmountException e)
							{
								e.printStackTrace();
							}
						}
					}
					else
					{
						System.err.println("You entered wrong input");
						personalLoan();
					}
				}
				else
				{
					System.out.println("You are not eligible");
				}
			}
			else if(confirmation.equalsIgnoreCase("no"))
			{
				System.out.println("Thank you !");
			}
			else
			{
				System.err.println("Invalid Input");
				personalLoan();
			}
	}
	public void educationLoan()
	{
			System.out.println("Enter your age :");
			int age=sc.nextInt();
			if(age>18)
			{
					System.out.println("We provide maximum 100000 rs loan for Students with min interest 1% only");
					System.out.println("Do you want to proceed (yes/no)");
					sc.nextLine();
					String choice=sc.nextLine();
					if(choice.equalsIgnoreCase("yes"))
					{
						System.out.println("Enter how much loan do you want :");
						double amount=sc.nextDouble();
						if(amount>0 && amount<100000)
						try 
						{
							user1.loan(amount);
							System.out.println(amount+" rs creadited to your account");
							System.out.println("When will you get the job then you have to pay money with total interest");
						} 
						catch (InvalidAmountException e)
						{
							e.printStackTrace();
						}
					}
				}
				else
				{
					System.err.println("You entered wrong input");
					personalLoan();
				}
		}
}






















