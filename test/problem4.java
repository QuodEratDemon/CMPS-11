class problem4{

	public static void main(String[] args){
		int n;
		n=sum(5);
		System.out.println(n);
	}
	
	static int sum(int n){
		if(n>0){
			return n+(sum(n-1));
		}
		else {
			return 0;
		}
	}
}

