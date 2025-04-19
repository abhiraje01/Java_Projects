package student_report_generator;

import java.util.Scanner;

class Student_report
{
	int rollno;
	String name;
	int marks1;
	int marks2;
	int marks3;
	
	public Student_report(int rollno,String name,int marks1,int marks2,int marks3) {
		this.rollno=rollno;
		this.name=name;
		this.marks1=marks1;
		this.marks2=marks2;
		this.marks3=marks3;
	}
	
	int totalmarks() {
		return marks1+marks2+marks3;
	}
	double percentage() {
		return totalmarks()/3.0;
	}
	
	public void showresult()
	{
		System.out.println("======Student Report Card=====");
		System.out.println("Student Name: "+name);
		System.out.println("Student roll no: "+ rollno);
		System.out.println("Here are total Subject Marks:-");
		System.out.println("Subject1: "+marks1);
		System.out.println("Subject2: "+marks2);
		System.out.println("Subject3: "+marks3);
		System.out.println("Total Marks: "+totalmarks());
		System.out.println("Percentage: "+percentage());
		
		if(percentage()>=75) {
			System.out.println("Grade:Distintion");
		}
		else if(percentage()>=60) {
			System.out.println("Grade:First Class");
		}
		else if(percentage()>=50) {
			System.out.println("Grade:Second Class");
		}
		else if(percentage()>=40) {
			System.out.println("Grade:Third Class");
		}
		else if(percentage()>=35) {
			System.out.println("Grade:Pass");
		}
		else {
			System.out.println("Grade:Fail");
			System.out.println("NOTE: You Need To give the Exam Again Try Your Best** All The Best ** !!!");
		}
		if (percentage()>=35) {
			System.out.println("Congratulations For Your Achievement");
		}
		
	}
}

public class Student_Report_card {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student_report s=null;
		
		System.out.println("Enter Roll No: ");
		int roll=sc.nextInt();
		System.out.println("Enter Student Name Without Space: ");
		String name=sc.next();
		System.out.println("Enter Marks For Subject 1: ");
		int marks1=sc.nextInt();
		System.out.println("Enter Marks For Subject 2: ");
		int marks2=sc.nextInt();
		System.out.println("Enter Marks For Subject 3: ");
		int marks=sc.nextInt();
		
		s=new Student_report(roll, name, marks1, marks2, marks);
		s.showresult();
		
		

	}

}
