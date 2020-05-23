package distance_calculator;
// 1. Napisz metodę obliczającą i zwracającą odległość pomiędzy dwoma punktami
// różnica pomiędzy punktami = (x2 - x1)2 + (y2 - y1)2
// -> jeżeli punkty są różnych wymiarów, niech metoda zwróci -1

public class DistanceCalculator {

    public double calculateDistance(Point p1, Point p2){
        if(p1.getClass().getName().equals(p2.getClass().getName())) {
            if (p1.getClass().getSimpleName().equals("Point")) {
                return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
            } else {
                return Math.sqrt(Math.pow(p2.getX() + p1.getX(), 2) +
                        Math.pow(p2.getY() - p1.getY(), 2) +
                        Math.pow(((Point3D) p2).getZ() - ((Point3D) p1).getZ(), 2));
            }
        } else {
            return -1;
        }
        }




    public static void main(String[] args) {

        Point p1 = new Point(2,2);
        Point p2 = new Point();

        Point3D p3 = new Point3D(3,4,2);
        Point3D p4 = new Point3D();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        DistanceCalculator dc = new DistanceCalculator();

        System.out.println(dc.calculateDistance(new Point(2,3), new Point(0,1)));
        System.out.println(dc.calculateDistance(new Point3D(2,3,0), new Point3D()));
        System.out.println(dc.calculateDistance(new Point3D(2,3, 0), new Point()));
        System.out.println(dc.calculateDistance(new Point(2,3), new Point3D(0,1,1)));

    }

}
