//-----------------------------------------------------------
//  Guess.java
//  Nicholas Ho
//  nidho
//  pa2
//  Guess stuff
//-----------------------------------------------------------

import java.util.Scanner;

class Guess{
  public static void main( String[] args ) {
    Scanner sc = new Scanner(System.in);
    int x=0;
    int guess;
    double random;
    String low = "Your guess is too low.";
    String high = "Your guess is too high.";
    boolean next=false;
    boolean next2=false;
    boolean lose=false;

    random= Math.random();
    if(random>=0 && random<0.1){
      x=1;
    }
    if(random>=0.1 && random<0.2){
      x=2;
    }
    if(random>=0.2 && random<0.3){
      x=3;
    }
    if(random>=0.3 && random<0.4){
      x=4;
    }
    if(random>=0.4 && random<0.5){
      x=5;
    }
    if(random>=0.5 && random<0.6){
      x=6;
    }
    if(random>=0.6 && random<0.7){
      x=7;
    }
    if(random>=0.7 && random<0.8){
      x=8;
    }
    if(random>=0.8 && random<0.9){
      x=9;
    }
    if(random>=0.9){
      x=10;
    }

    System.out.println();
    System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
    System.out.println();
    System.out.print("Enter your first guess: ");
    guess = sc.nextInt();
    if(guess==x){
      System.out.println("You win!");
      System.out.println();
      next=false;
    } else if(guess>x) {
      System.out.println(high);
      next=true;
    } else if(guess<x) {
      System.out.println(low);
      next=true;
    }

    if(next==true){
      System.out.println();
      System.out.print("Enter your second guess: ");
      guess = sc.nextInt();
      if(guess==x){
	System.out.println("You win!");
        System.out.println();
	next2=false;
	} else if(guess>x) {
	System.out.println(high);
        next2=true;
        } else if(guess<x) {
        System.out.println(low);
        next2=true;
        }
     }

    if(next2==true){
      System.out.println();
      System.out.print("Enter your third guess: ");
      guess = sc.nextInt();
	if(guess==x){
        System.out.println("You win!");
        System.out.println();
        lose=false;
        } else if(guess>x) {
        System.out.println(high);
        lose=true;
        } else if(guess<x) {
        System.out.println(low);
        lose=true;
        }
      }

    if(lose==true){
      System.out.println();
      System.out.println("You lose. The number was " + x +".");
      System.out.println();
    }
  }
}
    
