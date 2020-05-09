package lab2;

public class Point2d {

    private double xCoord; //координата х
    private double yCoord; //координата у

    public Point2d ( double x, double y) { //конструктор инициализации
        xCoord = x;
        yCoord = y;
    }

    public Point2d () { //конструктор по умолчанию
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }

    public double getX () { //возвращение координаты х
        return xCoord;
    }

    public double getY () { //возвращение координаты у
        return yCoord;
    }

    public void setX ( double val) { //установка значения координаты х
        xCoord = val;
    }

    public void setY ( double val) { //установка значения координаты у
        yCoord = val;
    }

    public static void main(String[] args) {
        Point2d myPoint = new Point2d();//создает точку (0,0)
        Point2d myOtherPoint = new Point2d(5, 3);//создает точку (5,3)
        Point2d aThirdPoint = new Point2d();
    }
}
