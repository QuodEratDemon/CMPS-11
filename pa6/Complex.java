//----------------------------------------------------------------
//Nicholas Ho
//Complex.java
//nidho
//pa6
//Represents complex numbers as a pair of doubles
//----------------------------------------------------------------

class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   private double re;
   private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String s){
      // Fill in this constructor.
      // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
      // Throw a NumberFormatException if s cannot be parsed as Complex.
	double[] part = new double[2];
        //String s = 
	s.trim();
        String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
        String SGN = "[+-]?";
        String OP =  "\\s*[+-]\\s*";
        String I =   "i";
        String OR =  "|";
        String REAL = SGN+NUM;
        String IMAG = SGN+NUM+"?"+I;
        String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      //return part;
        this.re=part[0];
	this.im=part[1];
   }
   //{


   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
      // -
	double re=this.re;
	double im=this.im;
	return new Complex(re,im);
   }
   
   // add()
   // Return a new Complex representing the sum this plus z.
   Complex add(Complex z){
      // -
	double re=this.re + z.re;
	double im=this.im + z.im;
	return new Complex(re,im);
   }
   
   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
      // -
	double re=this.re*(-1);
	double im=this.im*(-1);
	return new Complex(re,im);
   }

   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      // -
	double re=this.re - z.re;
	double im=this.im - z.im;
	return new Complex(re,im);
   }

   // mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      // -
	double re=(this.re*z.re)-(this.im*z.im);
	double im=(this.re*z.im)+(this.im*z.re);
	return new Complex(re,im);
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
   Complex recip(){
      // -
	double re=this.re /((this.re*this.re)+(this.im*this.im));
	double im=(this.im * (-1))/((this.re*this.re)+(this.im*this.im));
	return new Complex(re,im);
   }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
      // -
	double re=((this.re*z.re)+(this.im*z.im))/((z.re*z.re)+(z.im*z.im));
	double im=((z.re*this.im)-(z.im*this.re))/((z.re*z.re)+(z.im*z.im));
	if(z.equals(Complex.ZERO)){
		throw new ArithmeticException("Exception: / by zero");
	}
	return new Complex(re,im);
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
      // -
	double re=this.re;
	double im=this.im*(-1);
	return new Complex(re,im);
   }
   
   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
   double abs(){
      // -
	return Math.sqrt((this.re*this.re)+(this.im*this.im));
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
   public String toString(){
      // -
	if (this.im<0){
		return (this.re +""+ this.im + "i");
	}
	if (this.im==0){
		return (""+ this.re);
	}
	if (this.re==0){
		return this.im + "i";
	}
	if (this.re==0 && this.im==0){
		return "i";
	}
	else{
		return (this.re + "+" + this.im + "i");
	}
	 
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      // -
	boolean eq=false;
	Complex Q;
	double a,b,c,d;
	if(obj instanceof Complex){
		Q=(Complex)obj;
		a=this.re;
		b=this.im;
		c=Q.re;
		d=Q.im;
		eq=(a==c && b==d);
	}
	return eq;	
	/*if (new Complex(this.re,this.im)==(Complex)obj){
		return true;
	} else{ 
		return false; 
	}*/
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      // -
	return new Complex(a,b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
      // -
	return new Complex(a);
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
      // -
	return new Complex(s);
   }

}
