class reverse{
   
   public static void main(String[] agrs){
      int[] A = {2, 4, 6, 8, 10};
      int[] B;

      printArray(A);
      reverse1(A);
      printArray(A);

      B = reverse1(A);
      printArray(B);
      printArray(A);
   }

   static void printArray(int[] P){
      for(int i=0; i<P.length; i++){
         System.out.print(P[i]+" ");
      }
      System.out.println();
   }

   static void swap(int[] Q, int i, int j){
      int temp = Q[i];
      Q[i] = Q[j];
      Q[j] = temp;
   }

   static void reverse1(int[] T){
      int i=0, j=T.length-1;
      while(i<j){
         swap(T, i, j);
         i++;
         j--;
      }
   }

   static int[] reverse2(int[] S){
      int i, n = S.length;
      int[] R = new int[n];
      for(i=0; i<n; i++){
         R[i] = S[n-1-i];
      }
      return R;
   }

}
