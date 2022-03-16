import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountPairs {

    //Hi Konstantin!
//

    public static void main(String[] args) throws IOException {
        List list = new ArrayList<Point>();
        list.add(new Point(0, 0));
        list.add(new Point(1, 0));
        list.add(new Point(23, 43));
        System.out.println(CountPairs.countPairs(list, 2));


    }

    public static class Point {
        float x;
        float y;

        Point(int x_, int y_) {
            x = x_;
            y = y_;
        }
    }


    public static int countPairs(List<Point> list, double maxDist) {
        int count = 0;
//         for (Point p1 : list) {
//           for (Point p2 : list) {
//             if (distance(p1, p2) < maxDist) {
//               count++;
//             }
//           }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (distance(list.get(i), list.get(j)) < maxDist) {
                    count++;
                }
            }
        }

         return (count - list.size()) / 2;
//        return count;
    }

    private static double distance(Point p1, Point p2) {
        double dx = (p1.x - p2.x);
        double dy = (p1.y - p2.y);

        return Math.sqrt((dx * dx) + (dy * dy));
        //return
    }
}

/**
 *
 * list = [ A (0,0), B (1,0), D (23, 43) ]
 * maxDist = 2
 **/




