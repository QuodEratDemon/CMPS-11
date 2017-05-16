//-----------------------------------------------------------
// Roots.java
// Nicholas Ho
// nidho
// pa4
// Finds roots of numbers 
//-----------------------------------------------------------

import java.util.Scanner;

class Roots{

	/*static double Root(double[] C,a,b,tolerance){
		double a = 0.0, b = 10.0, eps = 0.00001;
        	double root = 0.0 , residual;
        	while ( b - a > eps ) {
			root = (a + b) / 2.0;
        		residual = (root*root-(poly(C);
        		if (residual > 0)
         			b = root; 
        		else
           			a = root;
	
			}
			return(root);
	}*/ 	
	
	static double power(double base, int ex){
		double exp=base;
		for(int gg=1;gg<ex;gg++){
			base=base*exp;
		}
		if(ex==0){
			base=1;
		}
		return base;
	}
	static double abso(double val){
		if(val<0){
			val=((-1)*(val));
		}
		return val;
	}
	static double poly(double[] C, double x){
		int n=C.length;
		double pol=0.0;
		for(int r=0;r<n;r++){
                        pol+=C[r]*power(x,r);
		}
		
		return pol;
	}
	static double[] diff(double[] C){
		double[] D= new double[C.length-1];
		for(int deriv=(D.length-1);deriv>=0;deriv--){
			D[deriv]=C[deriv+1]*(deriv+1);
		}
		return D;
	}
	static double findRoot(double[] C, double a, double b, double tolerance){	
		double mid=0.0, width;
		for( width=b-a;width>tolerance;width=b-a){
			mid = (a+b)/2;
			if( ((poly(C,a)<0)&&(poly(C,mid)<0))||((poly(C,a)>0)&&(poly(C,mid)>0)) ){
                		a = mid;
			}else if(((poly(C,a)<0)&&(poly(C,mid)>0))||((poly(C,a)>0)&&(poly(C,mid)<0))){
            			b = mid;
         		}
      		}
		return mid;
	}	

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double[] c;
		double[] realRoot;
		double[] d;
		double resolution=0.01, tolerance=0.0000001, threshold=0.001;
		double z,n,root;
		int degree,m,i,k,x,y,L,R;
		
		System.out.print("Enter the degree: ");
		degree=sc.nextInt();
		k=degree+1;
		c=new double[k];
		System.out.print("Enter " +k+ " coefficients: ");
		for(i=0;i<k;i++){
			c[i]=sc.nextInt();
		}
		
		System.out.print("Enter the left and right endpoints: ");
		L=sc.nextInt();
		R=sc.nextInt();
		System.out.println();
		d=diff(c);
		int cr=0;
		/*root=findRoot(c,L,R,tolerance);
		if(root<0){
			System.out.print("Root found at ");
			System.out.printf("%.5f%n",root);*/
                for(double sub=resolution,b=sub+L,a=L;b<=R;sub+=resolution){
			
			if((poly(c,a)>0 && poly(c,b)>0) || (poly(c,a)<0 && poly(c,b)<0)){
                        	if((poly(d,a)<0 && poly(d,b)>0) || (poly(d,a)>0 && poly(d,b)<0)){
					root=findRoot(c,a,b,tolerance);
					if((abso(root)<threshold)){	
						System.out.print("Root found at ");
						System.out.printf("%.5f%n",root);
						cr++;
						 
					}
				}
                	} else if((poly(c,a)>0 && poly(c,b)<0) || (poly(c,a)<0 && poly(c,b)>0)){
				
				root=findRoot(c,a,b,tolerance);
				if((root!=0)&&(c[0]!=0)){
				System.out.print("Root found at ");
				System.out.printf("%.5f%n",root);
				cr++;
				}
			} 
			if(poly(c,a)==0){
				System.out.print("Root found at ");
                                System.out.printf("%.5f%n",a);
			} else if(poly(c,b)==0){
				System.out.print("Root found at ");
                                System.out.printf("%.5f%n",b);
				}
			a=b;
			b=a+resolution;
		}
		if(cr==0){
			System.out.println("No roots were found in the specified range.");
		}	
	}
}		
