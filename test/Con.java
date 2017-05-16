
class Con{
static int[] concatenate(int[] A,int[] B){
	int[] C= new int[A.length+B.length];
	for(int i=0; i<A.length;i++){
		C[i]=A[i];
	}
	for(int k=A.length,g=0 ;k<B.length+A.length;k++){
		C[k]=B[g];
		g++;
	}
	return C;
}
public static void main(String[] args){
	int[] A={0,1,2,3};
	int[] B={4,5,6,7,8};
	int[] C;
	C=concatenate(A,B);
	System.out.println(C.length);
	System.out.println(C[0]+" "+C[1]+" "+C[2]+" "+C[3]+" "+C[4]+" "+C[5]+" "+C[6]+" "+C[7]+" "+C[8]+" ");
}
	
}
