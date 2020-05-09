package lab2;

public class Point3d {
    private double xCoord; //координата х
    private double yCoord; //координата у
    private double zCoord; //координата z

    public Point3d ( double x, double y, double z) { //конструктор инициализации
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d () { //конструктор по умолчанию
        this(0, 0,0);
    }

    public double getX () { //возвращение координаты х
        return xCoord;
    }

    public double getY () { //возвращение координаты у
        return yCoord;
    }

    public double getZ () { //возвращение координаты z
        return zCoord;
    }

    public void setX ( double val) { //установка значения координаты х
        xCoord = val;
    }

    public void setY ( double val) { //установка значения координаты у
        yCoord = val;
    }

    public void setZ ( double val) { //установка значения координаты z
        zCoord = val;
    }

    public boolean equals(Point3d a){
        return (xCoord==a.xCoord & yCoord==a.yCoord & zCoord==a.zCoord);
    }
    public static double distanceTo(Point3d a, Point3d b){
        double d=Math.sqrt((a.xCoord-b.xCoord)*(a.xCoord-b.xCoord)+(a.yCoord-b.yCoord)*(a.yCoord-b.yCoord)+(a.zCoord-b.zCoord)*(a.zCoord-b.zCoord));
        return d;
    }
    public static double computeArea (Point3d a, Point3d b, Point3d c){
        double m = distanceTo(a,b);
        double n = distanceTo(b,c);
        double k = distanceTo(c,a);
        double p = (m+n+k)/2;
        double s = Math.sqrt(p*(p-m)*(p-n)*(p-k));
        return s;

    }
}
