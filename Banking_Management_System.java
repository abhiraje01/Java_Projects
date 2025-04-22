package banking_management_system;

import java.util.Scanner;

class Bank{
	String accholder;
	int accnumber;
	double balance;
	
	public Bank(String accholder,int accnumber,double balance)
	{
		this.accholder=accholder;
		this.accnumber=accnumber;
		this.balance=balance;
	}
	
	public void deposit(double amount)
	{
		if (amount > 0)
		{
			balance=balance+amount;
			System.out.println("Amount $"+ amount + " Deposited Succesfully.");
		}
		else
		{
			System.out.println("Invalid Deposit Amount");
		}
	}
	public void withdraw(double amount)
	{
		if (amount > 0 && amount <= balance)
		{
			balance=balance-amount;
			System.out.println("Amount of $ "+ amount + "Withdrawal Succesfully" );
		}
		
	}
	
	public void showdetails() {
		System.out.println("============ACCOUNT INFO==============");
		System.out.println("Account Holder: "+ accholder);
		System.out.println("Account Number: "+accnumber);
		System.out.println("Account Balance: "+ balance);
	}
}
public class Banking_Management_System {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Bank b=null;
		
		while(true) {
			System.out.println("=====Banking Operations======");
			System.out.println("1.Create Bank Account");
			System.out.println("2.Deposit Money");
			System.out.println("3.Withdraw Money");
			System.out.println("4.View Account Details");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice: ");
			int choice=sc.nextInt();
			
			
			switch(choice) {
			case 1:
				System.out.println("Enter Account Holder Name: ");
				String name=sc.next();
				System.out.println("Enter Account Number: ");
				int no=sc.nextInt();
				System.out.println("Enter Initial Balance: ");
				double bal=sc.nextDouble();
				b = new Bank(name, no, bal);
				System.out.println("Account Created Succesfully.");
				break;
				
			case 2:
				if(b!=null) {
					System.out.println("Enter Deposite amount: ");
					double bala = sc.nextDouble();
					b.deposit(bala);
					}
				else
				{
					System.out.println("No account found.Please Create your Account First");
				}
				break;
				
			case 3:
				if(b!=null)
				{
					System.out.println("Enter Withdrawal Amount: ");
					double balaa=sc.nextDouble();
					b.withdraw(balaa);
				}
				else 
				{
					System.out.println("No account found.Please Create your Account First");
				}
				break;
				
			case 4:
				if (b!=null)
				{
					b.showdetails();
				}
				else
				{
					System.out.println("No account Details Found");
				}
				break;
			case 5:
				System.out.println("Exiting Thank You For Visit.");
				return;
				
				default:
					System.out.println("Invalid Choice,Enter a Valid Choice");
				
			}
		}
	}

}
