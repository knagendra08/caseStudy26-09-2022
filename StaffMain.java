package com.gl.caseStudy1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {
	 public static Double totalCalculation (Applicant applicant) {
		 Double sub1=applicant.getSubject1Mark();
		 Double sub2=applicant.getSubjec2Mark();
		 Double sub3=applicant.getSubject3Mark();
		 if (sub1<50 || sub2<50 || sub3<50) {
			 return 0.0;
		 }
		 else {
			 Double total=sub1+sub2+sub3;
			 return total;
		 }
	 }
	 
	 public static Double percentageCalculation (Double total) {
		 Double per= (total/300)*100;
		 DecimalFormat df = new DecimalFormat("0.00");
		 String percentage=df.format(per);
		 return Double.parseDouble(percentage) ;
	 }
	public static void main(String[] args) {
		Integer id=100;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number applicants:");
		Integer n=Integer.parseInt(sc.nextLine());
		List<Applicant> alist=new ArrayList<Applicant>();
		for (int i=0;i<n;i++)
		{
			System.out.println("Enter the applicant details");
			String str=sc.nextLine();
			String[] arr = str.split(",");
			String name=arr[0];
			Double sub1=Double.parseDouble(arr[1]);
			Double sub2=Double.parseDouble(arr[2]);
			Double sub3=Double.parseDouble(arr[3]);
			try {
				if(sub1>100 || sub1<0 || sub2>100 || sub2<0 || sub3>100 || sub3<0 ) {
					throw new MarksException("\nInvalid marks; should be between 0 and 100\n");
				}
			}
			catch (MarksException e) {
				System.out.println(e.getMessage());
				continue;
			}
			Applicant a=new Applicant(name,sub1,sub2,sub3,0.0,0.0);
			a.setId(++id);
			Double total=totalCalculation(a);
			Double percentage=percentageCalculation(total);
			a.setTotal(total);
			if (total==0.0 ||percentage<70.00)
				continue;
			a.setPercentage(percentage);
			alist.add(a);
	}
		System.out.println("Output format");
		alist.forEach((applicant)->System.out.println(applicant));
		

}
}