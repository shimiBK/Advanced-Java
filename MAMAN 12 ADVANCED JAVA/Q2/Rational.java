public class Rational {
    private final int num;   // the numerator
    private final int den;   // the denominator

    // create and initialize a new Rational object
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cant be zero");
        }
        else if(denominator < 0 ){
            throw new IllegalArgumentException("Denominator cant be negative number");
        }
        num = numerator;
        den = denominator;

    }
    public boolean greaterThan(Rational b)
    {
        return(this.num * b.den > this.den * b.num);

    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Rational) {
            if(this.num * ((Rational) obj).getDenominator() == this.den * ((Rational) obj).getNumerator()) {
                return true;
            }
        }
        return false;
    }
    //  addition of rational numbers
    public Rational plus(Rational b) {
        int numerator = (this.num * b.den) + (this.den * b.num);
        int denominator = this.den * b.den;
        return new Rational(numerator, denominator);
    }
    //  Subtraction of rational numbers
    public Rational minus(Rational b) {
        int numerator = (this.num * b.den) - (this.den * b.num);
        int denominator = this.den * b.den;
        return new Rational(numerator, denominator);
    }


    //  multiply of rational numbers
    public Rational multiply(Rational b) {
        return new Rational(this.num * b.num, this.den * b.den);
    }

    // division of rational numbers
    public Rational divides(Rational b) {
        int numerator = this.num * b.den;
        int denominator = this.den * b.num;
        return new Rational(numerator,denominator);
    }


    public int getNumerator()
    {
        return this.num;
    }

    public int getDenominator()
    {
        return this.den;
    }

    // return string representation of (this)
    public String toString() {
        if (den == 1) return num + "";
        else return num + "/" + den;
    }


    public Rational reduce(Rational b)
    {
        int g = gcd(b.num, b.den);
        int numerator = b.num / g;
        int denominator = b.den /g;
        return new Rational(numerator,denominator);
    }

    // return gcd(m, n)
    private static int gcd(int m, int n) {
        if (n == 0) return m;
        else return gcd(n, m % n);
    }
}