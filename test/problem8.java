class Point{
// Fields
int xcoord;
int ycoord;
// Constructor
Point(int x, int y){
xcoord = x;
ycoord = y;}
// Methods
public String toString(){
return "(" + xcoord + ", " + ycoord + ")";
}
void reflect(){
int temp = xcoord;
xcoord = ycoord;
ycoord = temp;}
boolean isLeftOf(Point P){
return (this.xcoord < P.xcoord);}
boolean isBelow(Point P){
return (this.ycoord < P.ycoord);}
}
//PointTest.java
class problem8{
public static void main( String[] args ){
Point A = new Point(1, 5);
Point B = new Point(2, -3);
Point C = new Point(4, 3);
Point D = new Point(8, 7);
String str1, str2;
A.reflect();
D.reflect();
System.out.println("A = " + A);
System.out.println("B = " + B);
System.out.println("C = " + C);
System.out.println("D = " + D);
str1 = A.isLeftOf(B)?"left":"right";
str2 = C.isBelow(D)?"below":"above";
System.out.println("A is to the " + str1 + " of B");
System.out.println("C is " + str2 + " D");
}
}
