public class Triangle
{
    private double a, b, c;
    public Error err;

    Triangle(double a, double b, double c)
    {
        if (a + b > c || a + c > b || b + c > a)
        {
            try
            {
                throw new TriangleNotAvaliableException(a, b, c);
            } catch (TriangleNotAvaliableException e)
            {
                this.err = new Error(e.getMessage());
            }
        }
    }
}

class TriangleNotAvaliableException extends RuntimeException
{
    private double a, b, c;
    public TriangleNotAvaliableException() {
        super();
    }

    public TriangleNotAvaliableException(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getMessage() {
        return "Треугольника со сторонами a = " + this.a + ", b = " + this.b +", c = "+ this.c +" не существеут";
    }
}