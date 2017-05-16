//-----------------------------------------------------------
//GCD.java
//Nicholas Ho
//nidho
//pa3
//Finds the GCD of 2 numbers the user inputs
//-----------------------------------------------------------

import java.util.Scanner;

class GCD{
  public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int i,r,m,n;
	int[] in = new int[2];
	int GCD=100;	
	
	for(i=0;i<2;i++){
	System.out.print("Enter a positive integer: ");
	 while(true){
	   while(!sc.hasNextInt()){
	    sc.next();
	    System.out.print("Please enter a positive integer: ");
	 }
	
	
	in[i]=sc.nextInt();
	if(in[i]>0){
	   break;
	}

	  System.out.print("Please enter a positive integer: ");
  	 }
	}
	
	if(in[0]>in[1]){
	 for(m=in[0], n=in[1];m>=1 || n>=1;GCD=m+n){
	 
	  r=n;
	  n=m%n;
	  m=r;
	  if(m==0 || n==0){
	   break;
	  }
	 }
	 }else{
	  for(n=in[0], m=in[1];m>=1 || n>=1;GCD=m+n){
           r=n;
	   n=m%n;
	   m=r;
	   if(n==0 || m==0){
	    break;
	   }          
	  }
	
	 }
	GCD=m+n;
	System.out.print("The GCD of "+ in[0] +" and "+ in[1] +" is "+ GCD);
	System.out.println();
	System.out.println();  
  }
} 

