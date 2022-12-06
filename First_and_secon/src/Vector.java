import java.lang.Double;
public class Vector extends Segment
{
    private double z;

    Vector(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Triplet getXYZ()
    {
        return new Triplet(this.x, this.y, this.z);
    }

    public void setXYZ(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength()
    {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double scalar(double x, double y, double z)
    {
        double res = this.x/x+this.y/y+this.z/z;
        if (res == Double.POSITIVE_INFINITY) {
            try {
                throw new RuntimeException("попытка деления на ноль");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }
        return res;
    }

    public Vector vectorMult(Vector otherVector)
    {
        Triplet otherVectorValue = otherVector.getXYZ();

        return new Vector(this.y* otherVectorValue.z - this.z * otherVectorValue.y,
                this.z*otherVectorValue.x-otherVectorValue.z*this.y,
                this.x*otherVectorValue.y-this.y*otherVectorValue.x);
    }

    public double Corner(Vector otherVector)
    {
        Triplet otherVectorValue = otherVector.getXYZ();
            double res = scalar(otherVectorValue.x, otherVectorValue.y, otherVectorValue.z)/(
                    vectorLength()*otherVector.vectorLength()
            );
            if (res == Double.POSITIVE_INFINITY) {
                throw new RuntimeException("попытка деления на ноль");
            }

            return res;
    }

    public Vector Sum(Vector otherVector) {
        Triplet otherVectorValue = otherVector.getXYZ();
        return new Vector(this.x+otherVectorValue.x,
                this.y+otherVectorValue.y,
                this.z+otherVectorValue.z);
    }

    public Vector Razn(Vector otherVector)
    {
        Triplet otherVectorValue = otherVector.getXYZ();
        return new Vector(this.x-otherVectorValue.x,
                this.y-otherVectorValue.y,
                this.z-otherVectorValue.z);
    }
}
