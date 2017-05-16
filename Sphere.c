/*Sphere.c  					   */
/*Nicholas Ho					   */
/*nidho						   */
/*lab7 						   */
/*calculates the area and surface area of a sphere */

#include<math.h>
#include<stdio.h>
#include<stdlib.h>

int main(){
	const double pi = 3.141592654;
	double vol, radius,sArea;

	printf("Enter the radius of the sphere: ");
	scanf("%lf", &radius);
	vol=((radius*radius*radius) * pi * (4.0/3.0));
	sArea=(4.0 * pi * (radius*radius));

	printf("The volume is %lf and the surface area is %lf.\n",vol,sArea);
	
	return 0;
}
