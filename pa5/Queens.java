//---------------------------------------------------------------
//Queens.java
//Nicholas Ho
//nidho
//pa5
//finds all possible locations of n queens that cannot attack each other the next turn.
//---------------------------------------------------------------


import java.util.Scanner;

class Queens{
	
	static void swap(int[] Q, int i, int j){
        	int temp = Q[i];
        	Q[i] = Q[j];
        	Q[j] = temp;
        }
	//reverse the entire array
	static void reverse(int[] T){
        	int i=1, j=T.length-1;
      		while(i<=j){
         	swap(T, i, j);
         	i++;
         	j--;
      		}
   	}
	//reverse part that comes after pivot
        static void partReverse(int[] T,int i){
                int j=T.length-1;
                while(i<=j){
                swap(T, i, j);
                i++;
                j--;
                }
        }
	static void nextPermutation(int[] A){
		int[] rev=new int[A.length];
		int p=0,s=0,temp,pivot=0,successor=0;
		int portion=0;
		for(int i=(A.length-2);i>0;i--){
			if(A[i]<A[i+1]){		
				pivot=A[i];
				p=i;
				portion=i+1;
				break;
			}
		}
		if(pivot==0){
			reverse(A);
			A[0]=1;
			return;
		}
		for(int n=(A.length-1);n>0;n--){
			if(A[n]>pivot){
				successor=A[n];
				s=n;
				break;
			}
		}
		temp=A[p];
		A[p]=A[s];
		A[s]=temp;
		temp=portion;
		while(portion<=A.length-1){
			rev[portion]=A[portion];
			portion++;
		} 
		portion=temp;
		partReverse(rev,portion);
		while(portion<=A.length-1){
			A[portion]=rev[portion];
			portion++;
		}
	}
	static void printArray(int[] P){
		System.out.print("(");
		for(int i=1; i<P.length; i++){
        		if(i==P.length-1){
				System.out.print(P[i]);
			}else{
				System.out.print(P[i]+", ");
			}
      		}
		System.out.print(")");
		System.out.println();
	}
	//test if input can be converted
	static boolean numeric(String str){
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	//Buiding the array
	static int[] board(int[] Q){
		for(int i=1;i<Q.length;i++){
			Q[i]=i;
		}
		return Q;
	}
	static boolean isSolution(int[] A){
		int[] Z=new int[A.length];
		int r,g,h;
		for(int i=1;i<A.length;i++){
			Z[i]=A[i]-i;
		}
		for(int k=1;k<Z.length-1;k++){
			r=k+1;
			while(r<Z.length){
				if(Z[k]!=Z[r]){
					r++;
					continue;
				} else{
					return false;
				}
			}
		}
		for(g=1;g<A.length;g++){
                        Z[g]=A[g]+g;
                }
		for(int p=1;p<Z.length-1;p++){
                        h=p+1;
                        while(h<Z.length){
                                if(Z[p]!=Z[h]){
                                        h++;
                                        continue;
                                } else{
                                        return false;
                                }
                        }
                }
		return true;
	}
	//factorial
	static int permute(int n){
		int s = 1;
		for(int i=1; i<=n; i++){
			s *= i;
		}
		return s;
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int solutions=0,rooks=0,m,n;
		int[] Q;
		boolean v=false;
		if(args.length==0 || args[0].equals("0")){
			System.out.println("Usage: Queens [-v] number");
                        System.out.println("Option:  -v   verbose output, print all solutions");
                        return;
		}
		if(args[0].equals("-v")&&(args.length==2)){
                        v=true;
                }
		if(v==true  && (numeric(args[1])==true) && (Integer.parseInt(args[1])!=0)){
			n=Integer.parseInt(args[1]);
			rooks=permute(n);
			Q=new int[n+1];
			Q=board(Q);
			while(Q[0]==0){
			//for(m=1;m<=rooks;m++){
				if(isSolution(Q)==true){
					printArray(Q);
					solutions++;
				}
				nextPermutation(Q);
			}
			System.out.println(n+"-Queens has "+solutions+" solutions");
		} else if(numeric(args[0])==true){
			n=Integer.parseInt(args[0]);
                        rooks=permute(n);
			Q=new int[n+1];
                        Q=board(Q);
                        while(Q[0]==0){
			//for(m=1;m<=rooks;m++){
                                if(isSolution(Q)==true){
                                        solutions++;
                                }
                                nextPermutation(Q);
                        }
			System.out.println(n+"-Queens has "+solutions+" solutions");
		} else if(args.length==0){
			System.out.println("Usage: Queens [-v] number");
			System.out.println("Option:  -v   verbose output, print all solutions");
			return;
		} else{
                        System.out.println("Usage: Queens [-v] number");
                        System.out.println("Option:  -v   verbose output, print all solutions");
                        return;
                }
	}
} 	
