package employee_management_system;

import java.util.Scanner;

class Employee
{
	int empid;
	String Ename;
	String Dept;
	double salary;
	
	public Employee(int empid,String Ename,String Dept,double Salary) {
		this.empid=empid;
		this.Ename=Ename;
		this.Dept=Dept;
		this.salary=Salary;
	}
	public void updatedetails(String Dept,double salary) {
		this.Dept=Dept;
		this.salary=salary;
		System.out.println("Employee details updated Succesfully");
	}
	public void viewdetails() {
		System.out.println("======Employee Details======");
		System.out.println("Employee id: "+ empid);
		System.out.println("Employee Name: " +Ename);
		System.out.println("Employee Dept: "+ Dept);
		System.out.println("Employee Salary: "+ salary);
	}
}

public class Employee_Mnagement_System {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Employee emp=null;
		
		while(true) {
			System.out.println("++++++++++Employee Management++++++++++");
			System.out.println("1.Add Employee Details");
			System.out.println("2.Update Employee");
			System.out.println("3.View Employee");
			System.out.println("4.Exit");
			System.out.println("Enter Your Choice: ");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1: 
				System.out.println("Enter Employee id: ");
				int id=sc.nextInt();
				System.out.println("Enter Employee Name: ");
				String name=sc.next();
				System.out.println("Enter Employee Dept: ");
				String Dept=sc.next();
				System.out.println("Enter Employee Salary: ");
				double salary=sc.nextDouble();
				emp = new Employee(id, name, Dept, salary);
				System.out.println("Employee Added Succesfully");
				break;
				
			case 2:
				System.out.println("Enter New Emp Dept: ");
				String newdept=sc.next();
				System.out.println("Enter new Salary: ");
				double newssalary = sc.nextDouble();
				emp.updatedetails(newdept, newssalary); 
				System.out.println("Employee Updated Succesfully");
				break;
				
			case 3:
				if (emp!=null) {
					emp.viewdetails();
					
				}
				else
				{
					System.out.println("Employee Not Found. Please Add Employee First. Byee!");
				}
				break;
				
			case 4:
				System.out.println("Eiting Thank Youuu!!!");
				return;

			default:
				System.out.println("Invalid Choice.Please Enter a Valid Choice");
			}
			
		}
	}

}
