class sumtest{
	static int sum(int n){
		for(int i=1;i<=n;i++){
			i=i+(i-1);
		}
		return i;
	}

	public static void main(String[] args){
		System.out.println(sum(4));
	}
}
