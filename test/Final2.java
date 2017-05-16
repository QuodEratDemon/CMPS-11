//Final2.java
class Final2{
public static void main(String[] args){
int[][] table = { {3, 9, 6, 12},
{23,-25, 54},
{0,-12, 27, 8, 16} };
System.out.println(getMax(table));
// prints 54
}
static int getMax(int[][] A){
	//System.out.println(A[0].length + "  " + A[1].length);
	int k,max=0;
	for(int i=0; i<A.length; i++){
		for(k=0; k<A[i].length;k++){
			if(max<A[i][k]){
				max=A[i][k];
			}
		}
	}
	return max;
}
}
