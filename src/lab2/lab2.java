package lab2;

import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a:");
        Point3d a = new Point3d(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("b:");
        Point3d b = new Point3d(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("c:");
        Point3d c = new Point3d(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        System.out.println("Расстояние от а до b:" + String.format("%.2f",Point3d.distanceTo(a, b)));
        System.out.println("Расстояние от b до c:" + String.format("%.2f",Point3d.distanceTo(b, c)));
        System.out.println("Расстояние от c до а:" + String.format("%.2f",Point3d.distanceTo(c, a)));

        if (a.equals(b)| b.equals(c) | c.equals(a))
            System.out.println("Координаты точек одинаковые");
        else
            System.out.println("Площадь треугольника:" + String.format("%.2f",Point3d.computeArea(a, b, c)));
    }
}
