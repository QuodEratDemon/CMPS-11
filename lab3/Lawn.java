//--------------------------------------------------------------------------------------
//  Lawn.java
//  Nicholas Ho
//  nidho
//  pa1
//  Calculates the  area of a lawn and how long it takes to mow it by inputting info
//--------------------------------------------------------------------------------------

import java.util.Scanner;

class Lawn{
  public static void main( String[] args ){
    double lengthLot;
    double widthLot;
    double lengthHouse;
    double widthHouse;
    double area;
    int n;
    double seconds;
    double rate;
    int h, m, s;
    Scanner sc = new Scanner(System.in);

   // System.out.print("Enter the length and width of the lot, in feet: ");
    lengthLot = sc.nextDouble();
    widthLot = sc.nextDouble();
   // System.out.print("Enter the length and width of the house, in feet: ");
    lengthHouse = sc.nextDouble();
    widthHouse = sc.nextDouble();
    area = (lengthLot*widthLot)-(lengthHouse*widthHouse);
    System.out.println("The lawn area is "+ area +" square feet." );
    

   // System.out.print("Enter the mowing rate, in square feet per second: ");
    rate = sc.nextDouble();
    seconds = (area/rate);
    s = (int) Math.round(seconds);
    m = s/60;
    s = s%60;
    h = m/60;
    m = m%60;
 
    System.out.println("The mowing time is "+ h + (h==1? " hour " : " hours ")+ m + (m==1? " minute " : " minutes ") + s + (s==1? " second. " : " seconds. " )); 
   }
} 


    




