package lab4;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000; //Максимальное количество итерации

    public void getInitialRange(Rectangle2D.Double range) {// метод позволяет генератору фракталов определить наиболее «интересную» область комплексной плоскости для конкретного фрактала
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    public int numIterations(double x, double y) {    // итеративная функцию для фрактала Мандельброта
        double xn=x;
        double yn=y;
        for (int i=0;i<MAX_ITERATIONS;i++){
            double nextx = xn*xn-yn*yn+x;
            double nexty = 2*xn*yn+y;
            xn=nextx;
            yn=nexty;
            if ((xn*xn+yn*yn)>4) return i;
        }
        return -1;
    }
    public String toString() {
        return "Mandelbrot";
    }
}
